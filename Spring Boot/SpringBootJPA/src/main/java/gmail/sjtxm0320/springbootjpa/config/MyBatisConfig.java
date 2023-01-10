package gmail.sjtxm0320.springbootjpa.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// Spring Boot에서 환경 설정 클래스를 나타내는 Annotation
// 다른 Bean보다 먼저 읽는다.
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"gmail.sjtxm0320.springbootjpa.persistence"})
public class MyBatisConfig {
    @Bean
    public DataSource batisDataSource() {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        hikariConfig.setUsername("system");
        hikariConfig.setPassword("oracle");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        return dataSource;
    }

    @Bean
    public SqlSessionFactory batisSqlSessionFactory(@Qualifier("batisDataSource") DataSource batisDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSession = new SqlSessionFactoryBean();
        sqlSession.setDataSource(batisDataSource);
        return sqlSession.getObject();

    }

    @Bean
    public SqlSessionTemplate batisSqlSessionTemplate(SqlSessionFactory batisSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(batisSqlSessionFactory);
    }

}
