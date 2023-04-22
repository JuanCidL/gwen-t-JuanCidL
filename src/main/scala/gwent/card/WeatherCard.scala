package cl.uchile.dcc
package gwent.card

import java.util.Objects

/** A class representing a weather card
 *
 * @param name The name of the card
 * @param classification The classification of the card
 */
class WeatherCard(name: String, classification: String)
        extends AbstractCard(name, classification){
  override def equals(obj: Any): Boolean = super.equals(obj)

  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], name)

}
