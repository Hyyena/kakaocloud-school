const os = require("os");

let position = os.type().toLowerCase().indexOf("windows");

if (position >= 0) {
  console.log("windows");
} else {
  console.log("windows 아님");
}

// 다른 프로세스를 실행할 수 있는 모듈 가져오기
const exec = require("child_process").exec;

// 프로세스 준비
// windows는 dir로 디렉토리 목록을 확인
// 나머지 운영체제는 ls
let process = exec("dir");

// 프로세스가 정상적으로 수행되면
process.stdout.on("data", function (data) {
  console.log(data.toString());
});

// 수행되지 않으면
process.stderr.on("data", function (data) {
  console.log(data.toString());
});
