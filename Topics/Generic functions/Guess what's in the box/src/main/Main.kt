class Box<T>(val item: T) {}

// define the function
fun <T> Box<T>.guessBox() = println("In this box you have: $item")