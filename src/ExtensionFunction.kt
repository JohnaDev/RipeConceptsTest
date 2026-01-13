class ExtensionFunction {
    fun isEmail(email: String) {
        println(email.isEmail())
    }
}

fun String.isEmail(): Boolean {
    return this.contains("@") && this.contains(".")
}