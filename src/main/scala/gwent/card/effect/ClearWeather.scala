package cl.uchile.dcc
package gwent.card.effect

import gwent.card.UCard
import gwent.board.CardList

/** A class that clear the weather effects.
 */
class ClearWeather extends AWeatherEffect {
  /** Clear the effects of the weather in the cards
   *
   * @param target the card list to apply the effect
   * @tparam T a subclass of UCard.
   */
  override def apply[T <: UCard](target: CardList[T]): Unit = {
    target.cards.foreach {
      element =>
        element.currentStrength = element.strength
    }
  }
}
