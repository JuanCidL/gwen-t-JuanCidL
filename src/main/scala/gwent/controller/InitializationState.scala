package cl.uchile.dcc
package gwent.controller

/** Class representing a Initial state of a card game.
 * 
 * @param controller The controller of the game
 */
class InitializationState(controller: Controller)
  extends GameState(controller: Controller) {
  override def gameStart(): Unit = {
    if (Math.random()>0.5)
      this.changeState(new PlayerPlayingState(controller: Controller))
    else
      this.changeState(new CPUPlayingState(controller: Controller))
  }

  override def isInitialization(): Boolean = true
}
