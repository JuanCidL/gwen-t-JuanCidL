package cl.uchile.dcc
package gwent.card.effect

import gwent.board.CardList

/** A class representing no effect.
 */
class NullEffect extends Effect {
  /** Do nothing
   *
   * @param target the card list to apply the effect
   */
  def apply(target: CardList): Unit = {}
}
