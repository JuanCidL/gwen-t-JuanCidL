package cl.uchile.dcc
package gwent.card.effect

import gwent.board.{Board, BoardSection}
import gwent.card.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard}
import gwent.player.Player

import munit.FunSuite

class ImpenetrableFogTest extends FunSuite{

  var m1: MeleeCard = _
  var m2: MeleeCard = _
  var m3: MeleeCard = _
  var m4: MeleeCard = _
  var r1: RangedCard = _
  var r2: RangedCard = _
  var r3: RangedCard = _
  var r4: RangedCard = _
  var s1: SiegeCard = _
  var s2: SiegeCard = _
  var s3: SiegeCard = _
  var s4: SiegeCard = _

  var impenetrablefog1: WeatherCard = _
  var impenetrablefog2: WeatherCard = _
  var clearWeather1: WeatherCard = _
  var clearWeather2: WeatherCard = _

  var board: Board = _
  var zone: BoardSection = _
  var cpuzone: BoardSection = _

  var player: Player = _
  var cpu: Player = _

  var deck: List[Card] = _
  var hand: List[Card] = _
  var cpudeck: List[Card] = _
  var cpuhand: List[Card] = _

  override def beforeEach(context: BeforeEach): Unit = {

    m1 = new MeleeCard("M1", "Melee example", 1)
    m2 = new MeleeCard("M2", "Melee example", 2)
    m3 = new MeleeCard("M3", "Melee example", 3)
    m4 = new MeleeCard("M4", "Melee example", 4)
    r1 = new RangedCard("R1", "Ranged example", 1)
    r2 = new RangedCard("R2", "Ranged example", 2)
    r3 = new RangedCard("R3", "Ranged example", 3)
    r4 = new RangedCard("R4", "Ranged example", 4)
    s1 = new SiegeCard("S1", "Siege example", 1)
    s2 = new SiegeCard("S2", "Siege example", 2)
    s3 = new SiegeCard("S3", "Siege example", 3)
    s4 = new SiegeCard("S4", "Siege example", 4)

    clearWeather1 = new WeatherCard("Clear1", "Clear the weather")
    clearWeather2 = new WeatherCard("Clear2", "Clear the weather")
    clearWeather1.setEffect(new ClearWeather())
    clearWeather2.setEffect(new ClearWeather())

    impenetrablefog1 = new WeatherCard("Hoar1", "Set strength = 1 to all melee cards on board")
    impenetrablefog2 = new WeatherCard("Hoar2", "Set strength = 1 to all melee cards on board")
    impenetrablefog1.setEffect(new ImpenetrableFog())
    impenetrablefog2.setEffect(new ImpenetrableFog())

    board = new Board()
    zone = board.p1Zone
    cpuzone = board.p2Zone

    /** Imagine that you have take the cards */
    deck = List()
    hand = List(m1, r1, s1, m2, r2, s2, clearWeather1, impenetrablefog1)

    player = new Player("Player", 3, deck, hand)
    player.boardSection_(zone)

    /** Imagine that cpu has take the cards */
    cpudeck = List()
    cpuhand = List(m3, r3, s3, m4, r4, s4, clearWeather2, impenetrablefog2)

    cpu = new Player("CPU", 3, cpudeck, cpuhand)
    cpu.boardSection_(cpuzone)
  }

  test("Impenetrable fog + ClearWeather by both players"){
    player.playCard(m1)
    cpu.playCard(m3)

    player.playCard(r1)
    cpu.playCard(r3)

    player.playCard(s1)
    cpu.playCard(s3)

    player.playCard(m2)
    cpu.playCard(m4)

    player.playCard(r2)
    cpu.playCard(r4)

    player.playCard(s2)
    cpu.playCard(s4)

    assertEquals(r1.currentStrength, 1)
    assertEquals(r2.currentStrength, 2)
    assertEquals(r3.currentStrength, 3)
    assertEquals(r4.currentStrength, 4)

    /** Apply the effect by the player */
    player.playCard(impenetrablefog1)

    /** Check if the cards on the board had been affected */
    assertEquals(r1.currentStrength, 1)
    assertEquals(r2.currentStrength, 1)
    assertEquals(r3.currentStrength, 1)
    assertEquals(r4.currentStrength, 1)

    /** Check if the other type of cards had not affected */
    assertEquals(m1.currentStrength, 1)
    assertEquals(s1.currentStrength, 1)
    assertEquals(m2.currentStrength, 2)
    assertEquals(s2.currentStrength, 2)
    assertEquals(m3.currentStrength, 3)
    assertEquals(s3.currentStrength, 3)
    assertEquals(m4.currentStrength, 4)
    assertEquals(s4.currentStrength, 4)

    /** Clear the effect by the cpu */
    cpu.playCard(clearWeather2)

    /** Check if the strength of melee cards is normal */
    assertEquals(r1.currentStrength, 1)
    assertEquals(r2.currentStrength, 2)
    assertEquals(r3.currentStrength, 3)
    assertEquals(r4.currentStrength, 4)

    /** Apply the effect by the cpu */
    cpu.playCard(impenetrablefog2)

    /** Check if the cards on the board had been affected */
    assertEquals(r1.currentStrength, 1)
    assertEquals(r2.currentStrength, 1)
    assertEquals(r3.currentStrength, 1)
    assertEquals(r4.currentStrength, 1)

    /** Check if the other type of cards had not affected */
    assertEquals(m1.currentStrength, 1)
    assertEquals(s1.currentStrength, 1)
    assertEquals(m2.currentStrength, 2)
    assertEquals(s2.currentStrength, 2)
    assertEquals(m3.currentStrength, 3)
    assertEquals(s3.currentStrength, 3)
    assertEquals(m4.currentStrength, 4)
    assertEquals(s4.currentStrength, 4)

    /** Clear the effect by the player */
    player.playCard(clearWeather1)

    /** Check if the strength of melee cards is normal */
    assertEquals(r1.currentStrength, 1)
    assertEquals(r2.currentStrength, 2)
    assertEquals(r3.currentStrength, 3)
    assertEquals(r4.currentStrength, 4)
  }
}
