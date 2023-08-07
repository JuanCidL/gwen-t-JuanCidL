package cl.uchile.dcc
package gwent.board

import gwent.card.MeleeCard

import gwent.card.effect.{Effect, WeatherEffect}

/** A class representing a melee zone to place melee cards.
 */
class MeleeZone extends CardList[MeleeCard]{
  /** Accept a weather effect to use his melee function.
   *
   * @param visitor a weather effect.
   */
  override def accept(visitor: WeatherEffect): Unit = {
    visitor.applyMelee(this)
  }
}
