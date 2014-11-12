package models.bespokejs

import play.api.Play

/**
 * Created with IntelliJ IDEA.
 * User: takudo
 * Date: 2014/04/20
 * Time: 18:27
 */
object BespokejsConf {

  def theme: String = {

    Play.current.configuration.getString("bespokejs.conf.theme").getOrElse("")

  }

}
