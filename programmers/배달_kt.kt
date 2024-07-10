import java.util.PriorityQueue

class 배달_kt {

    private data class Node(val dest: Int, val cost: Int)

    fun solution(N: Int, road: Array<IntArray>, K: Int): Int {
        val adjList = Array(N + 1) { mutableListOf<Node>() }
        for (edge in road) {
            adjList[edge[0]].add(Node(edge[1], edge[2]))
            adjList[edge[1]].add(Node(edge[0], edge[2]))
        }

        val dist = IntArray(N + 1) { Int.MAX_VALUE }
        val pq = PriorityQueue<Node>(compareBy { it.cost })

        pq.add(Node(1, 0))
        dist[1] = 0

        while (pq.isNotEmpty()) {
            val now = pq.poll()

            if (dist[now.dest] < now.cost) {
                continue
            }

            for (next in adjList[now.dest]) {
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost
                    pq.add(Node(next.dest, dist[next.dest]))
                }
            }
        }

        return dist.count { it <= K }
    }
}

fun main() {
    val sol = 배달_kt()

    println(sol.solution(5, arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 3), intArrayOf(5, 2, 2), intArrayOf(1, 4, 2), intArrayOf(5, 3, 1), intArrayOf(5, 4, 2)), 3)) // 4
}