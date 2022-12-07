import React, { Component } from "react";

class Iteration extends Component {
  // 내용이 변경되면 Component를 리렌더링하는 state 생성
  state = {
    names: ["최예나", "조유리", "김채원", "노지선", "박지원", "송하영"],
    name: "",
  };

  // Input에 입력하면 name state의 값을 변경하는 이벤트 처리 함수
  handleChange = (e) => {
    this.setState({
      name: e.target.value,
    });
  };

  /*
   * 버튼을 누르면 동작하는 함수
   * name의 값을 names에 추가하는 함수
   * push 대신 배열을 복제해서 연결하는 concat 함수 이용
   */
  handleInsert = (e) => {
    this.setState({
      names: this.state.names.concat(this.state.name),
      name: "",
    });
  };

  /*
   * 데이터 삭제 함수
   * index를 매개변수로 받아서 삭제
   */
  handleRemove = (index) => {
    let confirm = window.confirm("정말로 삭제하시겠습니까?");
    if (confirm !== false) {
      return;
    }

    const { names } = this.state;
    // const names = this.state.names;

    /*
     * slice: 매개변수를 두 개 받아서 배열을 잘라내서 복제 후 리턴하는 함수
     * 매개 변수는 시작 위치와 마지막 위치를 대입
     */
    /*
    this.setState({
      names: [names.slice(0, index), names.slice(index + 1, names.length)],
    });
    */

    // 넘어온 index와 배열의 index가 다른 것만 추출
    this.setState({
      names: names.filter((item, e) => e !== index),
    });
  };

  render() {
    const nameList = this.state.names.map((name, index) => (
      <li key={index} onDoubleClick={(e) => this.handleRemove(index)}>
        {name}
        <button onClick={(e) => this.handleRemove(index)}>Del</button>
      </li>
    ));

    return (
      <div>
        <input onChange={this.handleChange} value={this.state.name}></input>
        <button onClick={this.handleInsert}>Add</button>
        <ul>{nameList}</ul>
      </div>
    );
  }
}

export default Iteration;
