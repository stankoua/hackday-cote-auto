package controllers

import org.scalatestplus.play._

import play.api.{Environment, Configuration}
import play.api.test._
import play.api.test.Helpers._

class ApplicationTest extends PlaySpec {
  val env = Environment.simple()
  val configuration = Configuration.load(env)

  val controller = new Application(configuration)

  "Application page about" should {
    "contain the application version" in {
      val result = controller.about().apply(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText must include(sbt.BuildInfo.version)
    }
  }
}
