function f1(n, msg) {
  // JavaScript에서는 매개변수로 대입된 데이터를
  // arguments에도 저장
  // 순서대로 저장한 배열이 arguments
  // 화살표 함수에서는 arguments를 사용할 수 없다.
  for (var i = 0; i < arguments[0]; i++) {
    console.log(arguments[1]);
  }
}

f1(3, "arguments");

function f2(n, msg) {
  console.log(n);
  console.log(msg);
  console.log(arguments[2]);
}

// 함수의 매개변수가 2개인데 1개만 대입하면
// 첫번째 매개변수로 대입되고, 나머지는 undefined
f2(10);

// 매개변수를 더 많이 대입하면 순서대로 대입이 된다.
f2(10, "JavaScript", "123");
