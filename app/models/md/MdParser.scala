package models.md

import com.tristanhunt.knockoff.DefaultDiscounter._

/**
 * Created with IntelliJ IDEA.
 * User: doyao
 * Date: 14/04/11
 * Time: 11:54
 */
object MdParser {


  def parse(origin: String): String = {

    val k = knockoff(origin)

    toXML(k).toString

  }

}
