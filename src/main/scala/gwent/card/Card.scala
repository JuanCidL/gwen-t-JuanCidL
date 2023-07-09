package cl.uchile.dcc
package gwent.card

import gwent.board.BoardSection
import gwent.card.effect.Effect
import gwent.observer.{Observer, Subject}

/** Trait representing a card.
 *
 * A card is characterized by its name and description that identifies it.
 * These parameters are immutable.
 */
trait Card  extends Subject[Effect]{
  /** The name of the card */
  val name: String
  /** The description of the card */
  val description: String
  /** The effect of the card */
  protected var effect: Effect
  /** The observers of the card */
  protected var observers: List[Observer[Effect]]

  /** Set an effect for the card.
   *
   * @param e the new effect to set.
   */
  def setEffect(e: Effect): Unit

  /** This method has the purpose of redirecting to the corresponding method
   * of the card to be played on the board.
   * 
   * @param section Is the section of the board to use.
   */
  def play(section: BoardSection): Unit
}