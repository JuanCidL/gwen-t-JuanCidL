package cl.uchile.dcc
package gwent.card.effect

import gwent.card.UCard

import cl.uchile.dcc.gwent.board.CardList

/** A class representing no effect.
 */
class NullEffect extends Effect {
  /** Do nothing
   *
   * @param target the card list to apply the effect
   * @tparam T a subclass of UCard.
   */
  def apply[T <: UCard](target: CardList[T]): Unit = {}
}
