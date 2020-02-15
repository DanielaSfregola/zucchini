package com.danielasfregola.zucchini

import scala.io.Source

object Dictionary extends App {


  def extractUniqueWordsFromTextFile(filename: String): Set[String] = {
    val texts: Array[String] = Source.fromResource(filename).getLines().toArray
    val allUniqueWords: Set[String] = allWords(texts).toSet
    allUniqueWords
  }

  private def allWords(texts: Array[String]): Array[String] = {
    val words = texts.flatMap(line => line.split(" "))
    words.map(s => s.filter(_.isLetterOrDigit))
  }

  println(extractUniqueWordsFromTextFile("BaconipSum.txt").mkString(","))

}
