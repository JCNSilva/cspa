package br.edu.ufcg.cspa

import akka.actor._

case class SingleEvent(name: String) extends Event[Nothing] {
  def inputEvent(name: String, value: Nothing)(context: Process) =
    throw new UnsupportedOperationException("Event with arity 0")
  def outputEvent(name: String)(context: Process) =
    throw new UnsupportedOperationException("Event with arity 0")
  def genericEvent(value: Nothing)(context: Process) =
    throw new UnsupportedOperationException("Event with arity 0")
}
