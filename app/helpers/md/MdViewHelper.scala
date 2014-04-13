package helpers.md

import play.api.templates._
import models.md.MdParser
import scala.io.Source

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
    val source = Source.fromFile(filePath)
    val lines = source.getLines

    Html(sectionWrap(lines.mkString("\n")))

  }


  private def sectionWrap(origin: String): String = {
    val pages = origin.split("\n---\n").map("<section>" + MdParser.parse(_) + "</section>")

    val pagesStr = pages.mkString("")

    pagesStr
  }

  def title(origin: String): String = {

    origin.split("\n---\n")(0).trim().split("\n")(0).replaceAll("#", "").trim()

  }

  def titleByFilePath(filePath: String): String = {
    val source = Source.fromFile(filePath)
    val lines = source.getLines
    title(lines.mkString("\n"))
  }

}
