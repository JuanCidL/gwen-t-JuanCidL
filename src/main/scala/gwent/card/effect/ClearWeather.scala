package cl.uchile.dcc
package gwent.card.effect

import gwent.board.CardList

class ClearWeather extends Effect {
  /** Clear the effects of the weather in the cards
   *
   * @param target the card list to apply the effect
   */
  def apply(target: CardList): Unit = {
    target.cards.foreach {
      element =>
        element.currentStrength = element.strength
    }
  }
}
