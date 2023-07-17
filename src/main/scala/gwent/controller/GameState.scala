package cl.uchile.dcc
package gwent.controller

/** Class representing a game state of a card game.
 * 
 * A game state take a controller in it constructor to manage all states from the game.
 * 
 * @param controller The controller of the game
 */
class GameState(private var controller: Controller) {

  /** Deliver a state error.
   *
   * When you try to use a transition from a state that does not define it, the error is called.
   *
   * @param targetState the name of the transition
   */
  private def gameError(targetState: String): Unit = {
    throw new ErrorState(s"Wrong transition: ${getClass.getSimpleName} can't use ${targetState}")
  }

  /** Set to "InGame" state from a Initialization state.
   *
   * If called from the Initialization state, it will change to the target state. Otherwise, the error is called.
   */
  def gameStart(): Unit = gameError("gameStart()")

  /** Set to the other Player state from a Player state state.
   *
   * If called from the {Player or CPU} playing state, it will change to the target state. Otherwise, the error is called.
   */
  def endTurn(): Unit = gameError("endTurn()")

  /** Set to EndGame state from a "InGame" state.
   *
   * If called from the {Player or CPU} state, it will change to the target state. Otherwise, the error is called.
   */
  def endGame(): Unit = gameError("endGame()")

  /** Re-set to "InGame" state from a Initialization state.
   *
   * If called from the EndGame state, it will change to the target state. Otherwise, the error is called.
   */
  def restart(): Unit = gameError("restart()")

  /** End the game.
   *
   * If called from the EndGame state, it will change to the target state. Otherwise, the error is called.
   */
  def end(): Unit = gameError("end()")
  

  /**Check if is in initialization state
   *
   * @return true if is in initialization state, false otherwise
   */
  def isInitialization(): Boolean = false

  /**Check if is in player-playing state
   *
   * @return true if is in player-playing state, false otherwise
   */
  def isPlayerPlaying(): Boolean = false

  /**Check if is in cpu-playing state
   *
   * @return true if is in cpu-playing state, false otherwise
   */
  def isCPUPlaying(): Boolean = false

  /**Check if is in end-game state
   *
   * @return true if is in end-game state, false otherwise
   */
  def isEndGame(): Boolean = false

  /**Check if is in end-game state
   *
   * @return true if is in end-game state, false otherwise
   */
  def isEnd(): Boolean = false

  /** Change the state of the game.
   *
   * It call the chageState method from the controller to do it.
   *
   * @param state The state to change.
   */
  def changeState(state: GameState): Unit = {
    controller.changeState(state)
  }

  /** Set the controller for the current state.
   *
   * This method sets the state controller to the next one when a new state is created.
   *
   * @param controller the controller.
   */
  def setController(controller: Controller): Unit = {
    this.controller = controller
  }
}
