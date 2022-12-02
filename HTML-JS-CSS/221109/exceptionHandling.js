try {
  // 예외 발생
  // 예외 처리 구문이 없으면 프로그램 중단
  // 예외 처리 구문이 있으면 프로그램 계속 수행
  const arr = new Array(4300000000);

  // 예외 강제 발생
  // 클라이언트용 애플리케이션을 만들 때 많이 이용
  throw new Error("예외 강제 발생");
} catch (error) {
  // 예외가 발생했을 때 호출
  console.log("예외 발생");
  console.log("예외 이름: ", error.name);
  console.log("예외 메시지: ", error.message);
} finally {
  console.log("예외 발생 여부에 상관없이 무조건 수행");
}

console.log("메시지 출력");
