import React, { useState, useMemo, useCallback } from "react";

// 배열의 평균을 구한 뒤 리턴하는 함수
const getAverage = (numbers) => {
  console.log("Caculate Average");
  if (numbers.length === 0) return 0;
};

/*
 * reduce는 배열을 순회하면서 연산을 수행한 후 하나의 값을 리턴
 * 매개 변수는 두 개
 *
 * 첫 번째 매개변수는 수행할 함수
 * 이 함수는 4개의 매개변수를 갖는다.
 * 첫 번째는 누적값, 두 번째는 배열의 요소, 세 번째는 배열의 인덱스, 네 번째는 배열
 *
 * 두 번째 매개변수는 연산을 시작할 때의 초기값
 * 이 매개변수를 생략하면 배열의 첫 번째 요소로 설정
 *
 * [10, 20, 130, 240]
 * 10 + 20 = 30, 30 + 130 = 160, 160 + 240 = 400 -> 따라서 400 리턴
 */

const Average = () => {
  // 숫자 배열
  const [list, setList] = useState([]);

  // useMemo를 이용해서 getAverage를 호출
  // list에 변화가 생긴 경우만 메서드를 호출하고, 그 이외는 결과를 재사용
  const avg = useMemo(() => getAverage(list), [list]);

  // 입력 받은 내용
  const [number, setNumber] = useState();

  // input에 내용을 수정할 때 호출되는 메서드
  const onChange = useCallback((e) => {
    setNumber(e.target.value);
  }, []);

  // 추가를 눌렀을 때 호출되는 메서드
  // 이 함수는 number와 list가 변경될 때만 다시 생성
  const onInsert = useCallback(
    (e) => {
      const nextList = list.concat(parseInt(number));
      setList(nextList);
      setNumber("");
    },
    [number, list]
  );

  return (
    <div>
      <input value={number} onChange={onChange}></input>
      <button onClick={onInsert}>Add</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      <div>
        <b>Avg: </b>
        {avg}
      </div>
    </div>
  );
};

export default React.memo(Average);
