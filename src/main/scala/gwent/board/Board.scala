package cl.uchile.dcc
package gwent.board

import gwent.card.WeatherCard
import gwent.card.effect.Effect
import gwent.observer.{Observer, Subject}

/** Class representing a board of the card game Gwent
 *
 * This board has two board sections for each player,
 * with a shared weather card section.
 *
 * This class is responsible for the weather card zone.
 */
class Board {
  /** Weather cards board section (it starts with a empty card) */
  private var _weatherCardZone: WeatherCard = new WeatherCard("", "")


  /** Get the card of the weather zone
   * @return the card on the weather zone
   */
  def weatherCardZone: WeatherCard = _weatherCardZone

  /** Set a card to the weather zone
   * @param card the weather card to put on the board
   */
  def weatherCardZone_(card: WeatherCard): Unit = {
    _weatherCardZone = card
  }
  /** Player 1’s board section */
  private val _p1Zone: BoardSection = new BoardSection(this)

  /** Gets the zone of the player 1
   * @return the zone of the player 1
   */
  def p1Zone: BoardSection = _p1Zone
  
  /** Player 2’s board section */
  private val _p2Zone: BoardSection = new BoardSection(this)
  
  /** Gets the zone of the player 2
   * @return the zone of the player 2
   */
  def p2Zone: BoardSection = _p2Zone
}
