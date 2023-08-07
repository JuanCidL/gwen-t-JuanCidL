package cl.uchile.dcc
package gwent.card

import gwent.board.BoardSection
import gwent.card.effect.{Effect, NullEffect, UnitEffect}
import gwent.observer.Observer

import java.util.Objects

/** Abstract class representing a unit card.
 * 
 * @param name The name of the card.
 * @param description The description of the card, explaining its abilities.
 * @param strength The strength of the card.
 */
abstract class UnitCard(val name: String, val description: String, var strength: Int)
        extends UCard {

  /** The current strength */
  var currentStrength: Int = strength

  /** The effect of the card */
  protected var effect: Effect = new NullEffect()

  /** Set an effect for the card.
   * 
   * @param e the new effect to set.
   */
  def setEffect(e: UnitEffect): Unit = {
    effect = e
  }

  /** List of observers */
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

  override def equals(obj: Any): Boolean = {
    if (this.getClass.getName == obj.getClass.getName) {
      val other = obj.asInstanceOf[Card]
      this.name == other.name
    } else false
  }
  override def hashCode(): Int = Objects.hash(classOf[UnitCard], name)
}
