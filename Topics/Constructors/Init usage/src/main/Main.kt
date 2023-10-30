fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(var time: Int) {
    init {
        time = when {
            127 < time -> 127
            -127 > time -> -128
            else -> time
        }
    }
}