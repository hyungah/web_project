package cs.dit.mapper;

import java.util.List;

import cs.dit.domain.BoardVO;

public interface BoardMapper {
	
	//select
	public List<BoardVO> getList();
	
	//selectOne
	public BoardVO selectOne(long bno);
	
	//insert
	public int insert(BoardVO vo);
	
	//update
	public int update(BoardVO vo);
	
	//delete
	public int delete(long bno);
	
	
}
