package akka

import akka.actor.{Props, ActorSystem, ActorRef, Actor}
import akka.event.Logging
import akka.pattern.ask
import akka.util.Timeout
import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

/**
 * Author: Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * Date: 3/3/14
 * Time: 2:45 PM
 *
 *
 * more costly than spawning new actor - because of timeouts (at least conceptually ;) )
 */
object AskApp {

  class Questioner(val responder: ActorRef) extends Actor {
    val log = Logging(context.system, this)

    override def receive = {
      case t =>
        implicit val timeout = new Timeout(5, TimeUnit.SECONDS)
        val future = responder ? t
        println(s"asked $t")
        future.onComplete {
          answer =>
            println(s"got: ${answer.get}")
        }
    }
  }

  class Responder extends Actor {
    val log = Logging(context.system, this)

    override def receive = {
      case t =>
        val e = if (math.random > 0.5) true else false
        println(s"received $t, answering: $e")
        Thread.sleep(1000)
        sender ! e
    }
  }

  def main(args: Array[String]) {
    val system = ActorSystem("askSystem")

    val responder = system.actorOf(Props[Responder], name = "responder")

    val worker = system.actorOf(Props(classOf[Questioner], responder))

    worker ! "is this true?"
    worker ! "is this false?"
  }

}
