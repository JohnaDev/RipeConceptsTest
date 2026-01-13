class Pet {

    companion object {
        fun createReese(): Dog {
            return Dog("Reese", "Poodle Terrier", 7, "Male")
        }

        fun createNacho(): Dog {
            return createReese().copy(name = "Nacho", age = 6)
        }
    }

    fun generateDogs() {
        val dog1 = createReese()
        val dog2 = createNacho()
        val dog3 = Dog("Ghost", "Poodle Terrier", 9, "Female")
        val dog4 = dog1.copy(name = "Junpyo", age = 5)
        val dog5 = dog4.copy(gender = "Female", name = "Suzy")

        println(dog1.toString())
        println(dog2)
        println(dog3)
        println(dog4)
        println(dog5)

        println("Is ${dog1.name} male? ${dog1.isMale()}")
    }

    fun Dog.isMale(): Boolean {
        return this.gender == "Male"
    }
}


data class Dog(val name: String, val breed: String, val age: Int, val gender: String)