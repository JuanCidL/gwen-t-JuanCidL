package cl.uchile.dcc
package gwent.board

import gwent.card.SiegeCard

import gwent.card.effect.WeatherEffect

/** A class representing a siege zone to place siege cards.
 */
class SiegeZone extends CardList[SiegeCard]{
  /** Accept a weather effect to use his melee function.
   * 
   * @param visitor a weather effect.
   */
  override def accept(visitor: WeatherEffect): Unit = {
    visitor.applySiege(this)
  }
}
