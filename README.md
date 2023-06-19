# TDD by example

## 체크 리스트
* ~~$5 + 10CHF = $10 (환율이 2:1 일 경우)~~
* ~~$5 + $5 = $10~~
* $5 + $5 에서 Money (Expression(Sum)) 반환하기 - P122
  * Why? `Money implements Expression`
  * 외부 구현의 테스트가 아닌 내부 구현의 테스트
* ~~Bank.reduce(Money)~~
* ~~Money 에 대한 통화 변환을 수행하는 Reduce~~
* ~~Reduce(Bank, String)~~
* Sum.plus
* Expression.times