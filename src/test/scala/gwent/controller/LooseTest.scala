package cl.uchile.dcc
package gwent.controller

import gwent.player.Player
import munit.FunSuite
import org.junit.Assert

class LooseTest extends FunSuite{
  var plyr1: Player = _
  var plyr2: Player = _

  var controller: Controller = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new Controller()
    plyr1 = new Player("P1", 3, List(), List())
    plyr2 = new Player("P2", 3, List(), List())
    plyr1.addObserver(controller)
    plyr2.addObserver(controller)
  }

  test("Try end in initialization state") {
    val e = Assert.assertThrows(classOf[ErrorState], () => plyr1.gems_(0))
    assertEquals("Wrong transition: InitializationState can't use end()", e.getMessage)
  }

  test("Try end in playing state") {
    controller.gameStart()
    if (controller.state().isPlayerPlaying()) {
      val e = Assert.assertThrows(classOf[ErrorState], () => plyr2.gems_(0))
      assertEquals("Wrong transition: PlayerPlayingState can't use end()", e.getMessage)
    }
    if (controller.state().isCPUPlaying()) {
      val e = Assert.assertThrows(classOf[ErrorState], () => plyr1.gems_(0))
      assertEquals("Wrong transition: CPUPlayingState can't use end()", e.getMessage)
    }
  }

  test("End works") {
    controller.gameStart()
    controller.endGame()
    plyr1.gems_(0)
    assert(controller.isEnd())
  }

  test("Negative gems") {
    controller.gameStart()
    controller.endGame()
    plyr2.gems_(-999)
    assert(controller.isEnd())
  }
}
