// 배열은 순차적으로 대입된다.
// 배열은 Iterator를 준수하기 때문에 순서대로 대입
let arr = [100, 200, 300, 400];
let [one, two, three, four] = arr;
console.log(one);

// Iterator가 없기 때문에 순차적으로 대입되는 것이 아니고, 이름을 보고 대입된다.
let obj = { name: "카리나", job: "가수" };
let { name, job } = obj;
console.log(name);

const display = ({ msg, n }) => {
  for (let i = 0; i < n; i++) {
    console.log(msg);
  }
};

display({ n: 3, msg: "Hello" });
