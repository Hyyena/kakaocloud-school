// 스트림을 이용한 읽기
const fs = require("fs");

// 읽기 전용 스트림 생성
const readStream = fs.createReadStream("./test_01.txt", { highWaterMark: 16 });

// 데이터를 저장하기 위한 객체 생성
const data = [];

// 읽는 동안 발생하는 이벤트 처리
readStream.on("data", (chunk) => {
  // 읽는 동안에는 읽어온 데이터를 추가
  data.push(chunk);
});

// 읽기가 끝나면 발생하는 이벤트 처리
readStream.on("end", () => {
  // 지금까지 읽은 내용을 하나로 만들기
  let result = Buffer.concat(data);
  console.log(result.toString());
});

// 에러 발생 이벤트 처리
readStream.on("error", (error) => {
  console.log(error.message);
});
