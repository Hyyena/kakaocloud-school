"use strict";

const fs = require("fs");
const path = require("path");
const Sequelize = require("sequelize");
const env = process.env.NODE_ENV || "development";
const config = require("../config/config.js")[env];

// 모델 가져오기
const User = require("./user");
const Post = require("./post");
const Hashtag = require("./hashtag");

const db = {};

let sequelize;
if (config.use_env_variable) {
  sequelize = new Sequelize(process.env[config.use_env_variable], config);
} else {
  sequelize = new Sequelize(
    config.database,
    config.username,
    config.password,
    config
  );
}

db.sequelize = sequelize;
db.Sequelize = Sequelize;

db.User = User;
db.Post = Post;
db.Hashtag = Hashtag;

// 초기화 작업
User.init(sequelize);
Post.init(sequelize);
Hashtag.init(sequelize);

// 관계 설정
User.associate(db);
Post.associate(db);
Hashtag.associate(db);

module.exports = db;
