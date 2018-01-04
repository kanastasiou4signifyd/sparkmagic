import com.signifyd.modeletl.spark.ModelEtlSparkContext

implicit val    modelEtlSparkContext = new ModelEtlSparkContext(spark, Array("/nfs/spark/cfg.yml",
                                                                             "/nfs/spark/cfg-cassandra-prod.yml",
                                                                             "/nfs/spark/cfg.CurrentTables.yml"))
implicit val _spark = modelEtlSparkContext.spark

val hoodieInc = new com.signifyd.modeletl.spark.hive.InvestigationMvHoodieIncremental()
hoodieInc.tables.investigationMvHoodie.getDataset.createOrReplaceTempView("investigation_mv")
hoodieInc.tables.rawHoodie.getDataset.createOrReplaceTempView("investigation_raw")
hoodieInc.tables.orderKeysHoodie.getDataset.createOrReplaceTempView("order_history")

val df = spark.read.orc("s3://com.signifyd.model.hive/tmp/new_raw/raw/data_source=signifyd/data_date=20171101/_VERSION=1510164098224")
df.createOrReplaceTempView("junk")
