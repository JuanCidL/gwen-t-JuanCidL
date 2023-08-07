package cl.uchile.dcc
package gwent.observer.notification

/** Class representing a loose notification.
 *
 * @param sender the name associated to the loose.
 */
class Loose(protected val sender: String) extends Notification {
  val message: String = s"${sender} has been defeated"
}