package controllers.syslog

import javax.inject.Inject

import org.joda.time.DateTime
import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Quest on 2016/12/01.
  */
class LogsRouter @Inject()(systemEvents:SystemLogEventsController) extends SimpleRouter{

  override def routes: Routes = {
    case GET(p"/get/SystemLogEvent/$id") =>
      systemEvents.getEventById(id)
    case GET(p"/get/SystemLogEvent/all") =>
      systemEvents.getAllEvents
    case POST(p"/SystemLogEvent/create") =>
      systemEvents.createOrUpdate
    case DELETE(p"/del/SystemLogEvent/$id") =>
      systemEvents.deleteById(id)
    case GET(p"/get/SystemLogEvent/$date") =>
      systemEvents.getEventsByDate(new DateTime(date))
  }
}
