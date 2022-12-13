package aoc2022.solution.day02

import java.lang.IllegalArgumentException

enum class Choice(val point: Int) {
    ROCK(1), PAPER(2), SCISSORS(3)
}

fun Choice.versus(opponentChoice: Choice) = when(this) {
    Choice.ROCK -> when (opponentChoice) {
        Choice.ROCK -> Result.DRAW
        Choice.PAPER -> Result.LOSE
        Choice.SCISSORS -> Result.WIN
    }
    Choice.PAPER -> when (opponentChoice) {
        Choice.ROCK -> Result.WIN
        Choice.PAPER -> Result.DRAW
        Choice.SCISSORS -> Result.LOSE
    }
    Choice.SCISSORS -> when (opponentChoice) {
        Choice.ROCK -> Result.LOSE
        Choice.PAPER -> Result.WIN
        Choice.SCISSORS -> Result.DRAW
    }
}

fun String.toChoice() = when(this) {
    "A" -> Choice.ROCK
    "B" -> Choice.PAPER
    "C" -> Choice.SCISSORS
    "X" -> Choice.ROCK
    "Y" -> Choice.PAPER
    "Z" -> Choice.SCISSORS
    else -> throw IllegalArgumentException()
}

fun Result.toMyChoice(opponentChoice: Choice) = when(this) {
    Result.WIN -> when(opponentChoice) {
        Choice.ROCK -> Choice.PAPER
        Choice.PAPER -> Choice.SCISSORS
        Choice.SCISSORS -> Choice.ROCK
    }
    Result.DRAW -> opponentChoice
    Result.LOSE -> when(opponentChoice) {
        Choice.ROCK -> Choice.SCISSORS
        Choice.PAPER -> Choice.ROCK
        Choice.SCISSORS -> Choice.PAPER
    }
}
