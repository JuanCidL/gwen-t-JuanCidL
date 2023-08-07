package cl.uchile.dcc
package gwent.controller

import munit.FunSuite
import org.junit.Assert

class ControllerTest extends FunSuite{
  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller()
  }

  test("Changing states"){
    // Initialization
    controller.isInitialization()
    // Start the game => playing states
    controller.gameStart()
    assert(controller.isPlayerPlaying() || controller.isCPUPlaying())
    //If is player playing..
    if (controller.state().isPlayerPlaying()){
      //Check the cycle of playing
      controller.endTurn()
      controller.isCPUPlaying()
      controller.endTurn()
      controller.isPlayerPlaying()
      controller.endTurn()
      controller.endTurn()
      controller.isPlayerPlaying()
    }
    if (controller.state().isCPUPlaying()){
      //Check the cycle of playing
      controller.endTurn()
      controller.isPlayerPlaying()
      controller.endTurn()
      controller.isCPUPlaying()
      controller.endTurn()
      controller.endTurn()
      controller.isCPUPlaying()
    }
    //After the cycle of game..
    controller.endGame()
    controller.isEndGame()
    controller.restart()
    assert(controller.isPlayerPlaying() || controller.isCPUPlaying())
    controller.endGame()
    controller.isEndGame()
    controller.restart()
    assert(controller.isPlayerPlaying() || controller.isCPUPlaying())
    controller.endGame()
    controller.isEndGame()
    controller.restart()
    assert(controller.isPlayerPlaying() || controller.isCPUPlaying())
    controller.endGame()
    controller.isEndGame()
    controller.restart()
    assert(controller.isPlayerPlaying() || controller.isCPUPlaying())
  }

  test("Try endTurn in initialization state"){
    val e = Assert.assertThrows(classOf[ErrorState], () => controller.endTurn())
    assertEquals("Wrong transition: InitializationState can't use endTurn()", e.getMessage)
  }

  test("Try restart in initialization state"){
    val e = Assert.assertThrows(classOf[ErrorState], () => controller.restart())
    assertEquals("Wrong transition: InitializationState can't use restart()", e.getMessage)
  }

  test("Try endGame in initialization state"){
    val e = Assert.assertThrows(classOf[ErrorState], () => controller.endGame())
    assertEquals("Wrong transition: InitializationState can't use endGame()", e.getMessage)
  }

  test("Try endTurn in playing state"){
    controller.gameStart()
    if (controller.state().isPlayerPlaying()){
      val e = Assert.assertThrows(classOf[ErrorState], () => controller.gameStart())
      assertEquals("Wrong transition: PlayerPlayingState can't use gameStart()", e.getMessage)
    }
    if (controller.state().isCPUPlaying()){
      val e = Assert.assertThrows(classOf[ErrorState], () => controller.gameStart())
      assertEquals("Wrong transition: CPUPlayingState can't use gameStart()", e.getMessage)
    }
  }

  test("Try restart in playing state"){
    controller.gameStart()
    if (controller.state().isPlayerPlaying()){
      val e = Assert.assertThrows(classOf[ErrorState], () => controller.restart())
      assertEquals("Wrong transition: PlayerPlayingState can't use restart()", e.getMessage)
    }
    if (controller.state().isCPUPlaying()){
      val e = Assert.assertThrows(classOf[ErrorState], () => controller.restart())
      assertEquals("Wrong transition: CPUPlayingState can't use restart()", e.getMessage)
    }
  }

  test("Try gameStart in end game state"){
    controller.gameStart()
    controller.endGame()
    val e = Assert.assertThrows(classOf[ErrorState], () => controller.gameStart())
    assertEquals("Wrong transition: EndGameState can't use gameStart()", e.getMessage)
  }

  test("Try endTurn in end game state"){
    controller.gameStart()
    controller.endGame()
    val e = Assert.assertThrows(classOf[ErrorState], () => controller.endTurn())
    assertEquals("Wrong transition: EndGameState can't use endTurn()", e.getMessage)
  }

  test("Try endGame in end game state"){
    controller.gameStart()
    controller.endGame()
    val e = Assert.assertThrows(classOf[ErrorState], () => controller.endGame())
    assertEquals("Wrong transition: EndGameState can't use endGame()", e.getMessage)
  }
}
