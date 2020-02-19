package com.danielasfregola.zucchini

import com.danielasfregola.zucchini.Dictionary._
import org.scalatest.WordSpecLike

class DictionaryTest extends WordSpecLike {

  "DictionaryTest" should {

    "extractUniqueWordsFromTextFile" should {

      "return 6 unique words" in {
        assertResult(Set("rabbit", "lion", "pig", "horse", "Goat", "uniCorn23")) {
          extractUniqueWordsFromTextFile("myWords.txt")
        }
      }
    }

    "return letters or digits only" in {
      assertResult(Set("Bacon", "ipsum", "dolor_amet", "land", "jaeger", "chicken", "jowl", "Venison",
        "doner", "shoulder", "tri", "tip", "pig2", "boudin")) {
        extractUniqueWordsFromTextFile("BaconipSumTest.txt")
      }
    }
  }
}
