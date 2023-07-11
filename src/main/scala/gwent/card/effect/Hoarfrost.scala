package cl.uchile.dcc
package gwent.card.effect

import gwent.card.UCard

import gwent.board.MeleeZone

/** Class representing a hoarfrost effect.
 */
class Hoarfrost extends AWeatherEffect {

  /** Set the strength to 1, to all ranged cards
   * 
   * @param zone the zone where the cards are placed.
   */
  override def applyMelee(zone: MeleeZone): Unit = {
    zone.cards.foreach{
      element => element.currentStrength = 1
    }
  }
}
