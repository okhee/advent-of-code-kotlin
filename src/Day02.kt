class Day02 {
    private class Command (val direction: String, val amount: Int)

    private fun part1(input: List<String>): Int {
        val commandList = input
            .map { it.split(" ") }
            .map { Command(it[0], it[1].toInt()) }
            .groupBy({ it.direction }, { it.amount })

        return commandList["forward"]!!.sum() * (commandList["down"]!!.sum() - commandList["up"]!!.sum())
    }

    private fun part2(input: List<String>): Int {
        var hor = 0
        var aim = 0
        var depth = 0
        input
            .map { it.split(" ") }
            .map { Command(it[0], it[1].toInt()) }
            .forEach {
                when(it.direction) {
                    "forward" -> {
                        hor += it.amount
                        depth += it.amount * aim
                    }
                    "down" -> aim += it.amount
                    "up" -> aim -= it.amount
                    else -> throw Exception()
                }
            }

        return hor * depth
    }

    fun main() {
        val input = readInput("Day02")
        println("Part 1 : ${part1(input)}")
        println("Part 2 : ${part2(input)}")
    }
}

fun main() {
    Day02().main()
}
