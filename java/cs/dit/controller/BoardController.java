package cs.dit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs.dit.domain.BoardVO;
import cs.dit.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	
	@GetMapping("/list")
	public void list(Model model) {
		List<BoardVO> list = service.getList();
		log.info("controller- list..............");
		
		model.addAttribute("list",list);
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("controller- register..............");
		int count = service.register(board);
		
		if(count == 1)
			rttr.addFlashAttribute("result", "registered");
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
	       log.info("/get");
	model.addAttribute("board", service.get(bno)); }
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify : " + board);
		
		int count = service.modify(board);
		
		if(count==1)
			rttr.addFlashAttribute("result", "modified");
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		log.info("remove : " + bno);
		
		int count = service.remove(bno);
		
		if(count==1)
			rttr.addFlashAttribute("result", "removed");
		
		return "redirect:/board/list";
	}
}
