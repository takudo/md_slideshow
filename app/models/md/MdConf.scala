package models.md

/**
 * Created with IntelliJ IDEA.
 * User: takudo
 * Date: 2014/04/20
 * Time: 10:48
 */
class MdConf(confStr: String){

  val theme = _matchStr(confStr, """^app.conf.theme=(.+)\n""").getOrElse("")


  theme

  private def _matchStr(origin: String, regexStr: String): Option[String] = {

    var result:Option[String] = None

    val rgx = regexStr.r
    val mi = rgx.findFirstMatchIn(confStr)
    mi.foreach{ m =>
      val g = m.group(1)
      result = Some(g)
    }

    result
  }

}
