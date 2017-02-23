import play.api._
import play.core.DefaultWebCommands

/**
 * An application builder for running an application in tests
 */
class ApplicationBuilder {

  def build(): Application = {
    val env = Environment.simple()
    val context = new ApplicationLoader.Context(
      environment = env,
      sourceMapper = None,
      webCommands = new DefaultWebCommands(),
      initialConfiguration = Configuration.load(env)
    )
    val loader = new CustomApplicationLoader()
    loader.load(context)
  }
}
