package cl.uchile.dcc
package gwent.card

import gwent.board.BoardSection
import gwent.card.effect.{Effect, NullEffect, WeatherEffect}
import gwent.observer.Observer

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
  def setEffect(e: WeatherEffect): Unit = {
    effect = e
  }

  /** List of observers of the card */
  protected var observers: List[Observer[Effect]] = List()

  /** Add a observer to the observer list.
   *
   * @param observer the new observer to add.
   */
  def addObserver(observer: Observer[Effect]): Unit = {
    observers = observer :: observers
  }

  /** Apply update method to all observers in the observer list.
   *
   * @param value a Effect value to notify to the observers of the subject.
   */
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
