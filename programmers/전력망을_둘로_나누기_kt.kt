import java.util.ArrayList

object 전력망을_둘로_나누기 {

    private lateinit var visited: BooleanArray
    private lateinit var adjList: Array<MutableList<Int>>
    private var N = 0
    private var answer = 0

    fun solution(n: Int, wires: Array<IntArray>): Int {
        N = n
        answer = n - 1

        adjList = Array(n + 1) { mutableListOf<Int>() }

        for (i in 1..n) {
            adjList[i] = ArrayList()
        }

        for (wire in wires) {
            adjList[wire[0]].add(wire[1])
            adjList[wire[1]].add(wire[0])
        }

        visited = BooleanArray(n + 1)

        dfs(1)
        return answer
    }

    private fun dfs(now: Int): Int {
        visited[now] = true
        var sum = 0

        for (next in adjList[now]) {
            if (!visited[next]) {
                val res = dfs(next)
                answer = kotlin.math.min(answer, kotlin.math.abs(N - res * 2)) // 양쪽 노드 개수의 차이를 구하기 위해 res를 두 번 뺌
                sum += res
            }
        }

        return sum + 1 // 현재 노드 추가
    }
}

fun main() {
    val n = 9
    val wires = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 6),
        intArrayOf(4, 7),
        intArrayOf(7, 8),
        intArrayOf(7, 9)
    )

    val result = 전력망을_둘로_나누기.solution(n, wires)
    println("최소 차이: $result")
}
