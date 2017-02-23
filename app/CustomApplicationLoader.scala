import play.api._
import play.api.i18n._
import play.api.routing.Router
import router.Routes
import play.api.libs.ws.ahc.AhcWSComponents

class CustomApplicationLoader extends ApplicationLoader {
  def load(context: ApplicationLoader.Context) = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }
    new CustomComponents(context).application
  }
}

class CustomComponents(context: ApplicationLoader.Context)
  extends BuiltInComponentsFromContext(context)
  with I18nComponents
  with AhcWSComponents {

  lazy val router: Router = new Routes(httpErrorHandler, homeController, assets)

  lazy val homeController = new controllers.Application(configuration)
  lazy val assets = new controllers.Assets(httpErrorHandler)
}
