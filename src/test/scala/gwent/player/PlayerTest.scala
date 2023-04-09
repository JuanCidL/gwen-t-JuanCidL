package cl.uchile.dcc
package gwent.player

import munit.FunSuite
class PlayerTest extends FunSuite {
  var usr1: Player = _
  var usr2: Player = _
  var cpu1: Player = _
  var cpu2: Player = _

  override def beforeEach(context: BeforeEach): Unit = {
    usr1 = new User("Pedro", 40)
    usr2 = new User("Juan", 30)
    cpu1 = new CPU("Diego", 60)
    cpu1 = new CPU("Pedro", 40)
  }

  test("Tiene mas gemas"){
    assert(usr1.gems > usr2.gems)
  }
  test("Tiene menos gemas") {
    assert(usr1.gems < cpu1.gems)
  }
  test("Tiene igual cantidad de gemas") {
    assert(usr1.gems == cpu2.gems)
  }

  test("Tiene mas cartas en mano") {
    assert(usr1.counthCards() > usr2.counthCards())
  }
  test("Tiene menos cartas en mano") {
    assert(usr1.counthCards() > cpu2.counthCards())
  }
  test("Igual cantidad de cartas en mano") {
    assert(usr1.counthCards() == cpu1.counthCards())
  }


}
