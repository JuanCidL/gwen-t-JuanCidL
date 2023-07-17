package cl.uchile.dcc
package gwent.observer.notification

/** Interface representing a notification that has a sender and a message.
 */
trait Notification {
  protected val sender: String
  val message: String
}
