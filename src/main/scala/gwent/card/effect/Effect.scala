package cl.uchile.dcc
package gwent.card.effect

import gwent.card.{Card, UCard}

import gwent.board.CardList
import gwent.observer.Subject

/** Interface representing a effect of the cards.
 */
trait Effect {
  /** Apply the effect on a card list.
   *
   * @param self the card with that effect.
   * @param target the card list to apply the effect
   */
  def apply(self: Card, target: CardList): Unit
}
