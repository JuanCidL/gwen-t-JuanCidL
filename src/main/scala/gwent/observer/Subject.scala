package cl.uchile.dcc
package gwent.observer


/** Interface representing a Subject for the observer pattern.
 * 
 * @tparam T the generic class for the value of subject-observer.
 */
trait Subject[T] {
  /** Add a new observer to the subject.
   *
   * @param observer the new observer to add.
   */
  def addObserver(observer: Observer[T]): Unit

  /** Notify to all observers of the subject with a value.
   *
   * @param value a value to notify to the observers of the subject.
   */
  def notifyObserver(value: T): Unit
}
