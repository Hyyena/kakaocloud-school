import React from "react";
import axios from "axios";

import "./App.css";
import StyledComponent from "./components/StyledComponents";

function App() {
  return (
    <div>
      <nav>
        <div className="nav-wrapper">
          <div>React</div>
        </div>
      </nav>
      <div>Material Design</div>
      <div>
        <StyledComponent></StyledComponent>
      </div>
      <div>
        <button
          onClick={(e) => {
            /* // 1. Ajax
            let request = new XMLHttpRequest();

            // GET 방식 요청
            request.open("GET", "https://jsonplaceholder.typicode.com/users");

            // POST 방식일 때는 send에 파라미터 대입
            request.send("");

            request.addEventListener("load", () => {
              let data = JSON.parse(request.responseText);

              // 데이터를 가져오는데 성공했을 때
              console.log(
                "🚀 ~ file: App.js:28 ~ request.addEventListener ~ data",
                data
              );
            });

            request.addEventListener("error", (error) => {
              // 데이터를 가져오는데 실패했을 때 처리
              console.error(
                "🚀 ~ file: App.js:37 ~ request.addEventListener ~ error",
                error
              );
            });
            */
            /* // 2. Fetch API
            fetch("https://jsonplaceholder.typicode.com/users")
              .then((response) => response.json())
              .then((data) => {
                console.log("🚀 ~ file: App.js:50 ~ App ~ data", data);
              })
              .catch((error) => {
                console.error(
                  "🚀 ~ file: App.js:53 ~ App ~ error",
                  error.message
                );
              });
             */
            // 3. Axios
            axios
              .get("https://jsonplaceholder.typicode.com/users")
              .then((response) => {
                console.log(
                  "🚀 ~ file: App.js:65 ~ App ~ response",
                  response.data
                );
              })
              .catch((error) => {
                console.error(
                  "🚀 ~ file: App.js:71 ~ App ~ error",
                  error.message
                );
              });
          }}
        >
          Download
        </button>
      </div>
    </div>
  );
}

export default App;

/* Button 예제
import Button from "./components/Button";

function App() {
  return <Button>Btn</Button>;
}

export default App;
*/

/* Box 예제
import classNames from "classnames/bind";

import styles from "./App.scss";
import CSSModule from "./CSSModule";
import { classNames } from 'classnames';

const cx = classNames.bind(styles);

function App() {
  const isBlue = false;
  return (
    <div>
      <div className={cx("box", { blue: isBlue })}>
        <div className={cx("box-inside")}></div>
      </div>
      <CSSModule></CSSModule>
    </div>
  );
}

export default App;

*/
