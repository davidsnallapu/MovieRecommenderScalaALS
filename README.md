# MovieRecommenderScalaALS
Movie Recommendation Engine with ALS and implemented with Scala and Spark

# Expected Output

Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
Loading Data ...
+------+-------+------+---------+
|userId|movieId|rating|timestamp|
+------+-------+------+---------+
|     1|      1|   4.0|964982703|
|     1|      3|   4.0|964981247|
|     1|      6|   4.0|964982224|
|     1|     47|   5.0|964983815|
|     1|     50|   5.0|964982931|
|     1|     70|   3.0|964982400|
|     1|    101|   5.0|964980868|
|     1|    110|   4.0|964982176|
|     1|    151|   5.0|964984041|
|     1|    157|   5.0|964984100|
|     1|    163|   5.0|964983650|
|     1|    216|   5.0|964981208|
|     1|    223|   3.0|964980985|
|     1|    231|   5.0|964981179|
|     1|    235|   4.0|964980908|
|     1|    260|   5.0|964981680|
|     1|    296|   3.0|964982967|
|     1|    316|   3.0|964982310|
|     1|    333|   5.0|964981179|
|     1|    349|   4.0|964982563|
+------+-------+------+---------+
only showing top 20 rows

+-------+------+------+---------+--------------------+--------------------+
|movieId|userId|rating|timestamp|               title|              genres|
+-------+------+------+---------+--------------------+--------------------+
|      1|     1|   4.0|964982703|    Toy Story (1995)|Adventure|Animati...|
|      3|     1|   4.0|964981247|Grumpier Old Men ...|      Comedy|Romance|
|      6|     1|   4.0|964982224|         Heat (1995)|Action|Crime|Thri...|
|     47|     1|   5.0|964983815|Seven (a.k.a. Se7...|    Mystery|Thriller|
|     50|     1|   5.0|964982931|Usual Suspects, T...|Crime|Mystery|Thr...|
|     70|     1|   3.0|964982400|From Dusk Till Da...|Action|Comedy|Hor...|
|    101|     1|   5.0|964980868|Bottle Rocket (1996)|Adventure|Comedy|...|
|    110|     1|   4.0|964982176|   Braveheart (1995)|    Action|Drama|War|
|    151|     1|   5.0|964984041|      Rob Roy (1995)|Action|Drama|Roma...|
|    157|     1|   5.0|964984100|Canadian Bacon (1...|          Comedy|War|
|    163|     1|   5.0|964983650|    Desperado (1995)|Action|Romance|We...|
|    216|     1|   5.0|964981208|Billy Madison (1995)|              Comedy|
|    223|     1|   3.0|964980985|       Clerks (1994)|              Comedy|
|    231|     1|   5.0|964981179|Dumb & Dumber (Du...|    Adventure|Comedy|
|    235|     1|   4.0|964980908|      Ed Wood (1994)|        Comedy|Drama|
|    260|     1|   5.0|964981680|Star Wars: Episod...|Action|Adventure|...|
|    296|     1|   3.0|964982967| Pulp Fiction (1994)|Comedy|Crime|Dram...|
|    316|     1|   3.0|964982310|     Stargate (1994)|Action|Adventure|...|
|    333|     1|   5.0|964981179|    Tommy Boy (1995)|              Comedy|
|    349|     1|   4.0|964982563|Clear and Present...|Action|Crime|Dram...|
+-------+------+------+---------+--------------------+--------------------+
only showing top 20 rows

root
 |-- movieId: integer (nullable = true)
 |-- userId: integer (nullable = true)
 |-- rating: double (nullable = true)
 |-- timestamp: integer (nullable = true)
 |-- title: string (nullable = true)
 |-- genres: string (nullable = true)

The Sparsity of the dataset is 98.30003
21/01/14 15:29:52 WARN BLAS: Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
21/01/14 15:29:52 WARN BLAS: Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
+------+--------------------+
|userId|     recommendations|
+------+--------------------+
|   471|[[3379, 4.8148437...|
|   463|[[3379, 4.9674172...|
|   496|[[3379, 4.5606737...|
|   148|[[33649, 4.669161...|
|   540|[[3379, 5.482804]...|
|   392|[[6818, 5.0308475...|
|   243|[[86347, 5.546531...|
|    31|[[33649, 5.224481...|
|   516|[[3379, 5.11689],...|
|   580|[[59018, 4.848294...|
|   251|[[3379, 5.90461],...|
|   451|[[3379, 5.5624623...|
|    85|[[1140, 4.8315673...|
|   137|[[3379, 5.106894]...|
|    65|[[3379, 4.9053884...|
|   458|[[67618, 5.509022...|
|   481|[[6818, 3.9491134...|
|    53|[[33649, 6.728327...|
|   255|[[1194, 4.316224]...|
|   588|[[3379, 4.490601]...|
+------+--------------------+
only showing top 20 rows

+------+-------+---------+
|userId|movieId|   rating|
+------+-------+---------+
|   471|   3379|4.8148437|
|   471|   6818|4.5223584|
|   471|   7096|4.4600205|
|   471|   6442|4.4378443|
|   471|  92494| 4.425663|
|   463|   3379|4.9674172|
|   463|  33649|4.9601493|
|   463|  60943|4.8005013|
|   463|  59018|4.8005013|
|   463| 171495| 4.788889|
+------+-------+---------+

+-------+------+---------+--------------------+--------------------+
|movieId|userId|   rating|               title|              genres|
+-------+------+---------+--------------------+--------------------+
|  33649|   100| 5.315578|  Saving Face (2004)|Comedy|Drama|Romance|
|  67618|   100|5.2834616|Strictly Sexual (...|Comedy|Drama|Romance|
|  77846|   100|5.0708103| 12 Angry Men (1997)|         Crime|Drama|
|   7121|   100|5.0650034|   Adam's Rib (1949)|      Comedy|Romance|
|  72171|   100| 5.056898|Black Dynamite (2...|       Action|Comedy|
+-------+------+---------+--------------------+--------------------+

+-------+------+------+----------+--------------------+--------------------+
|movieId|userId|rating| timestamp|               title|              genres|
+-------+------+------+----------+--------------------+--------------------+
|   1101|   100|   5.0|1100184137|      Top Gun (1986)|      Action|Romance|
|   1958|   100|   5.0|1100186258|Terms of Endearme...|        Comedy|Drama|
|   2423|   100|   5.0|1100186118|Christmas Vacatio...|              Comedy|
|   4041|   100|   5.0|1100184235|Officer and a Gen...|       Drama|Romance|
|   5620|   100|   5.0|1100186982|Sweet Home Alabam...|      Comedy|Romance|
|    368|   100|   4.5|1100183774|     Maverick (1994)|Adventure|Comedy|...|
|    934|   100|   4.5|1100186407|Father of the Bri...|              Comedy|
|    539|   100|   4.5|1100184295|Sleepless in Seat...|Comedy|Drama|Romance|
|     16|   100|   4.5|1100185959|       Casino (1995)|         Crime|Drama|
|    553|   100|   4.5|1100183810|    Tombstone (1993)|Action|Drama|Western|
+-------+------+------+----------+--------------------+--------------------+

Done ...

Process finished with exit code 0
