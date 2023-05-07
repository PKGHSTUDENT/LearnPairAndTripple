import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("@dobrodelete")

    while(true) {
        print("Enter task(0 - exit): ")
        try {
            when (readln()!!.toInt()) {
                0 -> {
                    exitProcess(0)
                }
                1 -> {
                    print("Enter count seconds: ")
                    val seconds = readln()?.toLong() ?: 0
                    val (hours, minutes, remainingSeconds) = convertSecondsToHMS(seconds)
                    println("$seconds seconds = $hours hours $minutes minutes $remainingSeconds seconds")
                }
                2 -> {
                    print("Enter x1: ")
                    var x1: Double = readln()!!.toDouble()
                    print("Enter y1: ")
                    var y1: Double = readln()!!.toDouble()
                    val xy1 = Pair(x1, y1)

                    print("Enter x2: ")
                    var x2: Double = readln()!!.toDouble()
                    print("Enter y2: ")
                    var y2: Double = readln()!!.toDouble()
                    val xy2 = Pair(x2, y2)
//                    val xy1 = 1.0 to 2.0
//                    val xy2 = 4.0 to 6.0

                    val distance = calculateDistance(xy1, xy2)

                    println("Расстояние между точками (${xy1.first}, ${xy1.second}) и (${xy2.first}, ${xy1.second}) равно $distance")
                }
                3 -> {
                    print("Enter a: ")
                    val a = readln()!!.toInt()
                    print("Enter b: ")
                    val b = readln()!!.toInt()

                    val result = calculateNodAndNok(a, b)

                    println("НОД($a, $b) = ${result.first}")
                    println("НОК($a, $b) = ${result.second}")
                }
                else -> {
                    println("Incorrect choice.")
                }
            }
        }
        catch (ex: Exception) {
            println("Error: ${ex.stackTrace}")
        }
    }
}

fun convertSecondsToHMS(seconds: Long): Triple<Long, Long, Long> {
    val hours = seconds / 3600
    val remainingSecondsAfterHours = seconds % 3600
    val minutes = remainingSecondsAfterHours / 60
    val remainingSeconds = remainingSecondsAfterHours % 60
    return Triple(hours, minutes, remainingSeconds)
}

fun calculateDistance(xy1: Pair<Double, Double>, xy2: Pair<Double, Double>): Double {
    val dx = xy2.first - xy1.first
    val dy = xy2.second - xy1.second
    return sqrt(dx * dx + dy * dy)
}

fun calculateNodAndNok(a: Int, b: Int): Pair<Int, Int> {
    var x = a
    var y = b
    while (y != 0) {
        val temp = y
        y = x % y
        x = temp
    }
    val nod = x
    val nok = a * b / nod
    return Pair(nod, nok)
}