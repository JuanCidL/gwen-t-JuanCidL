package cl.uchile.dcc
package gwent.card

import java.util.Objects

/** An abstract class to help the construction of cards
 * @param name
 * @param classification
 */
abstract class AbstractCard(val name: String, val classification: String) extends Card{
  override def equals(obj: Any): Boolean = {
    if (this.getClass.getName == obj.getClass.getName) {
      val other = obj.asInstanceOf[Card]
      this.name == other.name && this.classification == other.classification
    } else false
  }
}
