package cl.uchile.dcc
package gwent.card.effect

import gwent.board.{CardList, MeleeZone, RangedZone, SiegeZone}

import gwent.card.UCard

/** A abstract class representing a Weather Effect using visitor pattern.
 *
 */
abstract class AWeatherEffect extends WeatherEffect {
  
  /** Apply the effect in the zones called.
   * 
   * It works like the visitor pattern using double dispatch.
   * 
   * @param target the card list to apply the effect
   * @tparam T a subclass of UCard.
   */
  def apply[T <: UCard](target: CardList[T]): Unit = {
    target.accept(this)
  }
  
  /** Apply the effect to the cards on melee zone.
   * 
   * In this template function does nothing
   * 
   * @param zone the zone where the cards are placed.
   */
  def applyMelee(zone: MeleeZone): Unit = {}
  
  /** Apply the effect to the cards on ranged zone.
   * 
   * In this template function does nothing
   * 
   * @param zone the zone where the cards are placed.
   */
  def applyRanged(zone: RangedZone): Unit = {}
  
  /** Apply the effect to the cards on siege zone.
   * 
   * In this template function does nothing
   * 
   * @param zone the zone where the cards are placed.
   */
  def applySiege(zone: SiegeZone): Unit = {}
}
