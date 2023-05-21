package cl.uchile.dcc
package gwent.board

import gwent.card.WeatherCard

/** Class representing a board of the card game Gwent
 *
 * This board has two board sections for each player,
 * with a shared weather card section.
 *
 * This class is responsible for the weather card zone.
 */
class Board {
  /** Weather cards board section */
  private var weatherCardZone: WeatherCard = _
  /** Player 1’s board section */
  val p1BoardSection: BoardSection = new BoardSection(this)
  /** Player 2’s board section */
  val p2BoardSection: BoardSection = new BoardSection(this)

  /** Set the weather card on the board
   *
   * @param card The new weather card on the board
   */
  def playWeatherCard(card: WeatherCard): Unit = {
    weatherCardZone = card
  }


  /** Check if a weather card is in the board
   *
   * @param card the card to check.
   * @return true if the weather card is that card; false otherwise.
   */
  def contains(card: WeatherCard): Boolean = {
    weatherCardZone == card
  }
}
