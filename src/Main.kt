//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println(longestRepeatingCharacter("a"))
    println(longestRepeatingCharacter("a b c d"))
    println(longestRepeatingCharacter("Mississippi"))
    println(longestRepeatingCharacter("If it ain’t broke, don’t fix it"))
    println(longestRepeatingCharacter("111 222 33333 @@@@@@@"))


    println(longestRepeatingCharacter("Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi Mississippi"))

    println("----------------------------------------------------------")

    println(longestRepeatingCharacterOldCode("a"))
    println(longestRepeatingCharacterOldCode("a b c d"))
    println(longestRepeatingCharacterOldCode("Mississippi"))
    println(longestRepeatingCharacterOldCode("If it ain’t broke, don’t fix it"))
    println(longestRepeatingCharacterOldCode("111 222 33333 @@@@@@@"))

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

        result = if (longestCount< 2) {"no repeating characters"} else {"Longest repeating letter is $longestChar"}
    }

    return "$result [${timeElapsed / 1_000_000.0} ms] old code."
}

fun longestRepeatingCharacter(text: String): String {
    var result = ""

    val timeElapsed = kotlin.system.measureNanoTime {
        if (text.isEmpty()) {
            result = "no repeating characters"
            return@measureNanoTime
        }

        val counts = LinkedHashMap<Char, Int>()

        for (c in text) {
            if (!c.isLetterOrDigit()) continue
            val ch = c.lowercaseChar()
            counts[ch] = counts.getOrDefault(ch, 0) + 1
        }

        val maxEntry = counts.maxByOrNull { it.value }

        result = if (maxEntry == null || maxEntry.value < 2) {
            "no repeating characters"
        } else {
            "Longest repeating letter is ${maxEntry.key}"
        }
    }

    return "$result [${timeElapsed / 1_000_000.0} ms]"
}