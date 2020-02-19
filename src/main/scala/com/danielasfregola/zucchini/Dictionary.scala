package com.danielasfregola.zucchini

import scala.io.Source

object Dictionary extends App {

  def extractUniqueWordsFromTextFile(filename: String): Set[String] = {
    val source = Source.fromResource(filename)
    val texts: Iterator[String] = source.getLines()
    val allUniqueWords: Set[String] = allWords(texts).toSet
    source.close()
    allUniqueWords
  }

  private def allWords(texts: Iterator[String]): Iterator[String] = {
    texts.flatMap(line => line.split("\\W+"))
  }

  println(extractUniqueWordsFromTextFile("BaconipSum.txt").mkString(","))

}
