package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class MeleeCardTest extends FunSuite{
  var mc1: MeleeCard = _
  var mc2: MeleeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    mc1 = new MeleeCard("mc1", "test1", 10)
    mc2 = new MeleeCard("mc2", "test2", 20)
  }

  test("Tiene mas fuerza"){
    assert(mc2.strength > mc1.strength)
  }

  test("Son cartas iguales (equals + hashCode)"){
    mc2 = MeleeCard("mc1", "test1", 20)
    assertEquals(mc1, mc2)
    assertEquals(mc1.##, mc2.##)
  }

  test("Son cartas distintos (equals + hash)"){
    assertNotEquals(mc1, mc2)
    assertNotEquals(mc1.##, mc2.##)
  }

  test("Objetos diferentes") {
    assert(!(mc1 == new SiegeCard("", "", 0)))
  }
}
