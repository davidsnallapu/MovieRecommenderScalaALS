import org.apache.log4j._
import org.apache.spark.ml.recommendation.{ALS, ALSModel}
import org.apache.spark.sql.functions.{col, desc, explode}
import org.apache.spark.sql.{DataFrame, SparkSession}

object MovieRecommenderALS {

    def getSparsity(ratings: DataFrame): Unit ={
      //Counting the total no of ratings in dataset
      val countNonZero = ratings.select("rating").count()

      //Counting total possible elements for utility matrix
      val total = ratings.select("userId").distinct().count() * ratings.select("movieId").distinct().count()

      //Calculating the sparsity
      val sparsityRatings = (1- (countNonZero.toFloat/total.toFloat))*100

      println("The Sparsity of the dataset is "+sparsityRatings.toFloat)
    }

    //Main function
    def main(args: Array[String]) {
      // Set the log level to only print errors
      Logger.getLogger("org").setLevel(Level.ERROR)

      //Creating a Spark Session to use every core of the machine
      val spark = SparkSession.builder().appName("MovieRecommenderALS").master("local[*]").getOrCreate()
      import spark.implicits._

      println("Loading Data ...")

      //Loading Movie Data
      val movies = spark.read.options(Map("inferSchema"->"true","delimiter"->",", "header"-> "true")).csv("../MovieRecommendationSparkALS/MovieData/movies.csv").toDF()
      //Loading Rating Data
      val ratings = spark.read.options(Map("inferSchema"->"true","delimiter"->",", "header"-> "true")).csv("../MovieRecommendationSparkALS/MovieData/ratings.csv").toDF()
      ratings.show()

      //Joining both Dataframes to add movie data into ratings
      val movie_ratings = ratings.join(movies,Seq("movieId"), "left")
      movie_ratings.show()
      movie_ratings.printSchema()

      //Getting Sparsity
      getSparsity(movie_ratings)

      //Create training and testing set
      val Array(train, test) = ratings.randomSplit(Array(0.8, 0.2), seed = 2020)

      //Building an ALS Model
      val als = new ALS()
        .setUserCol("userId")
        .setItemCol("movieId")
        .setRatingCol("rating")
        .setNonnegative(true) //We are looking at rating > 0
        .setImplicitPrefs(false) //We are working with explicit ratings
        .setColdStartStrategy("drop") //We ensure we dont get NaN evaluation metrics
        .setMaxIter(10)
        .setRegParam(0.16)
        .setRank(16)

      //First we do hyperparameter tuning and cross validation

      //    val paramGrid = new ParamGridBuilder()
      //      .addGrid(als.rank, Array(10, 50, 100, 150))
      //      .addGrid(als.regParam, Array(.01, .05, .1, .15))
      //      .build()
      //
      //    val evaluator = new RegressionEvaluator()
      //      .setMetricName("rmse")
      //      .setLabelCol("rating")
      //      .setPredictionCol("prediction")

      //    print ("Models to be tested: ", paramGrid.length)

      //Building CrossValidator
      //    val cv = new CrossValidator()
      //      .setEstimator(als)
      //      .setEstimatorParamMaps(paramGrid)
      //      .setEvaluator(evaluator)
      //      .setNumFolds(5)

      //Fit cross validator to the 'train' dataset
      //    val model = cv.fit(train)
      val model = als.fit(train)
      //Extract best model from the cv model above
      //    val bestModelALS = model.bestModel.asInstanceOf[ALSModel]

      //View the predictions
      //    val testPredictions = bestModelALS.transform(test)
      //    val rmse = evaluator.evaluate(testPredictions)
      //    print("RMSE is "+rmse)

      //Making Recommendations
      // Let us make 5 recommendations for all users
      //    val recommendations = bestModelALS.recommendForAllUsers(5)
      val recommendations = model.recommendForAllUsers(5)
      recommendations.show()

      //Adding movie name and Genre
      val nrecommendations = recommendations
        .withColumn("rec_exp", explode($"recommendations"))
        .select(col("userId"), col("rec_exp.movieId"), col("rec_exp.rating"))
      nrecommendations.limit(10).show()

      //Looking at User ID = 100
      nrecommendations
        .join(movies,Seq("movieId"))
        .filter($"userId" === 100).show()

      //Looking at Actual Preference
      ratings.join(movies, Seq("movieId")).filter($"userId" === 100).sort( col("rating").desc ).limit(10).show()

      println("Done ...")
      spark.stop()

    }
  }

