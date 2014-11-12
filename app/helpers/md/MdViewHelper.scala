package helpers.md

import play.api.templates._
import models.md.{MdFile, MdParser}
import scala.io.Source
import scala.collection.mutable.ListBuffer

/**
 * Created with IntelliJ IDEA.
 * User: takudo
 * Date: 2014/04/12
 * Time: 23:20
 */
object MdViewHelper {

  def render(view: HtmlFormat.Appendable): Html = {

    val parsed = MdParser.parse(view.toString)

    Html(parsed)

  }

  def bespokeRender(view: HtmlFormat.Appendable): Html = {

    val str = view.toString

    //改行2つごとに区切る

    val pagesStr = sectionWrap(str)

    Html(pagesStr)

  }

  def bespokeMdFileRender(filePath: String): Html = {
//    val source = Source.fromFile(filePath)
//    val lines = source.getLines

    val file = new MdFile(filePath)

    bespokeMdFileRender(file)

  }


  private def sectionWrap(origin: String): String = {
//    val pages = origin.split("\n---\n").map("<section>" + MdParser.parse(_) + "</section>")

    val pages = origin.split("\n---\n")

    val pagesParsed: ListBuffer[String] = new ListBuffer[String]

    pages.foreach{ p =>

      val lines = p.split("\n")

      var pparsed = ""

      lines.foreach{ l =>
        pparsed += _lineWrap(l)
      }
      pagesParsed += pparsed
    }

//    val pagesStr = pages.tail.mkString("")

//    val pagesStr = pages.mkString("")
    val pagesStr = pagesParsed.map("<section>" + _ + "</section>").mkString("")

    pagesStr
  }

  private def _lineWrap(line: String): String = {

    val tagMatcher = """<.+>""".r

    val m = tagMatcher.findPrefixMatchOf(line)

    if(m.isDefined){
      line
    }else{
      MdParser.parse(line)
    }

  }


  def title(origin: String): String = {
    origin.split("\n---\n")(0).trim().split("\n")(0).replaceAll("#", "").trim()
  }

  def titleByFilePath(filePath: String): String = {
    val source = Source.fromFile(filePath)
    val lines = source.getLines
    title(lines.mkString("\n"))
  }

  def titleByMdFile(mdFile: MdFile): String = {
    title(mdFile.origin)
  }

  def bespokeMdFileRender(mdFile: MdFile): Html = {

    Html(sectionWrap(mdFile.origin))

  }




}
