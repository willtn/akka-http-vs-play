import java.time.Clock

import com.google.inject.AbstractModule

class Module extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[AppLifecycle])
      .asEagerSingleton()

    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
  }
}
