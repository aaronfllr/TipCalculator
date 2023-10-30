fun main() {
    // write your code here

        // write your code here
    var ch0 = readln().first()
    var ch1 = readln().first()
    var ch2 = readln().first()
    var ch3 = readln().first()

    fun isDigit(ch: Char) {
        val isDigit = ch in '\u0030'..'\u0039'
        println(isDigit)
    }
    isDigit(ch0)
    isDigit(ch1)
    isDigit(ch2)
    isDigit(ch3)
}