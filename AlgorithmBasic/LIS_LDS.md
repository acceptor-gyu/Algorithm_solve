# 최장 증가, 감소 부분 수열 (LIS, LDS)

- 어떤 임의의 수열이 주어질 때, 이 수열에서 몇 개의 수들을 제거해서 부분수열을 만들 수 있다. 이때 만들어진 부분수열 중 오름차순 또는 내림차순으로 정렬된 가장 긴 수열을 각각 최장 증가 부분 수열(LIS), 최장 감소 부분 수열(LDS)이라 한다.
- LIS, LDS 문제는 동적 계획법(Dynamic Programming)을 이용해서 풀 수 있다.
- LDS는 LIS를 구하는 과정에서 LIS의 길이를 구하는 것과 같으며 LDS는 LIS를 역으로 탐색하면 된다.

## 개념
- {1, 4, 3, 2, 1, 4, 3, 4, 5, 2}의 LIS를 구하는 과정을 살펴보자.
- 왼쪽에서 오른쪽으로 진행하는 오름차순의 경우 각 원소별 수열의 길이를 보면 다음과 같다.

```java
int[] arr = {1, 4, 3, 2, 1, 4, 3, 4, 5, 2};
int[] dp = new int[arr.length];
```
- dp[0] = {1}   // 길이: 1
- dp[1] = {1, 4}   // 길이: 2
- dp[2] = {1, 3}   // 길이: 2
- dp[3] = {1, 2}   // 길이: 2
- dp[4] = {1}   // 길이: 1
- dp[5] = {1, 4}   // 길이: 2
- dp[6] = {1, 3}   // 길이: 2
- dp[7] = {1, 3, 4}   // 길이: 3
- dp[8] = {1, 3, 4, 5}   // 길이: 4
- dp[9] = {1, 2}   // 길이: 2
- > dp[i]는 arr[i]를 마지막 원소로 가지는 LIS의 길이를 의미한다.
  
> LDS는 오른쪽에서 왼쪽으로 진행하면 된다.

- LIS와 LDS를 진행하면 결과는 아래와 같을 것이다.
```java
int[] lis = {1, 2, 2, 2, 1, 2, 2, 3, 4, 2};
int[] lds = {2, 4, 3, 2, 2, 1, 2, 2, 2, 1};
```

## 구현
```java

/**
 * LIS
 */

for (int i = 0; i < arr.length; i++) {
    dp[i] = 1;
    for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
        }
    }
}

/**
 * LDS (LIS의 역방향)
 */
for (int i = arr.length -1; i >= 0; i--) {
    dp[i] = 1;
    
    for (int j = arr.length - 1; j > i; j--) {
        if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
            dp[i] = dp[j] + 1;
        }
    }
}
```

# LCS (최장 공통 부분 수열)
- 주어진 여러 개의 수열 모두의 부분수열이 되는 수열들 중에 가장 긴 것을 찾는 문제이다. (종종 단 두 개 중 하나가 되기도 한다.)
- LCS 문제는 최적의 부분구조를 가진다. 이 문제는 더 작은, `부분문제`로 쪼개질 수 있고, 이것은 반복해서 자명한 부분문제가 될 때까지 더 간단한 부분문제로 쪼개질 수 있다. (여기까지 봤을 때 동적계획법(dynamic programmin)이 떠오른다면 아주 좋을 것이다.) 
- LCS는 또한 겹치는 부분문제를 가진다. 더 높은 부분문제에 대한 풀이는 몇몇의 하위 부분문제의 풀이에 의존한다. "최적의 부분구조"와 "겹치는 부분문제"는 동적 프로그래밍이라는 가장 간단한 부분문제에서 출발하는 문제 풀이 기법으로 접근될 수 있다.

- 임의의 두 수열 X와 Y에서, LCS문제의 해법, 즉 최장 공통 부분 수열, LCS(X, Y)는 다음의 두 속성에 의존한다
  - 두 수열이 같은 원소로 끝난다고 가정해보자. 그들의 LCS를 찾기 위해 마지막 원소를 지움으로써 수열의 길이를 줄이고, 짧아진 수열에 대한 LCS를 찾은 후 삭제한 원소를 붙여준다.
  - 두 수열 X, Y가 같은 기호로 끝나지 않는다고 가정한다. 그러면 X와 Y의 LCS는 LCS(Xn,Ym-1)와 LCS(Xn-1,Ym)중 더 긴 수열이다.
    > 이 특징을 이해하기 위해 다음 두 수열을 보도록 한다. 수열 X: ABCDEFG (n개의 원소) 수열 Y: BCDGK (m개의 원소) 이 두 수열의 LCS의 마지막 문자는 수열 X의 마지막 원소인 G로 끝나거나, 그렇지 않을것이다.
    > - 첫 번째 경우: LCS가 G로 끝나는 경우 
    >   - 이 경우 LCS는 K로 끝날 수 없다. 따라서 수열 Y에서 K를 제거하여도 손실이 일어나지 않는다. 만약 K가 LCS에 있었다면 마지막 문자였을것이기 때문이다. 따라서 이렇게 표기할 수 있다. LCS(Xn,Ym) = LCS(Xn, Ym-1).
    > - 두 번째 경우: LCS가 G로 끝나지 않는 경우
    >   - 이 경우 위와 같은 이유로 수열 X에서 G를 제거하여도 손실이 일어나지 않는다. 즉 이렇게 쓸 수 있다. LCS(Xn,Ym) = LCS(Xn-1, Ym). 어떤 경우에서든지 우리가 찾는 LCS는 LCS(Xn, Ym-1)이거나 LCS(Xn-1, Ym)이다. 이 두 LCS는 둘다 X와 Y의 공통 부분수열이다. LCS(X,Y)는 최장이다. 따라서 그 값은 LCS(Xn, Ym-1)와 LCS(Xn-1, Ym)중의 최장 수열이다.

## LCS 구현

```java
public class LCS {
  public static int[][] lcs(char[] X, char[] Y) {
      
    int m = X.length;
    int n = Y.length;
    int start = 0;
    int mEnd = m - 1;
    int nEnd = n - 1;

    // 공통으로 겹치는 접두사 제거
    while (start <= mEnd && start <= nEnd && X[start] == Y[start]) {
      start++;
    }

    // 공통으로 겹치는 접미사 제거
    while (start <= mEnd && start <= nEnd && X[mEnd] == Y[nEnd]) {
      mEnd--;
      nEnd--;
    }

    int[][] C = new int[mEnd - start + 1][nEnd - start + 1];

    // Loop over the items that have changed
    for (int i = start; i <= mEnd; i++) {
      for (int j = start; j <= nEnd; j++) {
        if (X[i] == Y[j]) {
          C[i - start][j - start] = 1 + getSafeValue(C, i - 1 - start, j - 1 - start);
        } else {
          C[i - start][j - start] = Math.max(getSafeValue(C, i - 1 - start, j - start),
                  getSafeValue(C, i - start, j - 1 - start));
        }
      }
    }

    return C;
  }

  private static int getSafeValue(int[][] C, int i, int j) {
    if (i < 0 || j < 0) {
      return 0;
    }
    return C[i][j];
  }

  public static void main(String[] args) {
    String X = "AGGTAB";
    String Y = "GXTXAYB";

    int[][] result = lcs(X.toCharArray(), Y.toCharArray());

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }
}

```

[참조](https://ko.wikipedia.org/wiki/%EC%B5%9C%EC%9E%A5_%EA%B3%B5%ED%86%B5_%EB%B6%80%EB%B6%84_%EC%88%98%EC%97%B4)
