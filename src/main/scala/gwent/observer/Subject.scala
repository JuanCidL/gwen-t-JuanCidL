package cl.uchile.dcc
package gwent.observer

import gwent.card.effect.Effect

/** Interface representing a Subject for the observer pattern
 * 
 */
trait Subject {
  
  /** Add a new observer to the subject.
   * 
   * @param observer the new observer to add.
   */
  def addObserver(observer: Observer): Unit

  /** Notify to all observers of the subject with a effect.
   * 
   * @param value a effect to notify to the observers of the subject.
   */
  def notifyObserver(value: Effect): Unit
}
