import React, { Component } from "react";

class ErrorBoundary extends Component {
  state = {
    error: false,
  };

  // Component에서 예외가 발생하면 호출되는 메서드
  componentDidCatch(error, info) {
    this.setState({
      error: true,
    });
    console.log(
      "🚀 ~ file: ErrorBoundary.jsx:9 ~ ErrorBoundary ~ componentDidCatch ~ error, info",
      error,
      info
    );
  }

  render() {
    // error가 true일 때 출력
    if (this.state.error) {
      return <div>Error❗</div>;
    }

    // error가 false일 때, 하위 컴포넌트 출력
    else {
      return this.props.children;
    }
  }
}

export default ErrorBoundary;
