class City(val name: String) {
    var degrees: Int = 0
        get() {
            if (field < -92 || field > 57) {
                when (name) {
                    "Dubai" -> degrees = 30
                    "Moscow" -> degrees = 5
                    "Hanoi" -> degrees = 20
                    else -> return field
                }
            }
            return field
        }

}
fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third
    val neitherCity = "neither"

    // Implement comparing here
    val cities = arrayOf(firstCity, secondCity, thirdCity)
    var coldestCity: City? = null

    // Iterate through the array to find the coldest city
    for (city in cities) if (coldestCity == null || city.degrees < coldestCity.degrees) {
        coldestCity = city
    }

    if (coldestCity != null && firstCity.degrees != secondCity.degrees) {
        println(coldestCity.name)
    } else {
        println("neither")
    }
}
