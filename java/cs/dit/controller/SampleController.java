package cs.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs.dit.domain.SampleDto;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j   
public class SampleController {
   
   @GetMapping("basic")
   public void basic() {
      log.info("basic...............");
   }
   
   @GetMapping("/ex01")
   public String ex01() {
      log.info("ex01...............");
      
      return "redirect:/";
   }
   
   @GetMapping("/ex03")
   public String ex03(@RequestParam("id") String name) {
      log.info("ex03...............");
      log.info("name:"+name);
      
      return "/sample/ex03";
      //가져올때 param.id로 가져와야 보이는 requestParam 그냥 ${id}는 화면에 안나옴
   }
   
   @GetMapping("/ex04")
   public String ex04(@ModelAttribute("id") String name) {
      log.info("ex04...............");
      log.info("name:"+name);
      
      return "/sample/ex04";
      //RequestParam과 다르게 그냥 ${id}해도 나오는 부분
   }
   @GetMapping("/ex06")
   public String ex06(SampleDto dto) {
      log.info("ex06...............");
      log.info("name:"+dto.getName());
      log.info("age:"+dto.getAge());
      
      return "/sample/ex06";
      //RequestParam과 다르게 그냥 ${id}해도 나오는 부분
   }   
   
}