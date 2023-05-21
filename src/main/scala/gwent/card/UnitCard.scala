package cl.uchile.dcc
package gwent.card

import cl.uchile.dcc.gwent.board.BoardSection

import java.util.Objects

/** Abstract class representing a unit card.
 * 
 * @param name The name of the card.
 * @param description The description of the card, explaining its abilities.
 * @param strength The strength of the card.
 */
abstract class UnitCard(val name: String, val description: String, val strength: Int)
        extends Card {

  //var currentStrength = strength

  override def equals(obj: Any): Boolean = {
    if (this.getClass.getName == obj.getClass.getName) {
      val other = obj.asInstanceOf[Card]
      this.name == other.name && this.description == other.description
    } else false
  }
  override def hashCode(): Int = Objects.hash(classOf[UnitCard], name)
}
