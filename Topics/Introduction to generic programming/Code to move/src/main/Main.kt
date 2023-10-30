// implement primary constructor and methods
class Box<T> (var furniture: T, var volume: Int){
    fun getBoxVolume(): Int {
        return volume
    }
    fun getFurnitureFromBox(): T {
        return furniture
    }
}

// Don't change classes below
class Fridge
class Armchair