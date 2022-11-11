let arr1 = ["에스파", "소녀시대", "레드벨벳", "에프엑스"];

// JavaScript는 숫자 배열을 문자 배열로 판단하고 정렬
// 코드를 가지고 정렬하기 때문에 아래와 같이 자릿수가 다른 데이터를 정렬하면 오류 발생
let arr2 = [20, 40, 230, 110];

console.log(arr1.sort());

// 숫자의 경우는 문제가 발생
console.log(arr2.sort());

// sort 메서드에는 매개변수가 2개이고, 정수를 리턴하는 함수 대입 가능
// 매개변수 2개는 배열의 데이터가 순차적으로 전부 대입
// 양수를 리턴하면 앞의 데이터가 크다고 판단하고 위치를 변경
console.log(
  arr2.sort((a, b) => {
    return a - b;
  })
);

// 문자열 배열의 내림차순
// 오름차순 정렬 후 reverse를 해도 되지만 크기 비교를 이용
console.log(
  arr1.sort((a, b) => {
    if (a < b) {
      return 1;
    } else if (a == b) {
      return 0;
    } else {
      return -1;
    }
  })
);

// 인스턴스를 생성할 수 있는 생성자
function Book(name, price, date) {
  this.name = name;
  this.price = price;
  this.date = date;

  this.toString = function () {
    return this.name + ": " + this.price + ": " + this.date;
  };
}

// Book 배열 생성
let books = [
  new Book("Python", 30000, new Date(2022, 10, 10)),
  new Book("Java", 40000, new Date(2022, 10, 9)),
  new Book("C", 15000, new Date(2000, 2, 1)),
  new Book("JavaScript", 25000, new Date(2022, 5, 5)),
];

// 배열이 제대로 만들어졌는지 확인
// console.log(books);

// console.log(
//   books.sort((a, b) => {
//     return a.price - b.price;
//   })
// );

// console.log(
//   books.sort((a, b) => {
//     return a.date.getTime() - b.date.getTime();
//   })
// );

// 1이면 name의 오름차순, 2이면 name의 내림차순
// 3이면 price의 오름차순, 4이면 price의 내림차순
// 5이면 date의 오름차순, 6이면 date 내림차순
// 나머지는 입력한 순서대로
let menu = prompt("정렬 방법을 선택하세요");
let result;

switch (menu) {
  case "1":
    result = books.sort((a, b) => {
      if (a.name > b.name) {
        return 1;
      } else {
        return -1;
      }
    });
    break;
  case "2":
    result = books.sort((a, b) => {
      if (a.name < b.name) {
        return 1;
      } else {
        return -1;
      }
    });
    break;
  case "3":
    result = books.sort((a, b) => {
      return a.price - b.pirce;
    });
    break;
  case "4":
    result = books.sort((a, b) => {
      return b.price - a.price;
    });
    break;
  case "5":
    result = books.sort((a, b) => {
      return a.date.getTime() - b.date.getTime();
    });
    break;
  case "6":
    result = books.sort((a, b) => {
      return b.date.getTime() - a.date.getTime();
    });
    break;
  default:
    result = books;
}

console.log(result);
