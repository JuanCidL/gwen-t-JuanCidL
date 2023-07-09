package cl.uchile.dcc
package gwent.controller

import gwent.observer.{Observer, Subject}

/** Class representing a controller for the card game.
 *
 * It is responsible for managing the creation of the necessary resources for the game
 * such as cards, players and boards.
 * In addition, it is responsible for changing states according to the flow of the game.
 */
class Controller() extends Observer[String]{

  def update(observable: Subject[String], value: String): Unit = {
    println(s"${value} has been defeated")
  }

  /** Current state of the game */
  private var _state: GameState = new InitializationState(this)

  /**Get the current state of the game.
   * 
   * @return the current sate of the game.
   */
  def state(): GameState = _state

  /** Change the state of the game.
   *
   * Its take a new state to set, and call the setController method to assign itself to the new state.
   *
   * @param newState The new state to set.
   */
  def changeState(newState: GameState): Unit = {
    _state = newState
    _state.setController(this)
  }

  /** Check if the game is in initialization state.
   *
   * @return true if is in initialization state, false otherwise
   */
  def isInitialization(): Boolean = _state.isInitialization()

  /** Check if the game is in player-playing state.
   *
   * @return true if is in player-playing state, false otherwise
   */
  def isPlayerPlaying(): Boolean = _state.isPlayerPlaying()


  /** Check if the game is in cpu-playing state.
   *
   * @return true if is in cpu-playing state, false otherwise
   */
  def isCPUPlaying(): Boolean = _state.isCPUPlaying()

  /** Check if the game is in end-game state.
   *
   * @return true if is in end-game state, false otherwise
   */
  def isEndGame(): Boolean = _state.isEndGame()


  /** Start the game changing the state to a playing state.
   */
  def gameStart(): Unit = _state.gameStart()

  /** Move to the next player’s turn.
   */
  def endTurn(): Unit = _state.endTurn()

  /** End the round in play.
   */
  def endGame(): Unit = _state.endGame()


  /**Pass to the next round.
   */
  def restart(): Unit = _state.restart()
}
