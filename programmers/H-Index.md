# 프로그래머스 H-index

```
이 문제는 정렬을 이용하는 문제입니다.
```

### 전체 코드
```java
  import java.util.*;
  class Solution {
      public int solution(int[] citations) {
          int answer = 0;

          Arrays.sort(citations);
          for(int i = 0 ; i < citations.length;i++){
              int cnt = citations.length-i;

              if(citations[i]>=cnt){
                  answer=cnt;
                  break;
              }
          }
          return answer;
      }
  }
```
