package cl.uchile.dcc
package gwent.card

import gwent.board.BoardSection

/** Trait representing a card.
 *
 * A card is characterized by its name and description that identifies it.
 * These parameters are immutable.
 */
trait Card{
  /** The name of the card */
  val name: String
  /** The description of the card */
  val description: String

  /** This method has the purpose of redirecting to the corresponding method
   * of the card to be played on the board.
   * 
   * @param section Is the section of the board to use.
   */
  def play(section: BoardSection): Unit
}