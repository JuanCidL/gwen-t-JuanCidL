package cl.uchile.dcc
package gwent.card

import munit.FunSuite


class CardTest extends FunSuite {
  var unt1: UnitCard = _
  var unt2: UnitCard = _
  var wth1: WeatherCard = _
  var wth2: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    unt1 = new UnitCard("Tropa1", "Campo1")
    unt2 = new UnitCard("Tropa2", "Campo2")
    wth1 = new WeatherCard("Tropa3", "Campo1")
    wth2 = new WeatherCard("Tropa4", "Campo2")
  }

  test("Son cartas iguales") {
    unt1 = new UnitCard("A", "B")
    unt2 = new UnitCard("A", "B")
    wth1 = new WeatherCard("A", "B")
    wth2 = new WeatherCard("A", "B")
    assertEquals(unt1, unt2)
    assertEquals(wth1, wth2)
  }
  test("Son cartas distintas"){
    assertNotEquals(unt1, unt2)
    assertNotEquals(wth1, wth2)
  }
  test("HashCode iguales"){
    unt1 = new UnitCard("A", "B")
    unt2 = new UnitCard("A", "B")
    wth1 = new WeatherCard("A", "B")
    wth2 = new WeatherCard("A", "B")
    assertEquals(unt1.##, unt2.##)
    assertEquals(wth1.##, wth2.##)
  }
  test("Hashcode distintos"){
    assertNotEquals(unt1.##, unt2.##)
    assertNotEquals(wth1.##, wth2.##)
  }
}
