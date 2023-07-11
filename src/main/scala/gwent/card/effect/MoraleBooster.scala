package cl.uchile.dcc
package gwent.card.effect

import gwent.board.CardList
import gwent.card.UCard

/** Class representing a morale booster effect.
 */
class MoraleBooster extends UnitEffect {
  /** Apply a moral booster to all cards of the same type as the self value
   * , and increase in 1 the strength.
   *
   * @param target the card list to apply the effect
   * @tparam T a subclass of UCard.
   */
  def apply[T <: UCard](target: CardList[T]): Unit = {
    val self: UCard = target.cards.head
    target.cards.foreach{
      element =>
        if (self != element) {
          element.currentStrength += 1
          element.strength = element.currentStrength
        }
    }
  }
}
