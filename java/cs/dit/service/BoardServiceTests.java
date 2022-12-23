package cs.dit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cs.dit.domain.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) //현재 테스트 코드가 스프링 실행 역할을 할 것이라고 알림
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //설정파일 읽어내기
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testGetList() {
		log.info("GetList---------------------------");
		service.getList().forEach(board-> log.info(board));
	}
	
	@Test
	public void testGet() { 
		log.info("GET---------------------------");
		BoardVO board = service.get(3);
		log.info(board); 
	}
	
	@Test
	public void testModify() {
	log.info("Modify---------------------------"); 
	BoardVO board = service.get(3);
	board.setContent("과제를해야한다!!!!");
	log.info("Modify result : " + service.modify(board)); 
	}
	
	@Test
	public void testRemove() { 
	log.info("Remove---------------------------");
	log.info("remove result : " + service.remove(3L)); 
	}
	
	
	

}
