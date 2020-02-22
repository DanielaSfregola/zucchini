package com.danielasfregola.zucchini

import org.scalacheck.{Arbitrary, Gen}

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

  //  println(extractUniqueWordsFromTextFile("BaconipSum.txt").mkString(","))

  val words: Set[String] = extractUniqueWordsFromTextFile("BaconipSum.txt")
  val word: Arbitrary[String] = Arbitrary {
    Gen.oneOf(words)
  }
}
