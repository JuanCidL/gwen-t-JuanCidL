package cl.uchile.dcc
package gwent.card

/** A trait to implement strength on the unit cards,
 * and some functions to check the type of the cardsiege.
 */
trait UCard extends Card {
  var strength: Int
  var currentStrength: Int
}
