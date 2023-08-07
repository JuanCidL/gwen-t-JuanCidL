package cl.uchile.dcc
package gwent.card.effect

import gwent.board.{Board, BoardSection}
import gwent.card.{Card, MeleeCard, RangedCard, SiegeCard}

import gwent.player.Player
import munit.FunSuite

class MoraleBoosterTest extends FunSuite{

  var m1: MeleeCard = _
  var m2: MeleeCard = _
  var m3: MeleeCard = _
  var r1: RangedCard = _
  var r2: RangedCard = _
  var r3: RangedCard = _
  var s1: SiegeCard = _
  var s2: SiegeCard = _
  var s3: SiegeCard = _

  var board: Board = _
  var zone: BoardSection = _

  var player: Player = _

  var deck: List[Card] = _
  var hand: List[Card] = _

  override def beforeEach(context: BeforeEach): Unit = {
    /** The 3rd for each card have the morale booster effect */
    m1 = new MeleeCard("M1", "Melee example", 1)
    m2 = new MeleeCard("M2", "Melee example", 2)
    m3 = new MeleeCard("M3", "Melee example", 3)
    m3.setEffect(new MoraleBooster())
    r1 = new RangedCard("R1", "Ranged example", 1)
    r2 = new RangedCard("R2", "Ranged example", 2)
    r3 = new RangedCard("R3", "Ranged example", 3)
    r3.setEffect(new MoraleBooster())
    s1 = new SiegeCard("S1", "Siege example", 1)
    s2 = new SiegeCard("S2", "Siege example", 2)
    s3 = new SiegeCard("S3", "Siege example", 3)
    s3.setEffect(new MoraleBooster())

    board = new Board()
    zone = board.p1Zone

    /** Imagine that you have take the cards */
    deck = List()
    hand = List(m1, r1, s1, m2, r2, s2, m3, r3, s3)

    player = new Player("Player", 3, deck, hand)
    player.boardSection_(zone)
  }

  test("Melee booster"){
    player.playCard(m1)
    player.playCard(r1)
    player.playCard(s1)
    player.playCard(m2)
    player.playCard(r2)
    player.playCard(s2)

    assertEquals(m1.currentStrength, 1)
    assertEquals(m2.currentStrength, 2)
    assertEquals(m3.currentStrength, 3)

    /** Apply the effect */
    player.playCard(m3)

    /** Check if the cards on the board had been affected */
    assertEquals(m1.currentStrength, 1+1)
    assertEquals(m2.currentStrength, 2+1)
    /** Check if the card played had not affected */
    assertEquals(m3.currentStrength, 3)
    /** Check if the other type of cards had not affected */
    assertEquals(r1.currentStrength, 1)
    assertEquals(s1.currentStrength, 1)
    assertEquals(r2.currentStrength, 2)
    assertEquals(s2.currentStrength, 2)
  }

  test("Ranged booster"){
    player.playCard(m1)
    player.playCard(r1)
    player.playCard(s1)
    player.playCard(m2)
    player.playCard(r2)
    player.playCard(s2)

    assertEquals(r1.currentStrength, 1)
    assertEquals(r2.currentStrength, 2)
    assertEquals(r3.currentStrength, 3)

    /** Apply the effect */
    player.playCard(r3)

    /** Check if the cards on the board had been affected */
    assertEquals(r1.currentStrength, 1+1)
    assertEquals(r2.currentStrength, 2+1)
    /** Check if the card played had not affected */
    assertEquals(r3.currentStrength, 3)
    /** Check if the other type of cards had not affected */
    assertEquals(m1.currentStrength, 1)
    assertEquals(s1.currentStrength, 1)
    assertEquals(m2.currentStrength, 2)
    assertEquals(s2.currentStrength, 2)
  }

  test("Siege booster"){
    player.playCard(m1)
    player.playCard(r1)
    player.playCard(s1)
    player.playCard(m2)
    player.playCard(r2)
    player.playCard(s2)

    assertEquals(s1.currentStrength, 1)
    assertEquals(s2.currentStrength, 2)
    assertEquals(s3.currentStrength, 3)

    /** Apply the effect */
    player.playCard(s3)

    /** Check if the cards on the board had been affected */
    assertEquals(s1.currentStrength, 1+1)
    assertEquals(s2.currentStrength, 2+1)
    /** Check if the card played had not affected */
    assertEquals(s3.currentStrength, 3)
    /** Check if the other type of cards had not affected */
    assertEquals(m1.currentStrength, 1)
    assertEquals(r1.currentStrength, 1)
    assertEquals(m2.currentStrength, 2)
    assertEquals(r2.currentStrength, 2)
  }
}
