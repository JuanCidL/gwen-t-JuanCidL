package cl.uchile.dcc
package gwent.player

import java.util.Objects

/** A class representing a computer
 *
 * This player is defined by a name
 *
 * @param name The name of the user
 */
class CPU(name: String) extends AbstractPlayer(name) {
  var board: String = ""
  var gems: Int = 0

  /** Not yet
   */
  def play(): Unit = {}

  override def hashCode(): Int = Objects.hash(classOf[CPU], name)

}
