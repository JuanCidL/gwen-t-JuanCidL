package cl.uchile.dcc
package gwent.player

import gwent.card.Card

import scala.collection.mutable.ListBuffer

trait Player {
  val name: String
  var board: String
  var gems: Int
  val deckCards: ListBuffer[Card]
  val handCards: ListBuffer[Card]
  def play(): Unit
  def take(): Unit
  def countDeckCards(): Int
  def countHandCards(): Int
  def deckShuffle(): Unit
}