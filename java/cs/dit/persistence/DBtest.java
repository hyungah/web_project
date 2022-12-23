package cs.dit.persistence;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cs.dit.mapper.TimeMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링 실행 역할을 할 것이라고 알림
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //설정파일 읽어내기
@Log4j

public class DBtest {

	@Autowired
	private DataSource ds;
   
   @Autowired
   private SqlSessionFactory sessionFactory;
   
   @Autowired
   private TimeMapper timeMapper;

   
   @Test
   public void testConnection() {
      try {
         Class class1 = Class.forName("org.mariadb.jdbc.Driver");
         
         log.info(class1);
         
         Connection con = DriverManager.getConnection(
               "jdbc:mariadb://localhost:3306/hyunahdb", "hyunah", "1111");
         log.info(con);
      } catch(Exception e){
         e.printStackTrace();
      }
   }
   
   @Test
   public void testCP() {
      try(Connection con = ds.getConnection();){
         log.info("testCP--------------------------");
         log.info(con);
      } catch(Exception e) {
         e.printStackTrace();
         log.error(e.getMessage());
      }
   }
   
   @Test
   public void testMybatis() {
      try(SqlSession session = sessionFactory.openSession();
            Connection con = session.getConnection() ){ 
         log.info("sqlSession-----------------------------");
         log.info(session);
         log.info(con);
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   @Test
   public void testGetTime01() {
      log.info("mybatis-test01--------------------------");
      log.info(timeMapper.getClass().getName());
      log.info(timeMapper.getTime01());
   }
   @Test
   public void testGetTime02() {
      log.info("mybatis-test02--------------------------");
      log.info(timeMapper.getClass().getName());
      log.info(timeMapper.getTime01());
   }
   

}