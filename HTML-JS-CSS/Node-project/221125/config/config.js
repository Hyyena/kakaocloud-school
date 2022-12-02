require("dotenv").config();

const env = process.env;

const development = {
  username: env.DB_USERNAME,
  password: env.DB_PASSWORD,
  database: env.DATABASE,
  host: env.HOST,
  dialect: env.DIALECT,
};

const test = {
  username: env.DB_USERNAME,
  password: env.DB_PASSWORD,
  database: env.DATABASE,
  host: env.HOST,
  dialect: env.DIALECT,
};

const production = {
  username: env.DB_USERNAME,
  password: env.DB_PASSWORD,
  database: env.DATABASE,
  host: env.HOST,
  dialect: env.DIALECT,
};

module.exports = { development, test, production };
