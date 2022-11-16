/* 
// 용량이 큰 파일을 생성
const fs = require("fs");

const file = fs.createWriteStream("./test_02.txt");

for (let i = 0; i < 10000000; i++) {
  file.write("용량이 큰 파일 만들기\n");
}

file.end();
 */

// 스트림을 사용하지 않고 읽고 쓰기
const fs = require("fs");

console.log("No Stream");
console.log(`복사 전 메모리 사용량: ${process.memoryUsage().rss}`);

const data1 = fs.readFileSync("./test_02.txt");
fs.writeFileSync("./test_02_noStream.txt", data1);

console.log(`복사 후 메모리 사용량: ${process.memoryUsage().rss}`);

// 스트림을 사용한 읽고 쓰기
console.log("Stream");
console.log(`복사 전 메모리 사용량: ${process.memoryUsage().rss}`);

const readStream = fs.createReadStream("./test_02.txt");
const writeStream = fs.createWriteStream("./test_02_stream.txt");

readStream.pipe(writeStream);
readStream.on("end", () => {
  console.log(`복사 후 메모리 사용량: ${process.memoryUsage().rss}`);
});
