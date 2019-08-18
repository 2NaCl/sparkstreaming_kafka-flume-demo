package com.fyj

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.kafka.KafkaUtils

object streamingKafka {

    def main(args: Array[String]): Unit = {
      var Array(zkQuorm,group,topics,numThreads) = args

      var sc = new SparkConf().setAppName("kafka").setMaster("local[*]")
      var ssc = new StreamingContext(sc,Seconds(5))

      val topicMap = topics.split(",").map((_,numThreads.toInt)).toMap

      val messages = KafkaUtils.createStream(ssc,zkQuorm,group,topicMap)

      messages.map(_._2).count().print()
      ssc.start()
      ssc.awaitTermination()


    }
}
