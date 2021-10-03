# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록
NB는 'Number Baseball'(숫자 야구)의 약어로 사용한다.
- 서로 다른 digit 검증(Validator)
- n개의 서로 다른 digit 생성(Generator)
- 문자열을 파싱해 n개의 서로 다른 digit 생성(Parser)
- 특정 digit에 대해 어떤 매칭(strike, ball, nothing)이 있는지(Digits)
- 입력받은 digits 매칭별로 각각 몇개인지(MatchCounter)
- 입출력(View)
- Digits 생성 후 입력받은 모든 digit가 strike 될 때까지 턴을 반복, 되면 플레이 종료(Gameplay)
- 플레이 시작/종료 후 플레이어가 재시작하면 플레이 시작, 안하면 게임 종료(NumberBaseballGame)
