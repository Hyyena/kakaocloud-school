import React from "react";

function CreateUser({ username, email, onChange, onCreate }) {
  return (
    <div>
      <input
        name="username"
        value={username}
        placeholder="이름을 입력해주세요."
        onChange={onChange}
      ></input>
      <input
        name="email"
        value={email}
        placeholder="이메일을 입력해주세요."
        onChange={onChange}
      ></input>
      <button onClick={onCreate}>Add</button>
    </div>
  );
}

export default CreateUser;
