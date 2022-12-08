import { useState, useCallback } from "react";
import "./ToDoInsert.scss";

// react-icons의 MaterialDesign의 MdAdd라는 아이콘 사용
import { MdAddCircle } from "react-icons/md";

const ToDoInsert = ({ onInsert }) => {
  // 입력된
  const [value, setValue] = useState("");

  // 입력 내용이 변경될 때 호출될 함수
  const onChange = useCallback((e) => {
    setValue(e.target.value);
  }, []);

  /*
   * form에서 submit 이벤트가 발생하면 호출될 함수
   * form 안에서 submit 버튼을 눌러도 submit 이벤트가 발생하지만
   * form 안에서 Enter를 눌러도 submit 이벤트는 발생한다.
   */
  const onSubmit = useCallback(
    (e) => {

      /* 내용을 추가할 건지 묻는 코드
      const result = window.confirm(`추가할 내용: ${value}`);

      if (result === false) {
        e.preventDefault();
        return;
      }
      */

      // 데이터 삽입
      onInsert(value);

      // input 초기화
      setValue("");

      // 제공되는 기본 이벤트 처리 코드를 수행하지 않음
      // form의 submit이나 a 태그는 화면 전체를 갱신하기 때문에 이전 내용을 모두 잃어버림
      e.preventDefault();
    },
    [onInsert, value]
  );

  return (
    <form className="ToDoInsert" onSubmit={onSubmit}>
      <input
        placeholder="Write Tasks"
        value={value}
        onChange={onChange}
      ></input>
      <button type="submit">
        <MdAddCircle></MdAddCircle>
      </button>
    </form>
  );
};

export default ToDoInsert;
