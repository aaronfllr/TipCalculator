fun validatePassword(password: String): Boolean {
    // write your code here
    return if (password.length < 5) {
        println("Your password should be five or longer characters, please write a new password")
        false
    } else {
        println("Good password")
        true
    }
}

// do not change the code below
fun main() {
    var validationResult = false
    while (!validationResult) {
        val password = readln()
        validationResult = validatePassword(password)
    }
}