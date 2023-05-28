package cl.uchile.dcc
package gwent.player

import gwent.card.Card

import gwent.board.BoardSection

import scala.util.Random
import java.util.Objects

/** Class representing a player.
 *
 * A player has their own name, a gem counter (life),
 * a deck and a hand of cards, which are private but can be obtained through getters.
 * It also has a section of the board where you can play your hand of cards.
 *
 * @param name The name of the player.
 * @param gems The amount of gems of the player.
 * @param _deck The deck of the player.
 * @param _hand The hand of the player.
 */
class Player(val name: String, var gems: Int, private var _deck: List[Card], private var _hand: List[Card]) {

  /** Board section of the player */
  private var _boardSection: BoardSection = _

  /** Get the player's board section.
   *
   * @return The current board section
   */
  def boardSection: BoardSection = _boardSection

  /** Set the player's board section.
   *
   * @param newBoardSection The board section to set.
   */
  def boardSection_(newBoardSection: BoardSection): Unit = {_boardSection = newBoardSection}

  /** Getter of the player's deck.
   * return the deck of the player.
   */
  def deck: List[Card] = _deck

  /** Get the player's hand.
   * return the hand of the player.
   */
  def hand: List[Card] = _hand

  /** Draw a card from de player's deck to add it to the hand.
   *
   * It take the head of the deck List to give it to the hand,
   * and replace the deck with his self tail.
   */
  def drawCard(): Unit = {
    val head = deck.head
    _deck = deck.tail
    _hand = head :: hand
  }

  /** Play a card from the hand.
   *
   * This method calls the play method of a card so that its implementation can resolve it.
   *
   * @param card The card to play
   */
  def playCard(card: Card): Unit = {
    if (hand.contains(card)) {
      card.play(boardSection)
      var isFirst = true
      _hand = hand.filter { c =>
        if (c == card && isFirst) {
          isFirst = false
          false
        } else true
      }
    }
  }

  /** Shuffles the player's deck.
   *
   * It replace the deck by a List with the same cards but shuffled.
   */
  def shuffleDeck(): Unit = {
    _deck = Random.shuffle(deck)
  }

  /** Count the number of cards in deck
   * @return the number of cards in deck
   */
  def countDeck: Int = deck.length

  /** Count the number of cards in hand
   * @return the number of cards in hand
   */
  def countHand: Int = hand.length

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Player]) {
      val other: Player = obj.asInstanceOf[Player]
      this.name == other.name
    } else false
  }

  override def hashCode(): Int = Objects.hash(classOf[Player], name)
}
