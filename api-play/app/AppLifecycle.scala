import java.time.{Clock, Instant}

import javax.inject.{Inject, Singleton}
import play.api.Logger
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future

@Singleton
class AppLifecycle @Inject() (clock: Clock, appLifecycle: ApplicationLifecycle) {
  private val start: Instant = clock.instant

  appLifecycle.addStopHook { () =>
    val stop: Instant = clock.instant
    val runningTime: Long = stop.getEpochSecond - start.getEpochSecond
    Logger.info(
      s"ApplicationTimer demo: Stopping application at ${clock.instant} after ${runningTime}s."
    )
    Future.successful(())
  }
}
