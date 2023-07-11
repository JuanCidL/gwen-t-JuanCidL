package cl.uchile.dcc
package gwent.board

import gwent.card.effect.WeatherEffect

import cl.uchile.dcc.gwent.card.RangedCard

class RangedZone extends CardList[RangedCard] {
  override def accept(visitor: WeatherEffect): Unit = {
    visitor.applyRanged(this)
  }
}
