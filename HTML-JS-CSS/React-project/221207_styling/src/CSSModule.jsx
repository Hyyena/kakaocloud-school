import React from "react";
import classNames from "classnames";

import styles from "./CSSModule.module.scss";

const cx = classNames.bind(styles);

const CSSModule = () => {
  return (
    <div className={cx("wrapper", "inverted")}>
      <span className="something">CSS</span> Module
    </div>
  );
};

export default CSSModule;
