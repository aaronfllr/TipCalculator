fun main() {
    val n = List(3){ readln().first()}
    if( n[0] < n[1] && n[1] < n[2] && n[0] + 1 == n[1] && n[1] + 1 == n[2]) {
        print("true")
    } else {
        print("false")
    }
}