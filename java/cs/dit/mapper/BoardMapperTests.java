package cs.dit.mapper;

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

public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	//list
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	//insert
	@Test
	public void testinsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Hi!!!");
		vo.setContent("반갑습니다!!!");
		vo.setWriter("김민석");
		
		mapper.insert(vo);
		
	}
	
	//selectOne
	@Test
	public void testGetOneList() {
		log.info("selectOne-------");
		BoardVO board = mapper.selectOne(1);
		log.info(board);
	}
	//update
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO(); board.setBno(1);
		board.setTitle("수정 제목");
		board.setContent("수정 내용");
		board.setWriter("작성자 수정");
		log.info("test-Update ----------------");
		int count = mapper.update(board);
		log.info("update count" + count);
	}
	//delete
	@Test
	public void testDelete() {
		log.info("Delete"+mapper.delete(2));
	}
}
