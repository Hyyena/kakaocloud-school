import { Link } from "react-router-dom";

const Articles = () => {
  return (
    <ul>
      <li>
        <Link to="/articles/1">오늘도 개발자는 안된다고 말했다.</Link>
      </li>
      <li>
        <Link to="/articles/2">
          손으로 코딩하고 뇌로 컴파일하며 눈으로 디버깅한다.
        </Link>
      </li>
      <li>
        <Link to="/articles/3">오늘 점심은 된장박이</Link>
      </li>
    </ul>
  );
};

export default Articles;
