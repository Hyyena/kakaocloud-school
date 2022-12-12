import { useLocation } from "react-router-dom";
import qs from "qs";

const About = () => {
  // Query String을 읽을 수 있는 Hook
  const location = useLocation();
  const queryString = qs.parse(location.search, {
    ignoreQueryPrefix: true,
  });
  console.log("🚀 ~ file: About.jsx:10 ~ About ~ queryString", queryString);

  return (
    <div>
      <h1>React Router Practice</h1>
      <p>Query String: {location.search}</p>
    </div>
  );
};

export default About;
