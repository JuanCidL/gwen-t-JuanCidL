package cl.uchile.dcc
package gwent.card

import gwent.board.BoardSection

/** Class representing a melee unit card.
 *
 * Melee cards can only be placed in the melee combat zone.
 *
 * @param name        The name of the card.
 * @param description The description of the card, explaining its abilities.
 * @param strength    The strength of the card.
 */
class MeleeCard(name: String, description: String, strength: Int) extends UnitCard(name, description, strength) {

  /** This method tells the board that the type of card will be melee.
   *
   * The card calls the method of playing with the melee card of the board section, using itself.
   *
   * @param section Is the section of the board to use.
   */
  def play(section: BoardSection): Unit = {
    section.playMeleeCard(this)
    notifyObserver(effect)
  }
}