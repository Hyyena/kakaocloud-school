import React, { useState, useRef } from "react";
import UserList from "./UserList";
import CreateUser from "./CreateUser";

// acitve가 true인 데이터 개수
const countActiveUser = (users) => {
  console.log("사용자 수 카운트");
  return users.filter((user) => user.active).length;
};

const App = () => {
  const [inputs, setInputs] = useState({
    username: "",
    email: "",
  });

  const { username, email } = inputs;

  // 배열의 데이터를 수정하면 컴포넌트가 리렌더링 될 수 있도록 state로 생성
  const [users, setUsers] = useState([
    { id: 1, username: "Hyyena", email: "hyyena@gmail.com", active: false },
    { id: 2, username: "yena", email: "yena123@gmail.com", active: true },
    { id: 2, username: "카리나", email: "karina@gmail.com", active: true },
  ]);

  // 변수 생성
  const nextId = useRef(3);

  // 데이터 삽입 메서드
  const onCreate = () => {
    // 하나의 객체 생성
    const user = {
      id: nextId.current,
      username,
      email,
    };

    // users에 user를 추가
    setUsers([...users, user]);

    // 입력 요소 초기화
    setInputs({
      username: "",
      email: "",
    });

    // 다음 id를 위해서 id 1 증가
    nextId.current += 1;
  };

  const onChange = (e) => {
    const { name, value } = e.target;

    // state를 수정할 때는 원본을 복제한 후 수정
    setInputs({
      ...inputs,
      [name]: value,
    });
  };

  // 삭제하는 함수
  const onRemove = (id) => {
    // users state에서 id가 id인 데이터 삭제
    // id가 일치하지 않는 데이터만 삭제
    // 실제로는 id가 일치하지 않는 데이터로 배열을 만들어 수정
    setUsers(users.filter((user) => user.id !== id));
  };

  // 수정하는 메서드
  // id에 해당하는 데이터의 active 속성 값을 반전
  const onToggle = (id) => {
    setUsers(
      users.map((user) =>
        user.id === id ? { ...user, active: !user.active } : user
      )
    );
  };

  // 활성화된 user 개수를 세는 함수 호출
  // users에 변화가 생긴 경우만 함수를 호출하고,
  // 그 이외의 경우는 결과를 복사하도록 수정
  const count = useMemo(() => {
    countActiveUser(users), [users];
  });

  return (
    <div>
      <CreateUser
        username={username}
        email={email}
        onChange={onChange}
        onCreate={onCreate}
      ></CreateUser>
      <UserList
        users={users}
        onRemove={onRemove}
        onToggle={onToggle}
      ></UserList>
    </div>
  );
};

export default App;

/* useEffect 사용

import React, { useState, useEffect } from "react";

const ClassEffect = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log("Mount와 Update가 끝나면 호출");
    document.title = `You Clicked ${count} times`;
  });

  return (
    <div>
      <p>You Clicked {count} times</p>
      <button onClick={(e) => setCount(count + 1)}>+1</button>
    </div>
  );
};

function App() {
  return (
    <div>
      <ClassEffect></ClassEffect>
    </div>
  );
}

export default App;
 */

/* useRef 사용
import InputSample from "./InputSample";

function App() {
  return (
    <div>
      <InputSample></InputSample>
    </div>
  );
}

export default App;
 */

/* useState 사용
import React, { Component, useState } from "react";

class ClassState extends Component {
  // 생성자를 만들지 않고 아래와 같이 state를 초기화 해도 된다.
  // state = {
  //   count: 0,
  // };


  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }

  render() {
    return (
      <div>
        <h1>Class Component</h1>
        <p>클릭을 {this.state.count}번 수행</p>
        <button onClick={(e) => this.setState({ count: this.state.count + 1 })}>
          +1
        </button>
      </div>
    );
  }
}

// 함수형 컴포넌트에서 state 사용
const FunctionState = () => {
  const [count, setCount] = useState(0);
  return (
    <div>
      <h1>Function Component</h1>
      <p>클릭을 {count}번 수행</p>
      <button onClick={(e) => setCount(count + 1)}>+1</button>
    </div>
  );
};

function App() {
  return (
    <div>
      <ClassState></ClassState>
      <FunctionState></FunctionState>
    </div>
  );
}

export default App;
*/

/* hook 사용
import Iteration from "./iteration";
import ErrorBoundary from "./ErrorBoundary";

function App() {
  return (
    <div>
      <ErrorBoundary>
        <Iteration></Iteration>
      </ErrorBoundary>
    </div>
  );
}

export default App;
 */
