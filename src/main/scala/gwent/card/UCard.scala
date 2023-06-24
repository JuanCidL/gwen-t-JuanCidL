package cl.uchile.dcc
package gwent.card

/** A trait to implement strength on the unit cards,
 * and some functions to check the type of the cardsiege.
 */
trait UCard extends Card {
  var strength: Int
  var currentStrength: Int
  
  /** Check if the card is a melee card.
   * @return true if the card is a melee card, false otherwise. 
   */
  def isMelee: Boolean

  /** Check if the card is a ranged card.
   * @return true if the card is a ranged card, false otherwise. 
   */
  def isRanged: Boolean

  /** Check if the card is a siege card.
   * @return true if the card is a siege card, false otherwise. 
   */
  def isSiege: Boolean
}
