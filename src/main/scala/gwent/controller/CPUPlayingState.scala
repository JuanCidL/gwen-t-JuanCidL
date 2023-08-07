package cl.uchile.dcc
package gwent.controller

/** Class representing the playing state of a computer in a card game.
 *
 * @param controller The controller of the game
 */
class CPUPlayingState (controller: Controller)
  extends PlayerState(controller: Controller){
  override def endTurn(): Unit = this.changeState(new PlayerPlayingState(controller))

  override def isCPUPlaying(): Boolean = true
}