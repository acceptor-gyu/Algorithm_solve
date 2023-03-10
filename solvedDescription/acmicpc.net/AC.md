### [AC](https://www.acmicpc.net/problem/5430)


### 시간 복잡도
- O(N) * 테스트 케이스(최대 100)


### 어떻게 풀 것인가? / 코드 설명
- R가 들어오면 D가 들어왔을 때 deque의 앞에서 데이터를 꺼낼지, 뒤에서 꺼낼지 모드를 전환해준다.
- D가 들어오면 모드 상태에 따라 데이터를 deque에서 꺼낸다.
- deque가 비어있을 때 0이 들어오면 "error"를 반환한다.


### 이 문제를 통해 얻어갈 것
- 구현헤야 하는 동작을 문제에서 그대로 읽어주기 떄문에 난이도 자체가 높은 문제는 아니었다.

제출했을 때 발생한 에러
- 컴파일 에러(numberFormatException)
  - Deque<Integer>로 만들었을 때 numberFormatException이 발생했다.
  - 해당 에러는 String 타입의 데이터를 숫자 타입으로 바꾸려고 할 때 발생하는데 나는 적절하게 사용했다고 생각했는데 아직도 이유를 전혀 모르겠다.
- 틀렸습니다.
  - 줄바꿈 문자를 적절하게 사용하지 않아서 계속 틀린 것같다.
  - 반환을 명확하게 나눠서 해주니까 통과했다.