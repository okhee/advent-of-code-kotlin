package aoc2021.solution

import util.readInput

class Day03 {
    private fun part1(input: List<String>): Int {
        val frequentBitMap = List(input[0].length) { idx ->
            input.map { it[idx] }
                .groupBy { it }
                .mapValues { it.value.size }
        }

        val gammaString = frequentBitMap.map { it ->
            it.maxByOrNull { it.value }!!
        }.map {
            it.key
        }.joinToString(separator = "")

        val epsilonString = gammaString.map {
            when(it) {
                '1' -> '0'
                else -> '1'
            }
        }.joinToString(separator = "")

        return gammaString.toInt(2) * epsilonString.toInt(2)
    }

    private fun part2(input: List<String>): Int {
        return CommonType.values().map { commonType ->
            var temp = input;
            (0 until input[0].length).map { idx ->
                val commonBit = commonBit(temp.map { it[idx] }, commonType)
                if (temp.size > 1) {
                    temp = temp.filter { it[idx] == commonBit }
                }
            }
            temp[0].toInt(2)
        }.fold(1) { acc, i -> acc * i }
    }

    private enum class CommonType {
        MOST, LEAST
    }

    private fun commonBit(bits: List<Char>, commonType: CommonType): Char {
        val frequentBitMap = mutableMapOf('0' to 0, '1' to 0)

        bits.forEach {
            frequentBitMap[it] = frequentBitMap.getOrPut(it) { 0 } + 1
        }

        return when(commonType) {
            CommonType.MOST -> if (frequentBitMap['1']!! >= frequentBitMap['0']!!) '1' else '0'
            CommonType.LEAST -> if (frequentBitMap['0']!! <= frequentBitMap['1']!!) '0' else '1'
        }
    }

    fun main() {
        val input = readInput("2021_03")
        println("Part 1 : ${part1(input)}")
        println("Part 2 : ${part2(input)}")
    }
}

fun main() {
    Day03().run {
        main()
    }
}
