import com.signifyd.modeletl.spark.hive.InvestigationMvTables
import com.signifyd.modeletl.spark.ModelEtlSparkContext

val configFiles = spark.conf.getOption("spark.signifyd.CONFIG").getOrElse("/nfs/spark/cfg.yml,/nfs/spark/cfg-cassandra-prod.yml,/nfs/spark/cfg.CurrentTables.yml").split(",")
println(configFiles)
implicit val modelEtlSparkContext = new ModelEtlSparkContext(configFiles)
implicit val spark = modelEtlSparkContext.spark

val tables = new InvestigationMvTables()
tables.investigationMvHoodie.getDataset.createOrReplaceTempView("investigation_mv")
tables.rawHoodie.getDataset.createOrReplaceTempView("investigation_raw")
tables.orderKeysHoodie.getDataset.createOrReplaceTempView("order_history")
