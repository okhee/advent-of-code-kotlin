package aoc2022.solution.day02

import util.Correct
import util.readInput

private class Day02Q2 {
    data class Round (
        val opponentChoice: Choice,
        val desiredResult: Result
    ) {
        constructor(round: String): this(opponentChoice = round[0].toString().toChoice(),
            desiredResult = round[2].toString().toResult())

        val myChoice: Choice
            get() = desiredResult.toMyChoice(opponentChoice)

        val result: Int
            get() = myChoice.point + myChoice.versus(opponentChoice).point
    }

    @Correct
    fun main(): Any {
        val inputList = readInput("2022_02")

        return inputList.map(Day02Q2::Round)
            .map(Round::result)
            .sum()
    }
}

fun main() {
    println("A2: ${Day02Q2().main()}")
}
