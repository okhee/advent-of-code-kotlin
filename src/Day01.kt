class Day01 {
    private fun part1(input: List<String>): Int {
        return countDepthIncrease(input.map {it.toInt()}.toList())
    }

    private fun part2(input: List<String>): Int {
        return input
            .asSequence()
            .map { it.toInt() }
            .withIndex()
            .groupBy({it.index % 3}, {it.value})
            .map { (_, subList) ->
                countDepthIncrease(subList)
            }
            .sum()
    }

    private fun countDepthIncrease(input: List<Int>): Int {
        var lastDepth = Int.MAX_VALUE
        var numDepthIncrease = 0
        input
            .forEach {
                if (it > lastDepth) numDepthIncrease++
                lastDepth = it
            }

        return numDepthIncrease
    }

    fun main() {
        val input = readInput("Day01")
        println("Part 1 : ${part1(input)}")
        println("Part 2 : ${part2(input)}")
    }
}

fun main() {
    Day01().main()
}
