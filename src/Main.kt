
fun main() {
    println(longestRepeatingCharacter("a"))
    println(longestRepeatingCharacterOldCode("a"))
    println("----------------------------------------------------------")

    println(longestRepeatingCharacter("a b c d"))
    println(longestRepeatingCharacterOldCode("a b c d"))
    println("----------------------------------------------------------")

    println(longestRepeatingCharacter("Mississippi"))
    println(longestRepeatingCharacterOldCode("Mississippi"))
    println("----------------------------------------------------------")

    println(longestRepeatingCharacter("If it ain’t broke, don’t fix it"))
    println(longestRepeatingCharacterOldCode("If it ain’t broke, don’t fix it"))
    println("----------------------------------------------------------")

    println(longestRepeatingCharacter("111 222 33333 @@@@@@@"))
    println(longestRepeatingCharacterOldCode("111 222 33333 @@@@@@@"))
    println("----------------------------------------------------------")

    println(longestRepeatingCharacter("Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi"))
    println(longestRepeatingCharacterOldCode("Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi"))



}

fun longestRepeatingCharacterOldCode(text: String): String {

    var result = ""

    val timeElapsed = kotlin.system.measureNanoTime {
        if (text.isEmpty()) {
            result = "no repeating characters"
            return@measureNanoTime
        }

        val chars = text.toCharArray()
        val tempChars = ArrayList<String>()
        var longestCount = 0
        var longestChar = ""

        for (i in chars.indices) {
            if (!tempChars.contains(chars[i].toString())) {
                tempChars.add(chars[i].toString().lowercase())
            }
        }

        for (i in tempChars.indices) {
            var count = 0
            for (j in chars.indices) {
                if (tempChars[i] == chars[j].toString().lowercase()) {
                    count++
                }
            }
            if (longestCount < count){
                longestCount = count
                longestChar = tempChars[i]
            }
        }

        result = if (longestCount< 2) {"no repeating characters in \"$text\""} else {"Longest repeating character in \"$text\", is \"$longestChar\", called $longestCount times"}
    }

    return "$result [${timeElapsed / 1000000.0} ms] old code."
}

fun longestRepeatingCharacter(text: String): String {
    var result = ""

    // Measures how long the enclosed block takes to execute (in nanoseconds)
    val timeElapsed = kotlin.system.measureNanoTime {

        // Early exit for empty input
        if (text.isEmpty()) {
            result = "no repeating characters"
            return@measureNanoTime // exits only the timing block, not the function
        }

        // LinkedHashMap preserves insertion order
        // This helps ensure we return the character that appears first
        // in case of a tie in frequency
        val counts = LinkedHashMap<Char, Int>()

        // Iterate through each character in the string
        for (c in text) {
            // Skip characters that are white spaces. Commented condition that skips non letter characters
            if (c == ' ' /*|| !c.isLetter()*/) continue

            // Convert to lowercase to make counting case-insensitive
            val ch = c.lowercaseChar()

            // Increment the count for this character
            counts[ch] = counts.getOrDefault(ch, 0) + 1
        }

        // Find the character with the highest occurrence count
        val maxEntry = counts.maxByOrNull { it.value }

        result = if (maxEntry == null || maxEntry.value < 2) {
            "no repeating characters in \"$text\""
        } else {
            "Longest repeating character in \"$text\", is \"${maxEntry.key}\", called ${maxEntry.value} times"
        }
    }

    return "$result [${timeElapsed / 1000000.0} ms]"
}