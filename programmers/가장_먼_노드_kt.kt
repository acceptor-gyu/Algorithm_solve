import java.util.*

class 가장_먼_노드_kt {

    private val queue = ArrayDeque<Int>()
    private lateinit var arr: IntArray
    private lateinit var adjList: Array<MutableList<Int>>
    private lateinit var visited: BooleanArray

    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        arr = IntArray(n + 1)
        visited = BooleanArray(n + 1)
        adjList = Array(n + 1) { mutableListOf<Int>() }

        for (i in 1..n) {
            adjList[i] = ArrayList()
        }

        for (e in edge) {
            adjList[e[0]].add(e[1])
            adjList[e[1]].add(e[0])
        }

        queue.addLast(1)

        visited[1] = true
        while (queue.isNotEmpty()) {
            for (i in 0 until queue.size) {
                val now = queue.pollFirst()

                for (next in adjList[now]) {
                    if (!visited[next]) {
                        visited[next] = true
                        queue.addLast(next)
                        arr[next] = arr[now] + 1
                    }
                }
            }
        }

        arr.sort()
        val max = arr.last()

        for (i in arr.indices.reversed()) {

            if (arr[i] == max) {
                answer++
                continue
            }

            break
        }

        return answer
    }
}