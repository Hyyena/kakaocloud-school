// 환경 변수
require("dotenv").config();
const env = process.env;

const express = require("express");
const path = require("path");

const app = express();

app.set("port", process.env.PORT || 3000);

// sequelize 연결
const { sequelize } = require("./models");
sequelize
  .sync({ force: false })
  .then(() => {
    console.log("🎉 DB Connected!");
  })
  .catch((error) => {
    console.log(error);
  });

const User = require("./models/users");
const Comment = require("./models/comments");

app.get("/", async (req, res) => {
  User.create({
    name: "Hyyena",
    age: 27,
  });
});

app.listen(app.get("port"), () => {
  console.log("📡", app.get("port"), "PORT wating...");
});
