package cl.uchile.dcc
package gwent.card

import munit.FunSuite

class WeatherCardTest extends FunSuite{
  var wt1: WeatherCard = _
  var wt2: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    wt1 = new WeatherCard("wt1", "test1")
    wt2 = new WeatherCard("wt2", "test2")
  }
  

  test("Son cartas iguales (equals + hashCode)") {
    wt2 = WeatherCard("wt1", "test1")
    assertEquals(wt1, wt2)
    assertEquals(wt1.##, wt2.##)
  }

  test("Son cartas distintas (equals + hashCode)") {
    assert(!wt1.equals(wt2))
    assertNotEquals(wt1.##, wt2.##)
  }
  
  test("Objetos diferentes"){
    assert(!(wt1 == new RangedCard("","",0)))
  }
}
