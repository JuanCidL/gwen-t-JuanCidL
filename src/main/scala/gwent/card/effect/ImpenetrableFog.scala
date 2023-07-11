package cl.uchile.dcc
package gwent.card.effect


import gwent.card.UCard
import gwent.board.RangedZone

/** Class representing a impenetrable fog effect.
 */
class ImpenetrableFog extends AWeatherEffect {


  /** Set the strength to 1, to all ranged cards.
   * 
   * @param zone the zone where the cards are placed.
   */
  override def applyRanged(zone: RangedZone): Unit = {
    zone.cards.foreach {
      element => element.currentStrength = 1
    }
  }
}
