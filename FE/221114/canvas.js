// 캔버스 찾아오기
let canvas = document.getElementById("canvas");

// 캔버스에 그릴 수 있는 정보 객체를 찾아오기
let context = canvas.getContext("2d");

context.fillRect(0, 0, 150, 100);
context.fillText("Hello World!", 0, 110);
