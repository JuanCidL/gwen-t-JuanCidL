package cl.uchile.dcc
package gwent.card.effect

import gwent.board.{MeleeZone, RangedZone, SiegeZone}

/** Interface representing a Weather Effect.
 * Is also a visitor template.
 */
trait WeatherEffect extends Effect{

  /** Apply the effect to the cards on melee zone.
   * 
   * @param zone the zone where the cards are placed.
   */
  def applyMelee(zone: MeleeZone): Unit
  
  /** Apply the effect to the cards on ranged zone.
   * 
   * @param zone the zone where the cards are placed.
   */
  def applyRanged(zone: RangedZone): Unit
  
  /** Apply the effect to the cards on siege zone.
   * 
   * @param zone the zone where the cards are placed.
   */
  def applySiege(zone: SiegeZone): Unit
}
