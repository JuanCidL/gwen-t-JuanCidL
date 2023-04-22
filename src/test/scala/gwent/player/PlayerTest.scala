package cl.uchile.dcc
package gwent.player

import munit.FunSuite

class PlayerTest extends FunSuite {
  var usr1: User = _
  var usr2: User = _
  var cpu1: CPU = _
  var cpu2: CPU = _

  override def beforeEach(context: BeforeEach): Unit = {
    usr1 = new User("Pedro")
    usr1.addCard()
    usr1.addCard()
    usr1.addCard()
    usr1.addCard()

    usr2 = new User("Juan")
    usr2.addCard()


    cpu1 = new CPU("Diego")
    cpu1.addCard()
    cpu1.addCard()
    cpu1.addCard()
    cpu1.addCard()

    cpu2 = new CPU("Pedro")
    cpu2.addCard()
    cpu2.addCard()
  }

  test("Son jugadores iguales"){
    usr1 = new User("Pepito")
    usr2 = new User("Pepito")
    cpu1 = new CPU("Pepito")
    cpu2 = new CPU("Pepito")
    assertEquals(usr1, usr2)
    assertEquals(cpu1, cpu2)
  }
  test("Son jugadores distintos"){
    assertNotEquals(usr1, usr2)
    assertNotEquals(cpu1, cpu2)
  }
  test("Hashcode iguales"){
    usr1 = new User("Pepito")
    usr2 = new User("Pepito")
    cpu1 = new CPU("Pepito")
    cpu2 = new CPU("Pepito")
    assertEquals(usr1.##, usr2.##)
    assertEquals(cpu1.##, cpu2.##)
  }
  test("Hashcode distintos"){
    assertNotEquals(usr1.##, usr2.##)
    assertNotEquals(cpu1.##, cpu2.##)
  }

  test("Tiene mas cartas en mazo"){
    assert(usr1.countDeckCards() > cpu2.countDeckCards())
  }
  test("Tiene menos cartas en mazo"){
    assert(usr2.countDeckCards() < cpu1.countDeckCards())
  }
  test("Tienen igual cantidad de cartas en mazo"){
    assertEquals(usr1.countDeckCards(), cpu1.countDeckCards())
  }

  test("Metodo take"){
    // Tamaño del mazo y mano
    val deckLength = usr1.countDeckCards()
    val handLength = usr1.countHandCards()
    //se toma 1 carta del mazo a la mano
    usr1.take()
    //se comprueban los cambios
    assertEquals(usr1.countDeckCards(), deckLength - 1)
    assertEquals(usr1.countHandCards(), handLength + 1)
    //se toman 2 cartas del mazo a la mano
    usr1.take()
    usr1.take()
    //se comprueban los cambios
    assertEquals(usr1.countDeckCards(), deckLength - 3)
    assertEquals(usr1.countHandCards(), handLength + 3)
  }
}