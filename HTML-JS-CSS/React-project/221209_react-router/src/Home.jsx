import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div>
      <h1>Main Page</h1>
      <ul>
        <li>
          <Link to="/about">Introduction</Link>
        </li>
        <li>
          <Link to="/profile/hyyena">Hyyena</Link>
        </li>
        <li>
          <Link to="/profile/yena">예나</Link>
        </li>
        <li>
          <Link to="/profile/chaewon">채원</Link>
        </li>
      </ul>
    </div>
  );
};

export default Home;
