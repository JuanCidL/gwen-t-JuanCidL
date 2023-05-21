package cl.uchile.dcc
package gwent.board

import gwent.card.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard}
import gwent.player.Player

import munit.FunSuite

class BoardTest extends FunSuite{
  var board: Board = _
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

    deck1 = List(escuero, granizo, exodia, tilin, escuero)
    deck2 = List(exodia, tilin, escuero, granizo, granizo)
    hand1 = List()
    hand2 = List()

    plyr1 = new Player("Pedro", 3, deck1, hand1)
    plyr1.drawCard()
    plyr1.drawCard()
    plyr1.drawCard()
    plyr1.drawCard()
    plyr1.drawCard()

    plyr2 = new Player("Fernando", 3, deck2, hand2)
    plyr2.drawCard()
    plyr2.drawCard()
    plyr2.drawCard()
    plyr2.drawCard()
    plyr2.drawCard()
  }

  test("Play melee card"){
    plyr1.boardSection_(board.p1BoardSection)

    plyr1.playCard(escuero)
    assert(board.p1BoardSection.contains(escuero))
    assert(!board.p1BoardSection.contains(exodia))
    assert(!board.p1BoardSection.contains(tilin))
    assert(!board.contains(granizo))
    assertEquals(plyr1.countHand, 4)

    plyr1.playCard(tilin)
    assert(board.p1BoardSection.contains(escuero))
    assert(!board.p1BoardSection.contains(exodia))
    assert(board.p1BoardSection.contains(tilin))
    assert(!board.contains(granizo))
    assertEquals(plyr1.countHand, 3)
  }

  test("Play ranged card"){
    plyr2.boardSection_(board.p2BoardSection)

    plyr2.playCard(exodia)
    assert(!board.p2BoardSection.contains(escuero))
    assert(board.p2BoardSection.contains(exodia))
    assert(!board.p2BoardSection.contains(tilin))
    assert(!board.contains(granizo))
    assertEquals(plyr2.countHand, 4)

    plyr2.playCard(tilin)
    assert(!board.p2BoardSection.contains(escuero))
    assert(board.p2BoardSection.contains(exodia))
    assert(board.p2BoardSection.contains(tilin))
    assert(!board.contains(granizo))
    assertEquals(plyr2.countHand, 3)
  }

  test("Play siege card"){
    plyr1.boardSection_(board.p1BoardSection)

    plyr1.playCard(tilin)
    assert(!board.p1BoardSection.contains(escuero))
    assert(!board.p1BoardSection.contains(exodia))
    assert(board.p1BoardSection.contains(tilin))
    assert(!board.contains(granizo))
    assertEquals(plyr1.countHand, 4)

    plyr1.playCard(granizo)
    assert(!board.p1BoardSection.contains(escuero))
    assert(!board.p1BoardSection.contains(exodia))
    assert(board.p1BoardSection.contains(tilin))
    assert(board.contains(granizo))
    assertEquals(plyr1.countHand, 3)
  }

  test("Play weather card"){
    plyr2.boardSection_(board.p2BoardSection)

    plyr2.playCard(granizo)
    assert(!board.p2BoardSection.contains(escuero))
    assert(!board.p2BoardSection.contains(exodia))
    assert(!board.p2BoardSection.contains(tilin))
    assert(board.contains(granizo))
    assertEquals(plyr2.countHand, 4)

    plyr2.playCard(escuero)
    assert(board.p2BoardSection.contains(escuero))
    assert(!board.p2BoardSection.contains(exodia))
    assert(!board.p2BoardSection.contains(tilin))
    assert(board.contains(granizo))
    assertEquals(plyr2.countHand, 3)
  }

  test("No se eliminan todas las cartas iguales de la mano al jugar") {
    plyr1.boardSection_(board.p1BoardSection)

    plyr1.playCard(escuero)
    assert(plyr1.hand.contains(escuero))
    plyr1.playCard(escuero)
    assert(!plyr1.hand.contains(escuero))
  }
}
