package cl.uchile.dcc
package gwent.board

import gwent.card.SiegeCard

import gwent.card.effect.WeatherEffect

class SiegeZone extends CardList[SiegeCard]{
  override def accept(visitor: WeatherEffect): Unit = {
    visitor.applySiege(this)
  }
}
