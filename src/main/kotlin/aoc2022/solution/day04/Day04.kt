package aoc2022.solution.day04

import util.Correct
import util.readInput

private class Day04 {

    @Correct
    fun q1(): Any {
        val inputList = readInput("2022_04")

        return inputList.count {
            val split = it.split(",")
            split[0].toIntRange().includeAnother(split[1].toIntRange())
        }
    }

    @Correct
    fun q2(): Any {
        val inputList = readInput("2022_04")

        return inputList.count {
            val split = it.split(",")
            split[0].toIntRange().overlap(split[1].toIntRange())
        }
    }
}

fun String.toIntRange(): IntRange {
    val split = this.split("-")
    return split[0].toInt()..split[1].toInt()
}

fun IntRange.include(other: IntRange) =
    this.first <= other.first && other.last <= this.last

fun IntRange.includeAnother(other: IntRange) =
    this.include(other) || other.include(this)

fun IntRange.overlap(other: IntRange) =
    !(this.last < other.first || other.last < this.first)

fun main() {
    println("A1: ${Day04().q1()}")
    println("A2: ${Day04().q2()}")
}
