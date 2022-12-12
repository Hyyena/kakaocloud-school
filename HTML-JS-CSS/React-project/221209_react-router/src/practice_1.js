import { createStore } from "redux";

// 사용할 상태 정의
const initialState = {
  counter: 0,
  text: "",
  list: [],
};

// 액션 타입 생성
const INCREASE = "INCREASE";
const DECREASE = "DECREASE";
const CHANGE_TEXT = "CHANGE_TEXT";
const ADD_TO_LIST = "ADD_TO_LIST";

// 액션 생성 함수
const increase = () => {
  return { type: INCREASE };
};

const decrease = () => {
  return { type: DECREASE };
};

const changeText = (text) => {
  return { type: CHANGE_TEXT, text };
};

const addToList = (item) => {
  return { type: ADD_TO_LIST, item };
};

// reducer
function reducer(state = initialState, action) {
  switch (action.type) {
    case INCREASE:
      return { ...state, counter: state.counter + 1 };
    case DECREASE:
      return { ...state, counter: state.counter - 1 };
    case CHANGE_TEXT:
      return { ...state, text: action.text };
    case ADD_TO_LIST:
      return { ...state, list: state.list.concat(action.item) };
    default:
      return state;
  }
}

// store 만들기
const store = createStore(reducer);

// 현재 store의 상태
console.log("🚀 ~ file: practice_1.js:47 ~ store", store.getState());

// listener 설정
// store의 상태가 변경될 때 호출
const listener = () => {
  const state = store.getState();
  console.log("🚀 ~ file: practice_1.js:55 ~ listener ~ state", state);
};

// 구독 설정
const unsubscripbe = store.subscribe(listener);

// 액션 호출
store.dispatch(increase());
store.dispatch(decrease());
store.dispatch(changeText("Hi👋"));
store.dispatch(addToList({ id: 1, text: "Hmm" }));
