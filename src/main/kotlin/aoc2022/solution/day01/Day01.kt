package aoc2022.solution.day01

import util.Correct
import util.readInput
import java.util.PriorityQueue
import kotlin.math.max

class Day01 {
    @Correct
    fun q1(): Int {
        val inputList = readInput("2022_01")
        var answer = 0

        val last = inputList.fold(0, { acc, r ->
            if (r == "") {
                answer = max(answer, acc)
                0
            } else {
                acc + r.toInt()
            }
        })

        answer = max(answer, last)

        return answer
    }

    @Correct
    fun q2(): Int {
        val inputList = readInput("2022_01")

        val queue = PriorityQueue<Int>(reverseOrder())

        inputList.fold(0, { acc, r ->
            if (r == "") {
                queue.add(acc)
                0
            } else {
                acc + r.toInt()
            }
        })

        return queue.take(3).sum()
    }

    fun main() {
        println("A1: ${q1()}")
        println("A2: ${q2()}")
    }
}

fun main() = Day01().main()
