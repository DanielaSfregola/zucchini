import org.scalatest.WordSpecLike
import Dictionary._

class DictionaryTest extends WordSpecLike {

  "DictionaryTest" should {

    "extractUniqueWordsFromTextFile" should {

      "return 6 unique words" in {
        assertResult(6){
          extractUniqueWordsFromTextFile("myWords").size
        }
      }
    }

  }
}
