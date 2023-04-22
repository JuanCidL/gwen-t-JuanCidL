package cl.uchile.dcc
package gwent.card

import java.util.Objects

/** A class representing a unit card
 * 
 * @param name The name of the card
 * @param classification The classification of the card
 */
class UnitCard(name: String, classification: String)
        extends AbstractCard(name, classification) {
  
  private var _strength = 0

  def strength(st: Int): Unit = _strength = st
  
  override def hashCode(): Int = Objects.hash(classOf[UnitCard], name)
}
