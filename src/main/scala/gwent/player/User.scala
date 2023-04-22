package cl.uchile.dcc
package gwent.player

import java.util.Objects

/** A class representing a user
 *
 * This player is defined by a name
 *
 * @param name The name of the user
 */
class User(name: String) extends AbstractPlayer(name){
  var board: String = ""
  var gems: Int = 1

  /** Not yet
   */
  def play(): Unit = {}

  override def hashCode(): Int = Objects.hash(classOf[User], name)
}
