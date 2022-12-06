// * 클래스형 컴포넌트
import React, { Component } from "react";
import PropTypes from "prop-types";

class MyComponent extends Component {
  render() {
    // props 가져오기
    // 클래스형 컴포넌트에는 props 속성이 존재
    const { name, year, children } = this.props;
    return (
      <>
        <div>Hi👋 My name is {name}</div>
        <p>children 값은 {children}</p>
        <p>I was born in {year}</p>
      </>
    );
  }
}

MyComponent.defaultProps = {
  name: "Hyyena",
};

MyComponent.propTypes = {
  name: PropTypes.string,
  year: PropTypes.number.isRequired,
};

export default MyComponent;

/* 함수형 컴포넌트
// * 함수형 컴포넌트
import React from "react";
import PropTypes from "prop-types";

const MyComponent = ({ children, name, year }) => {
	return (
		<>
			<div>My Component Name is {name}</div>
			<p>{children}</p>
			<p>나는 {year}년에 태어났다.</p>
		</>
	);
};

MyComponent.propTypes = {
	name: PropTypes.string,
	year: PropTypes.number.isRequired,
};

MyComponent.defaultProps = {
	name: "default",
};

export default MyComponent;
*/
