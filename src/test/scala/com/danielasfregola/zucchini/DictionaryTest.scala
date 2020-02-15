package com.danielasfregola.zucchini

import com.danielasfregola.zucchini.Dictionary._
import org.scalatest.WordSpecLike

class DictionaryTest extends WordSpecLike {

  "DictionaryTest" should {

    "extractUniqueWordsFromTextFile" should {

      "return 6 unique words" in {
        assertResult(Set("rabbit", "lion", "pig", "horse", "Goat", "uniCorn23")){
          extractUniqueWordsFromTextFile("myWords.txt")
        }
      }
    }

  }
}
