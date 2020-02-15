import java.nio.file.Paths

import scala.io.BufferedSource
import scala.io.Source._

object Dictionary {


  def extractUniqueWordsFromTextFile(filePath: String): Set[String] = {
    val textFilePath: String = textFilePathFromResources(filePath)
    val allTexts: Array[String] = loadTextFile(textFilePath)
    val allUniqueWords: Set[String] = allWords(allTexts).toSet
    allUniqueWords
  }

  private def textFilePathFromResources(filePath: String): String = {
    val resource = getClass.getResource(filePath)
    val path = Paths.get(resource.toURI)
    path.toString
  }

  private def loadTextFile(filePath: String): Array[String] = {
    val textFile: BufferedSource = fromFile(filePath)
    val words: Array[String] = textFile.getLines().toArray
    textFile.close
    words
  }

  private def allWords(text: Array[String]): Array[String] = text.flatMap(line => line.split(" ")
    .map(_.replaceAll("[,.]", "")))


  def main(args: Array[String]): Unit = {
    println(extractUniqueWordsFromTextFile("/BaconipSum").mkString(","))
  }
}
