package cl.uchile.dcc
package gwent.board

import gwent.card.effect.WeatherEffect

import gwent.card.RangedCard

/** A class representing a ranged zone to place ranged cards.
 */
class RangedZone extends CardList[RangedCard] {
  /** Accept a weather effect to use his melee function.
   * 
   * @param visitor a weather effect.
   */
  override def accept(visitor: WeatherEffect): Unit = {
    visitor.applyRanged(this)
  }
}
