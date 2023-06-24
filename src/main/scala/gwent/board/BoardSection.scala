package cl.uchile.dcc
package gwent.board

import gwent.card.{Card, MeleeCard, RangedCard, SiegeCard, UCard, WeatherCard}

import gwent.card.effect.Effect
import gwent.observer.Observer

/** Class representing a board section from one player.
 *
 * This class is mainly responsible for organizing each play of the different types of cards.
 *
 * @param board The board linked to this section
 */
class BoardSection(board: Board) extends Observer {
  
  /** List for Melee cards zone */
  private val meleeZone: CardList = new CardList()
  /** List for Ranged cards zone */
  private val rangedZone: CardList = new CardList()
  /** List for Siege cards zone */
  private val siegeZone: CardList = new CardList()

  /** Apply the effect of the observable to all the cards of the player
   * with the same type of the observable.
   *
   * @param observable A obserbable object to shot a update in the observer.
   * @param value      a value to use in the update.
   */
  def update(observable: Card, value: Effect): Unit = {
    value(observable, meleeZone)
    value(observable, rangedZone)
    value(observable, siegeZone)
  }

  /** Check if the board section contains a card.
   * 
   * @param card The card to check.
   * @return true if the section contains the card; false otherwise
   */
  def contains(card: Card): Boolean = {
    meleeZone.contains(card) || rangedZone.contains(card) || siegeZone.contains(card)
  }
  
  /** This method has the purpose of placing the melee card in its corresponding zone.
   *
   * @param card The card to play on the board.
   */
  def playMeleeCard(card: MeleeCard): Unit = {
    meleeZone.addCard(card)
    card.addObserver(meleeZone)
  }

  /** This method has the purpose of placing the ranged card in its corresponding zone.
   *
   * @param card the card to play on the board
   */
  def playRangedCard(card: RangedCard): Unit = {
    rangedZone.addCard(card)
    card.addObserver(rangedZone)
  }

  /** This method has the purpose of placing the siege card in its corresponding zone.
   *
   * @param card the card to play on the board
   */
  def playSiegeCard(card: SiegeCard): Unit = {
    siegeZone.addCard(card)
    card.addObserver(siegeZone)
  }

  /** This method has the purpose of placing the weather card in its corresponding zone.
   *
   * @param card the card to play on the board
   */
  def playWeatherCard(card: WeatherCard): Unit = {
    board.weatherCardZone_(card)
    card.addObserver(board)
  }
}
