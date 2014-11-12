package models.md

import scala.io.Source

/**
 * Created with IntelliJ IDEA.
 * User: takudo
 * Date: 2014/04/20
 * Time: 10:48
 */
class MdFile(mdFilePath: String){

  val source = Source.fromFile(mdFilePath)
  val lines = source.getLines
  val origin = lines.mkString("\n")

  val pages = origin.split("\n---\n")

  val conf = new MdConf(pages(0))


  conf


}
