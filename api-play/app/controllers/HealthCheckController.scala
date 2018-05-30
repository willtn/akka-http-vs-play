package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc._

@Singleton
class HealthCheckController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def healthCheck = Action {
    Ok("Play Framework API: up and running!")
  }
}
