package controllers

import play.api.mvc._
import play.api.Configuration

class Application(config: Configuration) extends Controller {

  def index = Action {
    Ok(views.html.index("Your title here"))
  }

  def about = Action {
    Ok(sbt.BuildInfo.toString)
  }

}
