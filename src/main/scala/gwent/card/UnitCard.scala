package cl.uchile.dcc
package gwent.card

class UnitCard(val name: String, val classification: String, val strength: Int)
        extends AbstractCard(name, classification) {
    over
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Card]){
        val other = obj.asInstanceOf[UnitCard]
        this.name == other.name && this.classification == other.classification
        } else false
    }
}
