package controllers

import play.api._
import play.api.mvc._
import models.md.MdFile

object Application extends Controller {

  def md(mdFileName: String) = Action{

    val mdfile = new MdFile("./resources/" + mdFileName + ".md")

    Ok(views.html.index(mdfile))

  }

}