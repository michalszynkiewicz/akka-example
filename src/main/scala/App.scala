import akka.actor.{ActorRef, Actor, ActorSystem, Props}

/**
 * Author: Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * Date: 3/3/14
 * Time: 9:29 AM
 */
object App {

  class Printer extends Actor {
    override def receive = {
      case t =>
        println(t)
        context.system.shutdown()
    }
  }

  class Worker(val printer : ActorRef) extends Actor {
    override def receive = {
      case (a : Int, b : Int)  => printer ! (a * b)
    }
  }

  def main(args: Array[String]) {
    // Create an Akka system
    val system = ActorSystem("mySystem")

    // create the result printer, which will print the result and shutdown the system
    val printer = system.actorOf(Props[Printer], name = "printer")

    val worker = system.actorOf(Props(classOf[Worker], printer))

    worker ! (3, 14)
  }
}
