package cl.uchile.dcc
package gwent.controller

/** Abstract class representing the playing state of a generic player in a card game.
 *
 * @param controller The controller of the game
 */
abstract class PlayerState(controller: Controller)
  extends GameState(controller: Controller){
  override def endGame(): Unit = this.changeState(new EndGameState(controller))
}
