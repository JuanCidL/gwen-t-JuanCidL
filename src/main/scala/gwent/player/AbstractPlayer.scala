package cl.uchile.dcc
package gwent.player

import gwent.card.{Card, WeatherCard}
import scala.collection.mutable.ListBuffer
import scala.util.Random

/** An abstract class to help the construction of players
 * @param name
 */
abstract class AbstractPlayer(val name: String)
  extends Player {
  val deckCards = new ListBuffer()
  val handCards = new ListBuffer()

  /** Take a random card of the deck to hand
   */
  def take(): Unit = {
    val rand = new Random
    val card = this.deckCards(rand.nextInt(this.deckCards.length))
    this.deckCards -= card
    this.handCards += card
  }

  /** Count the number of cards in the deck
   * @return the number of cards in the deck
   */
  def countDeckCards(): Int = deckCards.length

  /** Count the number of cards in the deck
   *
   * @return the number of cards in the deck
   */
  def countHandCards(): Int = handCards.length

  /** Shuffle the deck
   */
  def deckShuffle(): Unit = Random.shuffle(this.deckCards)

  /** "Temporary function"
   *
   * Function that adds a card with a random name to the deck
   */
  def addCard(): Unit = {
    this.deckCards += new WeatherCard(Random.nextPrintableChar().toString, "")
  }

  override def equals(obj: Any): Boolean = {
    if (this.getClass.getName == obj.getClass.getName) {
      val other = obj.asInstanceOf[Player]
      this.name == other.name
    } else false
  }
}
