package cl.uchile.dcc
package gwent.controller

/** Class representing a ending state of a card game.
 * 
 * @param controller The controller of the game
 */
class EndGameState(controller: Controller)
  extends GameState(controller: Controller){
  override def restart(): Unit = {
    if (Math.random() > 0.5)
      this.changeState(new PlayerPlayingState(controller: Controller))
    else
      this.changeState(new CPUPlayingState(controller: Controller))
  }

  override def isEndGame(): Boolean = true
}
