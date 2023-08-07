package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class RangedCardTest extends FunSuite{
  var rg1: RangedCard = _
  var rg2: RangedCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    rg1 = new RangedCard("rg1", "test1", 10)
    rg2 = new RangedCard("rg2", "test2", 20)
  }

  test("Tiene mas fuerza") {
    assert(rg2.strength > rg1.strength)
  }

  test("Son cartas iguales (equals + hashCode)") {
    rg2 = RangedCard("rg1", "test1", 20)
    assertEquals(rg1, rg2)
    assertEquals(rg1.##, rg2.##)
  }

  test("Son cartas distintos (equals + hashCode)") {
    assertNotEquals(rg1, rg2)
    assertNotEquals(rg1.##, rg2.##)
  }

  test("Objetos diferentes"){
    assert(!(rg1 == new WeatherCard("", "")))
  }
}
