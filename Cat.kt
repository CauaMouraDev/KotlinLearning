open class Cat {                // 1
    open fun sayHello() {       // 2
        println("mew mew!")
    }
}

class Persa : Cat() {       // 3
    override fun sayHello() {   // 4
        println("miauuuu miauuuuu")
    }
}
class MaineCoon: Cat() {
     override fun sayHello(){
         print("miouu miouuu")
     }
}

fun main() {
    val cat: Cat = Persa()
    cat.sayHello()
    val cat2: Cat = MaineCoon()
    cat2.sayHello()
}
