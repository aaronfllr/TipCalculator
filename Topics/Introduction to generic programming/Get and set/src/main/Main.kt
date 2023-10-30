data class QuizBox<T>(val hiddenItem: T) {
    var isChanged = false
    var item: T = hiddenItem
        // implement methods
        get() {
            println("You asked for the item")
            return field
        }
        set(value) {
            println("You changed the item")
            field = value
            isChanged = true
        }
}