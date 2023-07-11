package cl.uchile.dcc
package gwent.card.effect


import gwent.card.UCard
import gwent.board.CardList

/** Interface representing a effect of the cards.
 */
trait Effect {
  /** Apply the effect on a card list.
   *
   * @param target the card list to apply the effect
   * @tparam T a subclass of UCard.
   */
  def apply[T <: UCard](target: CardList[T]): Unit
}
