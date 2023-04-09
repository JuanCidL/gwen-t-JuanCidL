package cl.uchile.dcc
package gwent.player

import gwent.card.Card

trait Player {
  val name: String
  var board: String
  var gems: Int
  var dCards: Array[Card]
  var hCards: Array[Card]
  def play: Unit
  def take: Unit
  def countdCards: Int
  def counthCards: Int
}