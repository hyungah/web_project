package cs.dit.service;

import java.util.List;

import cs.dit.domain.BoardVO;

public interface BoardService {
	public List<BoardVO> getList();
	
	public BoardVO get(long bno);
	
	public int register(BoardVO board);
	
	public int modify(BoardVO board);
	
	public int remove(long bno);
	
	
}
