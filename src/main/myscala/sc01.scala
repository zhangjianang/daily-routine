//package scala
//
//import java.io.{BufferedReader, InputStreamReader}
//import java.text.SimpleDateFormat
//import java.util.Date
//import java.util.regex.Pattern
//
//
///**
//  * Created by Administrator on 2017/5/5.
//  */
//object Sc01 {
//
//  val oneDay = 86400000
//
//  def main(args: Array[String]): Unit = {
//
//
//
//    val endtime =  getThisDay(new Date().getTime)
//    val starttime = endtime - oneDay
//
//
//    val spark = SparkSession.builder.appName("insertNewBi")
//      /* .master("local")*/
//      .enableHiveSupport()
//      .config("hive.exec.dynamic.partition.mode","nonstrict")
//      .config("hive.exec.dynamic.partition","true")
//      .getOrCreate
//
//    spark.sql("use newbi")
//
//    val br = new BufferedReader(new InputStreamReader(TestScaLa.getClass.getClassLoader.getResourceAsStream("dbtablesload.txt")))
//    var line = br.readLine()
//
//    try{
//      while (line != null) {
//
//        val splits = line.split(Pattern.quote(":"))
//        val datatable = splits(0)
//        var tablename = ""
//        var searchCol = ""
//        var insertCol = ""
//        val tcs = splits(1).split(Pattern.quote("*"))
//        tablename = tcs(0)
//        searchCol = tcs(1)
//        insertCol = tcs(2)
//
//
//        println(datatable +" : "+tablename+" : "+searchCol +" : "+insertCol)
//
//
//        val jdbcDF = spark.read.format("jdbc")
//          .option("url", "jdbc:mysql://192.168.0.77:3306/"+datatable)
//          .option("dbtable", tablename)
//          .option("user", "ingage")
//          .option("password", "ingage").load
//
//        spark.udf.register("tt", tt _)
//        jdbcDF.createOrReplaceTempView("aa")
//
//
//
//        val newsql = spark.sql("select distinct tt("+insertCol+") updated_at_string from aa where "+searchCol+" >= "+starttime+" and "+searchCol+"<"+endtime+"  ")
//
//        val arrayTimes = newsql.collect()
//
//
//        for(time <-arrayTimes){
//
//          val dayDF = spark.read.format("jdbc")
//            .option("url", "jdbc:mysql://192.168.0.77:3306/"+datatable)
//            .option("dbtable", tablename)
//            .option("user", "ingage")
//            .option("password", "ingage").load
//
//
//          dayDF.createOrReplaceTempView("bb")
//          println(time.getString(0))
//          //val df =  spark.sql("select * from bb where "+searchCol+" >= "+starttime+" and "+searchCol+"<"+endtime+" and tt(bb."+insertCol+")='"+time.getString(0)+"'")
//          //println(tablename +" : "+time +" : "+ df.count())
//          spark.sql("insert into "+tablename+" partition(updated_at_string='"+time.getString(0)+"') select * from bb where "+searchCol+" >= "+starttime+" and "+searchCol+"<"+endtime+" and tt(bb."+insertCol+")='"+time.getString(0)+"'")
//        }
//
//
//
//        line = br.readLine()
//      }
//    }catch {
//      case ex : Exception =>  ex.printStackTrace()
//    }finally {
//      try{
//        //is.close()
//        br.close()
//      }catch {
//        case ex: Exception =>
//      }
//
//    }
//
//
//  }
//
//  def tt(time: Long): String = {
//    val dateFormat = new SimpleDateFormat("yyyyMMdd")
//    val format = dateFormat.format(new Date(time))
//    format
//  }
//
//  def getThisDay(getTime: Long) : Long = {
//
//    (getTime/oneDay) * oneDay
//  }
//
//}
