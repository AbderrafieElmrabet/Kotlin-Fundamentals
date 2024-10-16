package com.example.tutorials

fun main() {
    val coins: (Int) -> String = {
        quantity -> "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "have a cupcake!"
    }
    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    treatFunction()
    trickFunction()
}
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?):() -> Unit {
    if(isTrick){
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}

val trick = {
    println("no treats")
}

val treat: () -> Unit = {
    println("no treats")
}