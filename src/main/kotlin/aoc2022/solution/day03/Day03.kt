package aoc2022.solution.day03

import util.Correct
import util.readInput

private class Day03 {
    @Correct
    fun q1(): Any {
        val inputList = readInput("2022_03")

        return inputList.sumOf {
            val s1 = it.toCharArray(0, it.length / 2).toSet()
            val s2 = it.toCharArray(it.length / 2, it.length).toSet()

            s1.intersect(s2).first().toPriority()
        }
    }

    @Correct
    fun q2(): Any {
        val inputList = readInput("2022_03")

        return inputList
            .map { it.toSet() }
            .chunked(3)
            .sumOf {
                it[0].intersect(it[1].intersect(it[2])).first().toPriority()
            }
    }
}

fun Char.toPriority() = when(this) {
    in 'a'..'z' -> this - 'a' + 1
    in 'A'..'Z' -> this - 'A' + 27
    else -> 0
}

fun main() {
    println("A1: ${Day03().q1()}")
    println("A2: ${Day03().q2()}")
}
