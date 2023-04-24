# DP(Dynamic Programming, 동적 계획법)
## DP란?
- `N - a` 번째 답(값)을 이용해 N번째 답을 구하는 알고리즘
- `Memoization`: 한 번 구한 값을 배열 등에 저장(메모)해두고, 다음에 같은 값이 필요하면 메모해 둔 값을 사용하는 것으로 시간적 효율성을 증가시킨다.
  - 매우 중요!!
  - 메모이제이션이 없는 DP는 없다고 봐도 될 것이다.
- 일반적으로 N번째 답(값)을 구하기 위해 기존에 구해둔 `N - a`번째 답(값)을 사용하므로, 초기값은 직접 구해서 세팅하는 경우가 많다.
- 주로 for 문과 DP값을 저장하는 배열로 구현하며 재귀함수로 구현하기도 한다.

> 답을 이용해서 또 답을 구하는 것!  
> 즉, 중간 과정도 모두 답이어야 한다!

## DP 접근 방법
- `N - 1`번째 혹은 `N - 2`번째 답(값)을 이용해 N번째 답(값)을 구할 수 있을까 고민해본다.
- 경우의 수 구하는 문제가 DP 문제인 경우가 상당히 많다.
- 일종의 점화식을 이용해서, 초기값 1번째 혹은 2번째 값까지는 직접 세팅하고, 이후 i번째 값들은 `i - 1` 혹은 `i - 2`번째 값을 이용해 구한다.
- 따라서, 초기값 세팅과 점화식을 작성하는 것이 핵심이 될 것이다.

> 다시 말하지만, DP의 핵심은 동일한 계산을 다시 하지 않는 것이다.

## DP 간단한 예제
```java
public class Fibonacci {
  // 1, 1, 2, 3, 5, 8, 13, 21, ...
  private static long cnt = 0;
  private static long fibo(int n) {

    cnt++;

    if (n <= 2) {
      return 1;
    }

    return fibo(n - 1) + fibo(n - 2);
  }

  public static void main(String[] args) {
    System.out.println("fibo(50): " + fibo(50));
    System.out.println("cnt: " + cnt);
  }
}
```
- 실행 결과
  > <img width="190" alt="image" src="https://user-images.githubusercontent.com/71162390/233881522-9a7bd2fb-1b26-4b1e-a7a0-7c99acfb2e99.png">

- 위 코드의 문제점은 무엇일까요?
  - 위와 같이 재귀 함수로 피보나치 수열을 구하게 되면, 동일한 연산이 반복됨을 알 수 있습니다.
  - 다시 말씀드리지만, DP의 핵심은 `동일한 계산을 다시 하지 않는 것`에 있습니다.

위 코드에 메모이제이션을 적용해보겠습니다.
```java
import java.util.Arrays;

public class Fibonacci_dp {
  // 1, 1, 2, 3, 5, 8, 13, 21, ...

  private static long cnt = 0;
  private static long[] dp = new long[51];
  private static long fibo(int n) {

    cnt++;

    if (dp[n] > 0) {
      return dp[n];
    }

    if (n <= 2) {
      return dp[n] = 1;
    }

    return dp[n] = fibo(n - 1) + fibo(n - 2);
  }

  public static void main(String[] args) {
    System.out.println("fibo(50): " + fibo(50));
    System.out.println("answers: " + Arrays.toString(dp));
    System.out.println("cnt: " + cnt);
  }
}
```
- 실행 결과
  > <img width="1123" alt="image" src="https://user-images.githubusercontent.com/71162390/233882180-7c6727f3-2566-4c21-b8fc-ed55b9cc030b.png">
- 메모를 하기 위해 메모리는 조금 더 사용했지만 수행 속도 면에서 매우 향상시킨 것을 볼 수 있습니다.
- 이것이 메모이제이션의 힘이고 이것이 DP인 것같습니다.
- 여기서 또 중요한 것은 중간 과정에 있는 값들도 모두 답이라는 것입니다.

이 코드를 for 문을 이용한 코드로 바꿔보겠습니다.
```java
import java.util.Arrays;

public class Fibonacci_DP_for {
  // 1, 1, 2, 3, 5, 8, 13, 21, ...

  private static long[] dp = new long[51];

  public static void main(String[] args) {

    dp[1] = 1;
    dp[2] = 1;

    for (int i = 3; i <= 50; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    System.out.println(dp[50]);
    System.out.println("answers: " + Arrays.toString(dp));
  }
}

```
- 실행 결과
  > <img width="949" alt="image" src="https://user-images.githubusercontent.com/71162390/233882869-93514303-8d9f-4e88-b4ba-7adbae65134f.png">
- `ArrayIndexOutOfBoundsException` Exception이 발생하지 않는 범위까지 수동으로 값을 dp 배열에 넣어놓고 그 때부터 for 문을 돌립니다.


## 대표적인 DP 문제
- 거스름 돈 문제
- 배낭 문제
- 타일링
- 플로이드-워셜 (최단거리)
  - 플로이드-워셜은 나중에 다루겠습니다.

### 예시 문제 링크
- [가장 큰 정사각형 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/12905)
- [2 x n 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/12900)
- [평범한 배낭](https://www.acmicpc.net/problem/12865)
- [거스름돈](https://school.programmers.co.kr/learn/courses/30/lessons/12907)

---
이 중에 가장 어렵다고 생각되는 한 문제만 풀어보겠습니다.
- well-known이자, knapsack 문제입니다.
### [평범한 배낭](https://www.acmicpc.net/problem/12865)

- 아래 풀이를 보기 전 충분히 생각해보고 읽으면 도움이 많이 되실 수 있을 것같습니다.

- 처음에는 `가치 / 무게`로 효율을 계산해 그리디처럼 접근할 수도 있을 것같습니다.
  - 하지만, 이에 대한 예외는 얼마든지 만들 수 있습니다(스스로 생각해보세요).

- 그럼 어떻게 하면 좋을까요?
- 이 문제에서 dp배열을 dp[N][K]가 되도록 만들겠습니다.
  - for 문으로 완전 탐색 중 N에 i, K에 j가 들어간다고 할 때
  - i번째 물건까지 포함했을 때 j 무게만큼 담았을 때 최대값. 즉, (i, j)일 때의 답들을 dp 배열에 담겠습니다.

- 위의 말을 표로 만들어 보겠습니다.
  > <img width="353" alt="image" src="https://user-images.githubusercontent.com/71162390/233887296-3b14636a-4a38-41a8-bc00-4106883ba156.png">

- 여기서 이해해야 할 것은 중간 과정들이 모두 답이라는 것이고,
- 답을 이용해 또 다른 답을 구하는 것입니다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_평범한배낭 {

  private static class Goods {
    int weight;
    int value;

    public Goods(int weight, int value) {
      this.weight = weight;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());   // 물건의 수
    int K = Integer.parseInt(st.nextToken());   // 가방의 무게

    Goods[] goods = new Goods[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());

      goods[i] = new Goods(weight, value);
    }

    int[][] dp = new int[N + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      Goods now = goods[i];
      for (int j = 1; j <= K; j++) {
        dp[i][j] = dp[i - 1][j];    // 직전까지 구해놓은 답이 여전히 답이 될 수 있기 때문에 일단 복사해온다.
        if (j >= now.weight) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - now.weight] + now.value);
        }
      }
    }

    System.out.println(dp[N][K]);
  }
}
```
