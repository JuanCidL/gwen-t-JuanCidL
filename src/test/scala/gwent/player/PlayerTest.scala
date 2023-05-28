package cl.uchile.dcc
package gwent.player

import gwent.card.{Card, MeleeCard, RangedCard, SiegeCard}
import munit.FunSuite

class PlayerTest extends FunSuite{
  var plyr1: Player = _
  var plyr2: Player = _

  val escuero: MeleeCard = new MeleeCard("Escuero", "Tortuguita", 20)
  val exodia: RangedCard = new RangedCard("Exodia", "El prohibido", 999)
  val tilin: SiegeCard = new SiegeCard("Tilin", "Eso tilin", 100)

  var deck1: List[Card] = _
  var deck2: List[Card] = _
  var hand1: List[Card] = _
  var hand2: List[Card] = _



  override def beforeEach(context: BeforeEach): Unit = {
    deck1 = List(escuero, exodia, exodia, tilin)
    deck2 = List(exodia, tilin, escuero)
    hand1 = List()
    hand2 = List()
    
    plyr1 = new Player("Pedro", 3, deck1, hand1)
    plyr2 = new Player("Fernando", 3, deck2, hand2)
  }

  test("Shufle"){
    plyr1.shuffleDeck()
    assertEquals(plyr1.countHand, 0)
    assertEquals(plyr1.countDeck, 4)
  }

  test("Tiene 4 cartas en mazo"){
    assertEquals(plyr1.countDeck,4)
  }

  test("Prueba metodo drawCard"){
    plyr1.drawCard()
    assertEquals(plyr1.countHand, 1)
    assertEquals(plyr1.countDeck,3)
    plyr1.drawCard()
    plyr1.drawCard()
    plyr1.drawCard()
    assert(!plyr1.deck.contains(escuero))
    assert(!plyr1.deck.contains(exodia))
    assert(!plyr1.deck.contains(tilin))
    assertEquals(plyr1.countHand, 4)
    assertEquals(plyr1.countDeck,0)
  }

  test("Jugadores distintos (equals + hash)"){
    assertNotEquals(plyr1, plyr2)
    assertNotEquals(plyr1.##, plyr2.##)
  }

  test("Jugadores iguales (equals + hash)") {
    plyr2 = new Player("Pedro", 0, deck2, hand1)
    assertEquals(plyr1, plyr2)
    assertEquals(plyr1.##, plyr2.##)
  }

  test("Objetos diferentes"){
    assert(!(plyr1 == escuero))
  }
}
