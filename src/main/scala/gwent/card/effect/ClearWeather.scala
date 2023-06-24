package cl.uchile.dcc
package gwent.card.effect
import gwent.board.CardList
import gwent.card.Card

class ClearWeather extends Effect {
  /** Clear the effects of the weather in the cards
   * @param self   the card with that effect.
   * @param target the card list to apply the effect
   */
  def apply(self: Card, target: CardList): Unit = {
    target.cards.foreach {
      element =>
        element.currentStrength = element.strength
    }
  }
}
