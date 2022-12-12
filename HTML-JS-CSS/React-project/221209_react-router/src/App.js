import { Routes, Route } from "react-router-dom";

import About from "./About";
import Home from "./Home";
import Profile from "./Profile";
import Article from "./Article";
import Articles from "./Articles";
import Layout from "./Layout";
import Login from "./Login";
import MyPage from "./MyPage";
import ColorBox from "./ColorBox";

function App() {
  return (
    <Routes>
      <Route path="/login" element={<Login></Login>}></Route>
      <Route path="/mypage" element={<MyPage></MyPage>}></Route>
      <Route element={<Layout></Layout>}>
        <Route index element={<Home></Home>}></Route>
        <Route path="/about" element={<About></About>}></Route>
        <Route path="/profile/:username" element={<Profile></Profile>}></Route>
      </Route>
      <Route path="/articles" element={<Articles></Articles>}>
        <Route path=":id" element={<Article></Article>}></Route>
      </Route>
      <Route path="colorbox" element={<ColorBox></ColorBox>}></Route>
      <Route path="*" element={<Article></Article>}></Route>
    </Routes>
  );
}

export default App;
