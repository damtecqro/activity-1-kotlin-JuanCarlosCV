package com.test.kotlinactivity1

println("Problemas kotlin99  A01702008")
println("--Problem 18")
println("String: abcdefghijklmn")
   println("C1 3,7 ="+primerproblema18("abcdefghijklmn", 3, 7))
println("C2 3,9 = " +primerproblema18("abcdefghijklmn", 3, 9))

println("C3 1,4 = " +primerproblema18("abcdefghijklmn", 1, 4))

println("C4 2,5 = " +primerproblema18("abcdefghijklmn", 2, 5))

println("C5 1,6 = " +primerproblema18("abcdefghijklmn", 1, 6))

println("--Problem 37")
println("C1  10 = " + 10.totient2())
println("C2  100090 = " + 10090.totient2())
println("C3  1000 = " + 1000.totient2())
println("C4  90 = " + 90.totient2())
println("C5  10009 = " + 1009.totient2())

fun primerproblema18(n: String, x: Int, y: Int): String {
    val t= n.substring(x, y);
    return t
}

//fun <T> List<T>.tail() = drop(1)
fun Int.totient2(): Int {

    fun totient(primeFactors: List<Pair<Int, Int>>): Double =
        if (primeFactors.isEmpty()) 1.0
        else {
            val (p, m) = primeFactors.first()
            (p - 1) * Math.pow(p.toDouble(), m.toDouble() - 1) * totient(primeFactors.tail())
        }


    return totient(this.primeFactorMultiplicity()).toInt()
}



fun gcd(a: Int, b: Int): Int =
    if (a == 0) b
    else if (a > b) gcd(b, a)
    else gcd(b % a, a)

fun Int.isCoprimeTo(n: Int) = gcd(this, n) == 1
fun Int.totient() = (1..this).filter { it.isCoprimeTo(this) }.size
fun Int.isPrime() = this > 1 && (2..(this / 2)).all { this % it != 0 }
fun Int.primeFactors(): List<Int> {
    if (this.isPrime()) return listOf(this)

    val primeFactor = (2..(this / 2))
        .filter { it.isPrime() }
        .find { this % it == 0 }

    return if (primeFactor == null) emptyList()
    else listOf(primeFactor) + (this / primeFactor).primeFactors()
}

fun Int.primeFactorMultiplicity(): List<Pair<Int, Int>> =
    this.primeFactors()
        .groupBy { it }
        .map { Pair(it.key, it.value.size) }

 fun <T> List<T>.tail() = drop(1)
