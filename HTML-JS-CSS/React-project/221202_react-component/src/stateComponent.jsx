import React, { useState } from "react";

const StateComponent = () => {
  // 함수형 컴포넌트에서 state를 생성하는 방법
  const [message, setMessage] = useState("");

  // 버튼에 연결할 이벤트 처리 함수
  const onClickEnter = (e) => {
    setMessage("Hi👋");
  };
  const onClickLeave = (e) => {
    setMessage("Bye🤝");
  };

  const [color, setColor] = useState("pink");

  return (
    <>
      <button onClick={onClickEnter}>Enter</button>
      <button onClick={onClickLeave}>Exit</button>
      <h1 style={{ color }}>{message}</h1>
      <button style={{ color }} onClick={() => setColor("pink")}>
        Pink
      </button>
      <button style={{ color }} onClick={() => setColor("red")}>
        Red
      </button>
      <button style={{ color }} onClick={() => setColor("green")}>
        Green
      </button>
      <button style={{ color }} onClick={() => setColor("blue")}>
        Blue
      </button>
    </>
  );
};

export default StateComponent;

/* state에 함수 전달
import React, { Component } from "react";
import StateComponent from './stateComponent';

class StateComponent extends Component {
  state = { number: 0 };

  render() {
    return (
      <>
        <p>숫자: {this.state.number}</p>
        <button
          onClick={(e) => {
            this.setState({ number: this.state.number + 1 }, () => {
              console.log(`state의 값이 ${this.state.number}로 변경됨`);
              console.log(this.state);
            });
          }}
        >
          증가
        </button>
      </>
    );
  }
}

export default StateComponent;
 */
