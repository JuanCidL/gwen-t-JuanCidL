package cl.uchile.dcc
package gwent.card

import gwent.board.BoardSection

/** Class representing a siege unit card.
 *
 * Siege cards can only be placed in the siege combat zone.
 *
 * @param name        The name of the card.
 * @param description The description of the card, explaining its abilities.
 * @param strength    The strength of the card.
 */
class SiegeCard(name: String, description: String, strength: Int) extends UnitCard(name, description, strength) {

  /** This method tells the board that the type of card will be siege.
   *
   * The card calls the method of playing with the siege card of the board section, using itself.
   *
   * @param section Is the section of the board to use.
   */
  def play(section: BoardSection): Unit = {
    section.playSiegeCard(this)
    notifyObserver(effect)
  }
}