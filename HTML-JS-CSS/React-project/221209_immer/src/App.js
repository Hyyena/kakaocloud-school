import React, { useRef, useCallback, useState } from "react";

import produce from "immer";

function App() {
  // 컴포넌트 안에서 사용할 변수 생성
  const nextId = useRef(1);

  // state를 생성하고, setter 함수를 설정
  // state가 수정되면 리렌더링 수행
  const [form, setForm] = useState({ name: "", userName: "" });
  const [data, setData] = useState({
    array: [],
    uselessValue: null,
  });

  // input에 입력받는 경우 입력하는 데이터가 변경될 때, state를 수정해주는 함수
  const onChange = useCallback((e) => {
    setForm(
      // draft는 from의 복제본이다.
      // draft를 수정하면 immer가 자동으로 form에 데이터를 전송
      produce((draft) => {
        draft[e.target.name] = e.target.value;
      })
    );
  }, []);

  /* immer 미사용 시 onChange 함수
  const onChange = useCallback(
    (e) => {
      setForm({
        ...form,
        [e.target.name]: [e.target.value],
      });
    },
    [form]
  );
  */

  /*
   * 입력받은 데이터를 등록하는 함수
   * form에서 submit 이벤트가 발생할 떄 호출
   * Component 안에서 함수를 만들 때는 특별한 경우가 아니면
   * useCallback 안에 만드는 것이 좋다.
   * useCallback을 사용하면 두 번째 매개변수로 대입된
   * deps 배열 안의 데이터가 변경되는 경우에만 함수를 새로 만든다.
   * useCallback을 사용하지 않으면 리렌더링 될때마다 함수가 다시 만들어진다.
   */
  const onSubmit = useCallback(
    (e) => {
      /*
       * 기본적으로 제공되는 이벤트를 수행하지 않도록 한다.
       * a 태그를 이용한 이동이나 form의 submit, reset 이벤트는 화면 전체를 새로 생성 (이전에 가지고 있던 내용을 모두 삭제)
       * React, Vue, Angular는 SPA Framework이기 때문에 화면 전체를 다시 렌더링 하면 기본틀이 무너진다.
       * 화면에 출력된 내용과 가상의 DOM을 비교해서 변경된 부분만 리렌더링 수행
       */
      e.preventDefault();

      const info = {
        id: nextId.current,
        name: form.name,
        userName: form.userName,
      };

      // data를 draft에 깊은 복사를 하고,
      // draft에 작업을 수행한 후 다시 data에 복제
      setData(
        produce((draft) => {
          draft.array.push(info);
        })
      );

      /* immer 미사용
      const info = {
        id: nextId.current,
        name: form.name,
        userName: form.userName,
      };

      setData({
        ...data,
        array: data.array.concat(info),
      });
      */

      setForm({
        name: "",
        userName: "",
      });

      nextId.current += 1;
    },
    [form.name, form.userName]

    /* immer 미사용
    [data, form.name, form.userName]
    */
  );

  // 항목을 삭제하는 함수
  const onRemove = useCallback((id) => {
    setData(
      produce((draft) => {
        draft.array.splice(
          draft.array.findIndex((info) => info.id === id),
          1
        );
      })
    );
  }, []);
  /* immer 미사용
  const onRemove = useCallback(
    (e) => {
      setData({
        ...data,
        array: data.array.filter((info) => info.id !== e),
      });
    },
    [data]
  );
  */
  return (
    <>
      <form onSubmit={onSubmit}>
        <input
          name="userName”"
          placeholder="Enter your username"
          value={form.userName}
          onChange={onChange}
        />
        <input
          name="name"
          placeholder="Enter your name"
          value={form.name}
          onChange={onChange}
        />
        <button type="submit">Register</button>
      </form>
      <div>
        <ul>
          {data.array.map((info) => (
            <li key={info.id} onClick={() => onRemove(info.id)}>
              {info.userName}({info.name})
            </li>
          ))}
        </ul>
      </div>
    </>
  );
}
export default App;
