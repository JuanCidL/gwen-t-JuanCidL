package cl.uchile.dcc
package gwent.card.effect
import gwent.card.Card

import gwent.board.CardList
import gwent.observer.Subject

/** A class representing no effect.
 */
class NullEffect extends Effect {
  /** Do nothing
   *
   * @param self   the card with that effect.
   * @param target the card list to apply the effect
   */
  def apply(self: Card, target: CardList): Unit = {}
}
