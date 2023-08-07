package cl.uchile.dcc
package gwent.controller

/** Class representing the playing state of a player in a card game.
 * 
 * @param controller The controller of the game
 */
class PlayerPlayingState(controller: Controller)
  extends PlayerState(controller: Controller){
  override def endTurn(): Unit = this.changeState(new CPUPlayingState(controller))

  override def isPlayerPlaying(): Boolean = true
}
