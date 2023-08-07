package cl.uchile.dcc
package gwent.card.effect

import gwent.board.{CardList, SiegeZone}
import gwent.card.UCard

/** Class representing a torrential rain effect.
 */
class TorrentialRain extends AWeatherEffect {
  
  /** Set the strength to 1, to all siege cards
   * @param zone the zone where the cards are placed.
   */
  override def applySiege(zone: SiegeZone): Unit = {
    zone.cards.foreach{
      element => element.currentStrength = 1
    }
  }
}