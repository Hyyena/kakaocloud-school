import React from "react";
import styled, { css } from "styled-components";

const Box = styled.div`
  background: ${(props) => props.color || "#FFFDDE"};
  padding: 1rem;
  display: flex;
`;

const Button = styled.button`
  background: #e7fbbe;
  color: black;
  border-radius: 4px;
  padding: 0.5rem;
  display: flex;
  align-items: center;
  justify-content: center;
  box-sizing: border-box;
  font-size: 1rem;
  font-weight: 600;

  &:hover {
    background: rgba(255, 203, 203, 1);
  }

  & + button {
    margin-left: 1rem;
  }
`;

const StyledComponent = () => {
  return (
    <Box color="#FFFDDE">
      <Button>Hi👋</Button>
      <Button>🎉Welcome🎉</Button>
    </Box>
  );
};

export default StyledComponent;
