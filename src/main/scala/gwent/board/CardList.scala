package cl.uchile.dcc
package gwent.board

import gwent.card.effect.{Effect, WeatherEffect}
import gwent.card.UCard
import gwent.observer.{Observer, Subject}

/** Class representing a list of Cards
 */
class CardList[T <: UCard] extends Observer[Effect] {

  /** Accept a weather effect to apply it.
   * @param visitor a weather effect.
   */
  def accept(visitor: WeatherEffect): Unit = {}

  private var _cards: List[T] = List()

  /** Apply the effect of the observable object to all cards
   * of his same type in the BoardSection of the player that played
   * the observable.
   *
   * @param observable A observable object to shot a update in the observer.
   * @param value      a Effect to use in the update.
   */
  def update(observable: Subject[Effect], value: Effect): Unit = {
    value(this)
  }

  /** Get the list of cards.
   * @return the list of cards.
   */
  def cards: List[T] = _cards


  /** Add a new Card to the list of Cards `C`
   *
   * @param card The new Card to add to the list
   */
  def addCard(card: T): Unit = {
    _cards = card :: cards
  }

  /**
  /** Delete a card from the cards list
   *
   * @param card The card to delete.
   */
  def delCard(card: UCard): Unit = {
    if (cards.contains(card)) {
      var isFirst = true
      _cards = cards.filter { c =>
        if (c == card && isFirst) {
          isFirst = false
          false
        } else true
      }
    }
  }
  */

  /** Check if the card list contains a card.
   *
   * @param card The card to evaluate.
   * @return true if the list contains the card, false otherwise.
   */
  def contains(card: Subject[Effect]): Boolean = {
    cards.contains(card)
  }

}
