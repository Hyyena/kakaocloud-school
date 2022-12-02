const Sequelize = require("sequelize");

module.exports = class Domain extends Sequelize.Model {
  // 테이블에 대한 설정
  static init(sequelize) {
    return super.init(
      {
        // 컬럼에 대한 설정
        host: {
          type: Sequelize.STRING(100),
          allowNull: false,
        },
        clientSecret: {
          type: Sequelize.STRING(36),
          allowNull: false,
        },
        type: {
          type: Sequelize.ENUM("free", "premium"),
          allowNull: false,
        },
      },
      {
        // 테이블에 대한 설정
        sequelize,
        timestamps: true,
        underscored: false,
        modelName: "Domain",
        tableName: "domains",
        paranoid: true,
      }
    );
  }

  // 관계에 대한 설정
  static associate(db) {
    // User와 Domain은 1:N
    // User의 기본 키가 Domain에 외래 키로 추가됨
    db.Domain.belongsTo(db.User);
  }
};
