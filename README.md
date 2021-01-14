# MovieRecommenderScalaALS
Movie Recommendation Engine with ALS and implemented with Scala and Spark


# Expected Output
<br>
<img src="https://github.com/davidnallapu/MovieRecommenderScalaALS/blob/main/o:p.png" alt="Logo" width="400" height="400">
<br>

+-------+------+---------+--------------------+--------------------+<br>
|movieId|userId|   rating|               title|              genres|<br>
+-------+------+---------+--------------------+--------------------+<br>
|  33649|   100| 5.315578|  Saving Face (2004)|Comedy|Drama|Romance|<br>
|  67618|   100|5.2834616|Strictly Sexual (...|Comedy|Drama|Romance|<br>
|  77846|   100|5.0708103| 12 Angry Men (1997)|         Crime|Drama|<br>
|   7121|   100|5.0650034|   Adam's Rib (1949)|      Comedy|Romance|<br>
|  72171|   100| 5.056898|Black Dynamite (2...|       Action|Comedy|<br>
+-------+------+---------+--------------------+--------------------+<br>

+-------+------+------+----------+--------------------+--------------------+<br>
|movieId|userId|rating| timestamp|               title|              genres|<br>
+-------+------+------+----------+--------------------+--------------------+<br>
|   1101|   100|   5.0|1100184137|      Top Gun (1986)|      Action|Romance|<br>
|   1958|   100|   5.0|1100186258|Terms of Endearme...|        Comedy|Drama|<br>
|   2423|   100|   5.0|1100186118|Christmas Vacatio...|              Comedy|<br>
|   4041|   100|   5.0|1100184235|Officer and a Gen...|       Drama|Romance|<br>
|   5620|   100|   5.0|1100186982|Sweet Home Alabam...|      Comedy|Romance|<br>
|    368|   100|   4.5|1100183774|     Maverick (1994)|Adventure|Comedy|...|<br>
|    934|   100|   4.5|1100186407|Father of the Bri...|              Comedy|<br>
|    539|   100|   4.5|1100184295|Sleepless in Seat...|Comedy|Drama|Romance|<br>
|     16|   100|   4.5|1100185959|       Casino (1995)|         Crime|Drama|<br>
|    553|   100|   4.5|1100183810|    Tombstone (1993)|Action|Drama|Western|<br>
+-------+------+------+----------+--------------------+--------------------+<br>
<br>
Done ...<br>
<br>

Sources : <br>
1. https://spark.apache.org/docs/latest/ml-tuning.html#cross-validation<br>
2. StackOverFlow <br>
3. https://sparkbyexamples.com/<br>
4. https://towardsdatascience.com/build-recommendation-system-with-pyspark-using-alternating-least-squares-als-matrix-factorisation-ebe1ad2e7679<br>
