package cl.uchile.dcc
package gwent.board

import gwent.card.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard}

/** Class representing a board section from one player.
 *
 * This class is mainly responsible for organizing each play of the different types of cards.
 *
 * @param board The board linked to this section
 */
class BoardSection(board: Board) {
  
  /** List for Melee cards zone */
  private var meleeZone: List[MeleeCard] = List()
  /** List for Ranged cards zone */
  private var rangedZone: List[RangedCard] = List()
  /** List for Siege cards zone */
  private var siegeZone: List[SiegeCard] = List()

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
    meleeZone = card :: meleeZone
  }

  /** This method has the purpose of placing the ranged card in its corresponding zone.
   *
   * @param card the card to play on the board
   */
  def playRangedCard(card: RangedCard): Unit = {
    rangedZone = card :: rangedZone
  }

  /** This method has the purpose of placing the siege card in its corresponding zone.
   *
   * @param card the card to play on the board
   */
  def playSiegeCard(card: SiegeCard): Unit = {
    siegeZone = card :: siegeZone
  }

  /** This method has the purpose of placing the weather card in its corresponding zone.
   *
   * @param card the card to play on the board
   */
  def playWeatherCard(card: WeatherCard): Unit = {
    board.weatherCardZone_(card)
  }
}
