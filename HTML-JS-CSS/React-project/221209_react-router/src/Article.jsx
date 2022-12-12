import { useParams } from "react-router-dom";

const Article = () => {
  const { id } = useParams();

  return (
    <div>
      <h2>Post {id}</h2>
    </div>
  );
};

export default Article;
