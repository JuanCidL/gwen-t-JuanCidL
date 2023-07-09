package cl.uchile.dcc
package gwent.card.effect

import gwent.board.CardList

/** Class representing a impenetrable fog effect.
 */
class ImpenetrableFog extends Effect {

  /** Set the strength to 1, to all ranged cards
   *
   * @param target the card list to apply the effect
   */
  def apply(target: CardList): Unit = {
    target.cards.foreach {
      element =>
        if (element.isRanged)
          element.currentStrength = 1
    }
  }
}
