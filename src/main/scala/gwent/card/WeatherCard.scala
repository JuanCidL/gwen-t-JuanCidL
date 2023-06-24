package cl.uchile.dcc
package gwent.card

import gwent.board.BoardSection
import gwent.card.effect.{Effect, NullEffect}
import gwent.observer.{Observer, Subject}

import java.util.Objects

/** A class representing a weather card.
 *
 * @param name The name of the card.
 * @param description The classification of the card, explaining its abilities.
 */
class WeatherCard(val name: String, val description: String)
        extends Card {

  /** The effect of the card */
  protected var effect: Effect = new NullEffect()

  /** Set an effect for the card.
   *
   * @param e the new effect to set.
   */
  def setEffect(e: Effect): Unit = {
    effect = e
  }

  /** List of observers of the card */
  protected var observers: List[Observer] = List()

  def addObserver(observer: Observer): Unit = {
    observers = observer :: observers
  }

  def notifyObserver(value: Effect): Unit = {
    for (observer <- observers) {
      observer.update(this, value)
    }
  }


  /** This method tells the board that the type of card will be weather.
   *
   * The card calls the method of playing with the weather card of the board section, using itself.
   *
   * @param section Is the section of the board to use.
   */
  def play(section: BoardSection): Unit = {
    section.playWeatherCard(this)
    notifyObserver(effect)
  }
  
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      val other = obj.asInstanceOf[Card]
      this.name == other.name && this.description == other.description
    } else false
  }
  override def hashCode(): Int = Objects.hash(classOf[WeatherCard], name, description)

}
