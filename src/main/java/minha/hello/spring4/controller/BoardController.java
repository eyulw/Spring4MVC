package minha.hello.spring4.controller;

import minha.hello.spring4.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired BoardService bsrv;
    private Logger logger = LogManager.getLogger(BoardController.class);
    @GetMapping("/list")
    public String list(Model m, int cpg){
        m.addAttribute("boards",bsrv.readBoard(cpg));
//        10단위로 페이지 바꾸기
        m.addAttribute("psnum",10*((cpg-1)/10)+1);   //페이지네이션 시작번호
        m.addAttribute("allpg",bsrv.getCountPages());   //총페이지수

        logger.info("board/list 호출!");
        return "board/list.tiles";
    }

    @GetMapping("/write")
    public String write(){
        logger.info("board/write 호출!");
        return "board/write.tiles";
    }
    @GetMapping("/view")
    public String view(Model m,String bno){
        m.addAttribute("board",bsrv.readOneBoard(bno));
        logger.info("board/view 호출!");
        return "board/view.tiles";
    }
}
