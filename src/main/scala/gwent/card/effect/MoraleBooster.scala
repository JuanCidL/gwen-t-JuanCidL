package cl.uchile.dcc
package gwent.card.effect

import gwent.card.Card

import gwent.board.CardList
import gwent.observer.Subject

/** Class representing a morale booster effect.
 */
class MoraleBooster extends Effect {
  /** Apply a moral booster to all cards of the same type as the self value
   * , and increase in 1 the strength.
   *
   * @param self   the card with that effect.
   * @param target the card list to apply the effect
   */
  def apply(self: Card, target: CardList): Unit = {
    target.cards.foreach{
      element =>
        if (self != element) {
          element.currentStrength += 1
          element.strength = element.currentStrength
        }
    }
  }
}
