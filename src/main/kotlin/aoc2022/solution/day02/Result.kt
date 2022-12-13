package aoc2022.solution.day02

import java.lang.IllegalArgumentException

enum class Result(val point: Int) {
    WIN(6), DRAW(3), LOSE(0)
}

fun String.toResult() = when(this) {
    "X" -> Result.LOSE
    "Y" -> Result.DRAW
    "Z" -> Result.WIN
    else -> throw IllegalArgumentException()
}
