package cl.uchile.dcc
package gwent.board

import gwent.card.MeleeCard

import cl.uchile.dcc.gwent.card.effect.{Effect, WeatherEffect}

class MeleeZone extends CardList[MeleeCard]{
  override def accept(visitor: WeatherEffect): Unit = {
    visitor.applyMelee(this)
  }
}
