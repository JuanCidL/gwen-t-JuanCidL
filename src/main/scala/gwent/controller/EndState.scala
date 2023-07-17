package cl.uchile.dcc
package gwent.controller

class EndState(controller: Controller)
  extends GameState(controller: Controller){
  override def isEnd(): Boolean = true
}
