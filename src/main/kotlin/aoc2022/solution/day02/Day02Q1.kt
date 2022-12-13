package aoc2022.solution.day02

import util.Correct
import util.readInput

private class Day02Q1 {
    data class Round (
        val myChoice: Choice,
        val opponentChoice: Choice
    ) {
        constructor(my: String, opponent: String): this(my.toChoice(), opponent.toChoice())

        constructor(round: String): this(opponent = round[0].toString(), my = round[2].toString())

        val result: Int
            get() = myChoice.point + myChoice.versus(opponentChoice).point
    }

    @Correct
    fun main(): Any {
        val inputList = readInput("2022_02")

        return inputList.map(Day02Q1::Round)
            .map(Round::result)
            .sum()
    }
}

fun main() {
    println("A1: ${Day02Q1().main()}")
}
