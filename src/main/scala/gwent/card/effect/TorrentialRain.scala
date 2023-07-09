package cl.uchile.dcc
package gwent.card.effect

import gwent.board.CardList

/** Class representing a torrential rain effect.
 */
class TorrentialRain extends Effect {

  /** Set the strength to 1, to all siege cards
   *
   * @param target the card list to apply the effect
   */
  def apply(target: CardList): Unit = {
    target.cards.foreach{
      element =>
        if (element.isSiege)
          element.currentStrength = 1
    }
  }
}