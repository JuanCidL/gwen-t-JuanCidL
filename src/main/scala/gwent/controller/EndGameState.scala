package cl.uchile.dcc
package gwent.controller

/** Class representing a ending round state of a card game.
 * 
 * @param controller The controller of the game
 */
class EndGameState(controller: Controller)
  extends GameState(controller: Controller){
  override def restart(): Unit = {
    if (Math.random() > 0.5)
      this.changeState(new PlayerPlayingState(controller))
    else
      this.changeState(new CPUPlayingState(controller))
  }

  override def end(): Unit = {
    this.changeState(new EndState(controller))
  }

  override def isEndGame(): Boolean = true
}
