# TDD by example

## 체크 리스트
* $5 + 10CHF = $10
* ~~$5 * 2 = $10~~ 
* ~~amount 를 private 으로 만들기~~
* ~~Dollar 부작용~~
* Money 반올림
* ~~equals()~~
* hashCode()
* equals null
* equals object (Dollar 가 아닌 객체)
* ~~5CHF * 2 = 10CHF~~
  * $5 + 10CHF = $10 | 큰 테스트 처리를 위한 작은 테스트
  * 테스트 성공 확인 까지만 진행. 추가 리팩토링 진행.
* Dollar/ Franc 중복
* ~~공용 equals~~
* 공용 times
* Franc 과 Dollar 비교하기 