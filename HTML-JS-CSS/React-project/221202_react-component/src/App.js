import React, { Component } from "react";

import MyComponent from "./MyComponent";
import StateComponent from "./stateComponent";
import EventComponent from "./EventPractice";
import ValidationSample from "./ValidationSample";
import ScrollBox from "./ScrollBox";

class App extends Component {
  render() {
    return (
      <>
        <MyComponent name="Hyyena">태그 안의 내용</MyComponent>
        <StateComponent></StateComponent>
        <EventComponent></EventComponent>
        <ValidationSample></ValidationSample>
        <ScrollBox ref={(ref) => (this.scroll = ref)}></ScrollBox>
        <button onClick={(e) => this.scroll.scrollBottom()}>⏬</button>
      </>
    );
  }
}

export default App;
