package br.edu.ufcg.cspa

import akka.actor._
import Message._

/**
 * Represents the special process STOP
 * @author Julio
 */
class STOP extends Process with ActorLogging {

  var trace: List[SingleEvent] = Nil
  var states: List[State] = Nil

  override def receive(): Receive = {
    case Perform(trace_, states_) =>
      trace = trace_
      states = Omega :: states_
      log.info(trace.map(_.toString)
          .reverse
          .foldRight("STOP")(_ + " -> " + _))
    case Start =>
      states = List(Omega)
      log.info("STOP")
  }

  override def toString() = "STOP"
}

object STOP {
  def apply()(implicit ac: ActorContext): ActorRef = {
    ac.actorOf(Props[STOP])
  }
  
  def apply(name: String)(implicit ac: ActorContext): ActorRef = {
    ac.actorOf(Props[STOP], name)
  }
}