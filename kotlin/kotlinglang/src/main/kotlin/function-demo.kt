//open keyword make class non final
open class A {
    // method need to be open as well
    open fun sum(a: Int = 30, b: Int): Int {
        return a + b
    }
}

class B : A() {
    // a default value for function being
    // over-ridden cannot be provided
    // <code>
    // override fun sum(a:Int = 40, b:Int) : Int {
    //     return a + b
    // }
    // </code>
    // Function above does not compile
    override fun sum(a: Int, b: Int): Int {
        return a + b
    }
}

fun main(args: Array<String>) {
    // Calling sum with default params
    println("Sum is ${B().sum(b = 20)}")
}