package cl.uchile.dcc
package gwent.card.effect
import gwent.board.CardList
import gwent.card.Card

/** Class representing a hoarfrost effect.
 */
class Hoarfrost extends Effect {
  
  /** Set the strength to 1, to all melee cards
   * @param self   the card with that effect.
   * @param target the card list to apply the effect
   */
  def apply(self: Card, target: CardList): Unit = {
    target.cards.foreach{
      element =>
        if (element.isMelee)
          element.currentStrength = 1
    }
  }
}
