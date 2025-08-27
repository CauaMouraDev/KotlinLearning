open class tigrinho(val origin:String,val color:String) {                // 1
    open fun sayHello() {       // 2
        println("A tiger says: grrrhh!")
    }
    fun showColor(){
        println(" A cor do tigrinho é $color")
    }
}

class SiberianTiger: tigrinho("Siberia","Amarelo") 
     


fun main() {
    val tiger: tigrinho = SiberianTiger()
    tiger.sayHello()
    tiger.showColor()
}
