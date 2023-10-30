class ListUtils {
    companion object Info {

        // define info method here
        fun <T> info(list: List<T>): String {
            if (list.isEmpty()) {
                return "[]"
            }
            return list.joinToString(prefix = "[", postfix = "]")
        }
    }
}