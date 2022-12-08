import React, { useCallback } from "react";
import cn from "classnames";

import {
  MdCheckBoxOutlineBlank,
  MdCheckBox,
  MdRemoveCircleOutline,
} from "react-icons/md";

import "./ToDoListItem.scss";

const ToDoListItem = ({ todo, onRemove, onToggle, style }) => {
  // 넘어온 데이터 중에서 id, text, checked만 분해
  const { id, text, checked } = todo;

  // 데이터 삭제 함수
  const onDelete = useCallback(
    (e) => {
      const result = window.confirm(
        `❌ 아래 항목을 삭제하시겠습니까? ❌

${text}`
      );

      if (result) {
        onRemove(id);
      }
    },
    [onRemove, id, text]
  );

  return (
    <div className="ToDoListItem-virtualized" style={style}>
      <div className="ToDoListItem">
        <div
          className={cn("checkbox", { checked })}
          onClick={(e) => onToggle(id)}
        >
          {checked ? (
            <MdCheckBox></MdCheckBox>
          ) : (
            <MdCheckBoxOutlineBlank></MdCheckBoxOutlineBlank>
          )}
          <div className="text">{text}</div>
        </div>
        <div className="remove" onClick={onDelete}>
          <MdRemoveCircleOutline />
        </div>
      </div>
    </div>
  );
};

export default React.memo(ToDoListItem);
