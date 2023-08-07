package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class SiegeCardTest extends FunSuite{
  var sg1: SiegeCard = _
  var sg2: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    sg1 = new SiegeCard("sg1", "test1", 10)
    sg2 = new SiegeCard("sg2", "test2", 20)
  }

  test("Tiene mas fuerza") {
    assert(sg2.strength > sg1.strength)
  }

  test("Son cartas iguales (equals + hashCode)") {
    sg2 = SiegeCard("sg1", "test1", 20)
    assertEquals(sg1, sg2)
    assertEquals(sg1.##, sg2.##)
  }

  test("Son cartas distintas (equals + hashCode)") {
    assertNotEquals(sg1, sg2)
    assertNotEquals(sg1.##, sg2.##)
  }

  test("Objetos diferentes") {
    assert(!(sg1 == new MeleeCard("", "", 0)))
  }
}
