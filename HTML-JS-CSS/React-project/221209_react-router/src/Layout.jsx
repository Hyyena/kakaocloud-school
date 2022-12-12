import { Outlet, useNavigate } from "react-router-dom";

const Layout = () => {
  const navigate = useNavigate();

  // 뒤로 이동하는 함수
  const goBack = () => {
    navigate(-1);
  };

  // articles로 이동
  const goArticles = () => {
    navigate("/articles");
  };

  return (
    <div>
      <header style={{ background: "pink", padding: 16, fontSize: 24 }}>
        Header
        <button onClick={goBack}>Back</button>
        <button onClick={goArticles}>Post</button>
      </header>
      <main>
        <Outlet></Outlet>
      </main>
    </div>
  );
};

export default Layout;
