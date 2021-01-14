# MovieRecommenderScalaALS
Movie Recommendation Engine with ALS and implemented with Scala and Spark

# Expected Output

Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties<br>
Loading Data ...<br>
+------+-------+------+---------+<br>
|userId|movieId|rating|timestamp|<br>
+------+-------+------+---------+<br>
|     1|      1|   4.0|964982703|<br>
|     1|      3|   4.0|964981247|<br>
|     1|      6|   4.0|964982224|<br>
|     1|     47|   5.0|964983815|<br>
|     1|     50|   5.0|964982931|<br>
|     1|     70|   3.0|964982400|<br>
|     1|    101|   5.0|964980868|<br>
|     1|    110|   4.0|964982176|<br>
|     1|    151|   5.0|964984041|<br>
|     1|    157|   5.0|964984100|<br>
|     1|    163|   5.0|964983650|<br>
|     1|    216|   5.0|964981208|<br>
|     1|    223|   3.0|964980985|<br>
|     1|    231|   5.0|964981179|<br>
|     1|    235|   4.0|964980908|<br>
|     1|    260|   5.0|964981680|<br>
|     1|    296|   3.0|964982967|<br>
|     1|    316|   3.0|964982310|<br>
|     1|    333|   5.0|964981179|<br>
|     1|    349|   4.0|964982563|<br>
+------+-------+------+---------+<br>
<br>only showing top 20 rows<br>
<br>
+-------+------+------+---------+--------------------+--------------------+<br>
|movieId|userId|rating|timestamp|               title|              genres|<br>
+-------+------+------+---------+--------------------+--------------------+<br>
|      1|     1|   4.0|964982703|    Toy Story (1995)|Adventure|Animati...|<br>
|      3|     1|   4.0|964981247|Grumpier Old Men ...|      Comedy|Romance|<br>
|      6|     1|   4.0|964982224|         Heat (1995)|Action|Crime|Thri...|<br>
|     47|     1|   5.0|964983815|Seven (a.k.a. Se7...|    Mystery|Thriller|<br>
|     50|     1|   5.0|964982931|Usual Suspects, T...|Crime|Mystery|Thr...|<br>
|     70|     1|   3.0|964982400|From Dusk Till Da...|Action|Comedy|Hor...|<br>
|    101|     1|   5.0|964980868|Bottle Rocket (1996)|Adventure|Comedy|...|<br>
|    110|     1|   4.0|964982176|   Braveheart (1995)|    Action|Drama|War|<br>
|    151|     1|   5.0|964984041|      Rob Roy (1995)|Action|Drama|Roma...|<br>
|    157|     1|   5.0|964984100|Canadian Bacon (1...|          Comedy|War|<br>
|    163|     1|   5.0|964983650|    Desperado (1995)|Action|Romance|We...|<br>
|    216|     1|   5.0|964981208|Billy Madison (1995)|              Comedy|<br>
|    223|     1|   3.0|964980985|       Clerks (1994)|              Comedy|<br>
|    231|     1|   5.0|964981179|Dumb & Dumber (Du...|    Adventure|Comedy|<br>
|    235|     1|   4.0|964980908|      Ed Wood (1994)|        Comedy|Drama|<br>
|    260|     1|   5.0|964981680|Star Wars: Episod...|Action|Adventure|...|<br>
|    296|     1|   3.0|964982967| Pulp Fiction (1994)|Comedy|Crime|Dram...|<br>
|    316|     1|   3.0|964982310|     Stargate (1994)|Action|Adventure|...|<br>
|    333|     1|   5.0|964981179|    Tommy Boy (1995)|              Comedy|<br>
|    349|     1|   4.0|964982563|Clear and Present...|Action|Crime|Dram...|<br>
+-------+------+------+---------+--------------------+--------------------+<br>
only showing top 20 rows<br>
<br>
root<br>
 |-- movieId: integer (nullable = true)<br>
 |-- userId: integer (nullable = true)<br>
 |-- rating: double (nullable = true)<br>
 |-- timestamp: integer (nullable = true)<br>
 |-- title: string (nullable = true)<br>
 |-- genres: string (nullable = true)<br>
<br>
The Sparsity of the dataset is 98.30003<br>

+------+--------------------+<br>
|userId|     recommendations|<br>
+------+--------------------+<br>
|   471|[[3379, 4.8148437...|<br>
|   463|[[3379, 4.9674172...|<br>
|   496|[[3379, 4.5606737...|<br>
|   148|[[33649, 4.669161...|<br>
|   540|[[3379, 5.482804]...|<br>
|   392|[[6818, 5.0308475...|<br>
|   243|[[86347, 5.546531...|<br>
|    31|[[33649, 5.224481...|<br>
|   516|[[3379, 5.11689],...|<br>
|   580|[[59018, 4.848294...|<br>
|   251|[[3379, 5.90461],...|<br>
|   451|[[3379, 5.5624623...|<br>
|    85|[[1140, 4.8315673...|<br>
|   137|[[3379, 5.106894]...|<br>
|    65|[[3379, 4.9053884...|<br>
|   458|[[67618, 5.509022...|<br>
|   481|[[6818, 3.9491134...|<br>
|    53|[[33649, 6.728327...|<br>
|   255|[[1194, 4.316224]...|<br>
|   588|[[3379, 4.490601]...|<br>
+------+--------------------+<br>
only showing top 20 rows<br>
<br>
+------+-------+---------+<br>
|userId|movieId|   rating|<br>
+------+-------+---------+<br>
|   471|   3379|4.8148437|<br>
|   471|   6818|4.5223584|<br>
|   471|   7096|4.4600205|<br>
|   471|   6442|4.4378443|<br>
|   471|  92494| 4.425663|<br>
|   463|   3379|4.9674172|<br>
|   463|  33649|4.9601493|<br>
|   463|  60943|4.8005013|<br>
|   463|  59018|4.8005013|<br>
|   463| 171495| 4.788889|<br>
+------+-------+---------+<br>

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
