package cl.uchile.dcc
package gwent.observer

import gwent.card.Card

import gwent.card.effect.Effect

/** Interface to represent a observer, to use the observer pattern.
 *
 * @tparam E a generic class to define the values of the observer.
 */
trait Observer {
  /** Update some parameters of a observable subject.
   *
   * @param observable A card object to shot a update in the observer.
   * @param value a value to use in the update.
   */
  def update(observable: Card, value: Effect): Unit
}
