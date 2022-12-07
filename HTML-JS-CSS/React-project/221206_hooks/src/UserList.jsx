import React, { useEffect } from "react";

function User({ user, onRemove, onToggle }) {
  // Mount 될 때, 그리고 state가 변경될 때 모두 호출
  useEffect(() => {
    console.log("컴포넌트가 화면에 나타남");

    // 삽입과 수정 시 호출
    // 이 데이터의 id가 존재하면 수정하고, id가 존재하지 않으면 삽입
    console.log(user);

    // 함수를 리턴하면 컴포넌트가 사라질 때 호출
    return () => {
      console.log("컴포넌트 사라짐");
    };
  }, []);
  return (
    <div>
      <b
        onClick={(e) => onToggle(user.id)}
        style={{
          cursor: "pointer",
          color: user.active ? "gray" : "orange",
        }}
      >
        {user.username}
      </b>
      <span>({user.email})</span>
      <span>({user.email})</span>
      <button onClick={() => onRemove(user.id)}>Del</button>
    </div>
  );
}

function UserList({ users, onRemove, onToggle }) {
  return (
    <div>
      {users.map((user) => (
        <User
          user={user}
          key={user.id}
          onRemove={onRemove}
          onToggle={onToggle}
        ></User>
      ))}
    </div>
  );
}

export default UserList;
