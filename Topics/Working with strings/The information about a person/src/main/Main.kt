fun main() {
    // put your code here
    val (firstName, lastName, age) = readln().split(" ").map{it}
    val firstNameLetter = firstName[0]
    print("$firstNameLetter. $lastName, $age years old")
}