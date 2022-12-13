package aoc2022.solution.day05

import util.Correct
import util.readInput

private class Day05 {

    companion object {
        val commandRegex: Regex = Regex("""move (\d+) from (\d+) to (\d+)""")
    }

    @Correct
    fun q1(): Any {
        val inputList = readInput("2022_05")

        val stackCount = (inputList[0].length + 1) / 4

        val stackMap = (1..stackCount).associateWith { ArrayDeque<Char>() }

        inputList.takeWhile { it != "" }
            .dropLast(1)
            .forEach { row ->
                (1..stackCount).map { (it - 1) * 4 + 1 }
                    .map { row[it] }
                    .forEachIndexed { idx, char ->
                        if (char in 'A'..'Z') {
                            stackMap[idx + 1]?.addLast(char)
                        }
                    }
            }

        inputList.dropWhile { it != "" }
            .drop(1)
            .mapNotNull { commandRegex.find(it)?.destructured }
            .forEach { (moveCount, fromIndex, toIndex) ->
                repeat(moveCount.toInt()) {
                    stackMap[fromIndex.toInt()]?.removeFirstOrNull()?.let {
                        stackMap[toIndex.toInt()]?.addFirst(it)
                    }
                }
            }

        return stackMap.values
            .mapNotNull { it.firstOrNull() }
            .joinToString(separator = "")
    }

    @Correct
    fun q2(): Any {
        val inputList = readInput("2022_05")

        val stackCount = (inputList[0].length + 1) / 4

        val stackMap = (1..stackCount).associateWith { ArrayDeque<Char>() }

        inputList.takeWhile { it != "" }
            .dropLast(1)
            .forEach { row ->
                (1..stackCount).map { (it - 1) * 4 + 1 }
                    .map { row[it] }
                    .forEachIndexed { idx, char ->
                        if (char in 'A'..'Z') {
                            stackMap[idx + 1]?.addLast(char)
                        }
                    }
            }

        inputList.dropWhile { it != "" }
            .drop(1)
            .mapNotNull { commandRegex.find(it)?.destructured }
            .forEach { (moveCount, fromIndex, toIndex) ->
                val queue = ArrayDeque<Char>()

                repeat(moveCount.toInt()) {
                    stackMap[fromIndex.toInt()]?.removeFirstOrNull()?.let {
                        queue.addFirst(it)
                    }
                }

                queue.forEach {
                    stackMap[toIndex.toInt()]?.addFirst(it)
                }
            }

        return stackMap.values
            .mapNotNull { it.firstOrNull() }
            .joinToString(separator = "")
    }
}

fun main() {
    println("A1: ${Day05().q1()}")
    println("A2: ${Day05().q2()}")
}
