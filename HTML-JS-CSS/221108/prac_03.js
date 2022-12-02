/*
// return : 함수의 수행을 종료하고, 호출한 곳으로 돌아가는 역할
function f1() {
  for (var i = 1; i < 10; i++) {
    if (i % 3 == 0) {
      // 수행을 종료하고 호출한 곳으로 돌아가기 때문에
      // break와 유사한 효과를 만들 수 있다.
      return;
    }
    console.log(i);
  }
}

f1();

// return의 또 다른 역할
// 하나의데이터를 호출한 곳으로 가지고 갈 수 있다.
function f2(first, second) {
  return first + second;
}

// 함수를 호출하고 리턴된 결과를 저장
var result = f2(100, 200);
console.log(result);

// 리턴된 결과를 다른 함수의 매개변수로 사용
result = f2(f2(1000, 3000), 2000);
console.log("result: ", result);

var tmp = f2(1000, 3000);
result = f2(tmp, 2000);
console.log("result: ", result);


// 1부터 n까지의 합계
const sum = (n) => {
  // 중단점
  if (n == 1) {
    return 1;
  }
  // 자기 자신을 리턴 (재귀)
  return n + sum(n - 1);
};
console.log(sum(10));
*/

/*
피보나치 수열
첫번째와 두번째는 무조건 1
세번째부터는 앞의 두 개의 합
ex) 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
*/
/*
// 재귀를 이용하는 경우
// 큰 숫자를 대입하면 속도가 느리고, 결과가 나오지 않을 수 있다.
const fibo_recursion = (n) => {
  if (n == 1 || n == 2) {
    return 1;
  }
  return fibo_recursion(n - 1) + fibo_recursion(n - 2);
};

console.log(fibo_recursion(11));

// 재귀를 이용하지 않는 경우
const fibo_norecursion = (n) => {
  let n1 = 1;
  let n2 = 1;
  let fibo = 1;

  for (let i = 3; i <= n; i++) {
    fibo = n1 + n2;
    n2 = n1;
    n1 = fibo;
  }
  return fibo;
};

console.log(fibo_norecursion(11));
*/

/*
setInterval(함수, 주기) : 주기마다 함수를 호출해서 실행하는 함수
함수를 대입받아서 상태변화가 생길 때 호출되도록 하는 것이 callback
주기는 ms 단위
*/
/* setInterval(() => {
  console.log("콜백을 이용한 타이머 실행");
}, 5000); */

/* // 함수를 생성
function outer() {
  let x = 0;

  // 함수를 만들어서 리턴하는데, 이 함수는 함수 내에 있는 함수이므로
  // 외부에 있는 데이터를 조작하는 것이 가능
  return () => {
    x++;
    console.log(x);
  };
}

// 함수를 호출해서 함수를 리턴받아서 저장
var result = outer();

// 리턴받은 함수를 호출하면 outer 안에 있는 x값이 수정된다.
// 작업한 내역을 함수 안에 저장하면서 작업을 계속하는 것이 가능
result();
result();
result(); */

// ECMA 2015에서 매개변수에 기본값을 설정하는 문법이 추가가
const f1 = function (n = 1) {
  /*
  // 예전에는 or를 이용해서 기본값 설정
  const radius = n || 1;
  return Math.PI * radius * radius;
  */
  return Math.PI * n * n;
};

console.log(f1(10));
console.log(f1());
