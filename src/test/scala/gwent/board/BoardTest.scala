package cl.uchile.dcc
package gwent.board

import gwent.card.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard}
import gwent.player.Player

import munit.FunSuite

class BoardTest extends FunSuite{
  var board: Board = _
  var zone1: BoardSection = _
  var zone2: BoardSection = _
  var plyr1: Player = _
  var plyr2: Player = _

  val escuero: MeleeCard = new MeleeCard("Escuero", "Tortuguita", 20)
  val exodia: RangedCard = new RangedCard("Exodia", "El prohibido", 999)
  val tilin: SiegeCard = new SiegeCard("Tilin", "Eso tilin", 100)
  val granizo: WeatherCard = new WeatherCard("Granizo", "Piedras de hielo")

  var deck1: List[Card] = _
  var deck2: List[Card] = _
  var hand1: List[Card] = _
  var hand2: List[Card] = _


  override def beforeEach(context: BeforeEach): Unit = {
    board = new Board()
    zone1 = board.p1Zone
    zone2 = board.p2Zone

    deck1 = List(escuero, granizo, exodia, tilin, escuero)
    deck2 = List(exodia, tilin, escuero, granizo, granizo)
    hand1 = List()
    hand2 = List()

    plyr1 = new Player("Pedro", 3, deck1, hand1)
    plyr1.boardSection_(zone1)
    plyr1.drawCard()
    plyr1.drawCard()
    plyr1.drawCard()
    plyr1.drawCard()
    plyr1.drawCard()

    plyr2 = new Player("Fernando", 3, deck2, hand2)
    plyr2.boardSection_(zone2)
    plyr2.drawCard()
    plyr2.drawCard()
    plyr2.drawCard()
    plyr2.drawCard()
    plyr2.drawCard()
  }
  
  test("Getters"){
    assertEquals(plyr1.boardSection, board.p1Zone)
    assertEquals(plyr2.boardSection, board.p2Zone)
  }

  test("Play melee card"){
    plyr1.playCard(escuero)
    assert(zone1.contains(escuero))
    assert(!zone1.contains(exodia))
    assert(!zone1.contains(tilin))
    assertNotEquals(board.weatherCardZone, granizo)
    assertEquals(plyr1.countHand, 4)

    plyr1.playCard(tilin)
    assert(zone1.contains(escuero))
    assert(!zone1.contains(exodia))
    assert(zone1.contains(tilin))
    assertNotEquals(board.weatherCardZone, granizo)
    assertEquals(plyr1.countHand, 3)
  }

  test("Play ranged card"){
    plyr2.playCard(exodia)
    assert(!zone2.contains(escuero))
    assert(zone2.contains(exodia))
    assert(!zone2.contains(tilin))
    assertNotEquals(board.weatherCardZone, granizo)
    assertEquals(plyr2.countHand, 4)

    plyr2.playCard(tilin)
    assert(!zone2.contains(escuero))
    assert(zone2.contains(exodia))
    assert(zone2.contains(tilin))
    assertNotEquals(board.weatherCardZone, granizo)
    assertEquals(plyr2.countHand, 3)
  }

  test("Play siege card"){
    plyr1.playCard(tilin)
    assert(!zone1.contains(escuero))
    assert(!zone1.contains(exodia))
    assert(zone1.contains(tilin))
    assertNotEquals(board.weatherCardZone, granizo)
    assertEquals(plyr1.countHand, 4)

    plyr1.playCard(granizo)
    assert(!zone1.contains(escuero))
    assert(!zone1.contains(exodia))
    assert(zone1.contains(tilin))
    assertEquals(board.weatherCardZone, granizo)
    assertEquals(plyr1.countHand, 3)
  }

  test("Play weather card"){
    plyr2.playCard(granizo)
    assert(!zone2.contains(escuero))
    assert(!zone2.contains(exodia))
    assert(!zone2.contains(tilin))
    assertEquals(board.weatherCardZone, granizo)
    assertEquals(plyr2.countHand, 4)

    plyr2.playCard(escuero)
    assert(zone2.contains(escuero))
    assert(!zone2.contains(exodia))
    assert(!zone2.contains(tilin))
    assertEquals(board.weatherCardZone, granizo)
    assertEquals(plyr2.countHand, 3)
  }

  test("No se eliminan todas las cartas iguales de la mano al jugar") {
    plyr1.playCard(escuero)
    assert(plyr1.hand.contains(escuero))
    plyr1.playCard(escuero)
    assert(!plyr1.hand.contains(escuero))
  }
}
