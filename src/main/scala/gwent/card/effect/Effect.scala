package cl.uchile.dcc
package gwent.card.effect

import gwent.board.CardList

/** Interface representing a effect of the cards.
 */
trait Effect {
  /** Apply the effect on a card list.
   *
   * @param target the card list to apply the effect
   */
  def apply(target: CardList): Unit
}
