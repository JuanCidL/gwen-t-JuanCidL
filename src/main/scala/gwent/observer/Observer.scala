package cl.uchile.dcc
package gwent.observer

/** Interface to represent a observer, to use the observer pattern.
 *
 * @tparam T a generic class to define the values of the observer.
 */
trait Observer[T] {
  /** Update some parameters of a observable subject.
   *
   * @param observable A observable object to shot a update in the observer.
   * @param value      a value to use in the update.
   */
  def update(observable: Subject[T], value: T): Unit
}
