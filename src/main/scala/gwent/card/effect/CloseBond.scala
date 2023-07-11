package cl.uchile.dcc
package gwent.card.effect

import gwent.card.UCard
import gwent.board.CardList


/** Class representing a close bond effect.
 */
class CloseBond extends UnitEffect {
  /** Doubles the strength of cards with the same name and to itself,
   * only if exist other card with the same name in the target
   *
   * @param target the card list to apply the effect
   * @tparam T a subclass of UCard.
   */
  def apply[T <: UCard](target: CardList[T]): Unit = {
    val self: UCard = target.cards.head
    if (target.contains(self)){
      target.cards.foreach {
        element =>
          if (self.name == element.name) {
            element.currentStrength *= 2
            element.strength = element.currentStrength
          }
      }
    }
  }
}
