package minha.hello.spring4.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {

    private Logger logger = LogManager.getLogger(MemberController.class);

    @RequestMapping("/member/join")
    public String join(Model m){

        logger.info("member/join 호출");

        return "member/join.tiles";
    }
    @RequestMapping("/member/login")
    public String login(Model m){

        logger.info("member/login 호출");

        return "member/login.tiles";
    }
    @RequestMapping("/member/myinfo")
    public String myinfo(Model m){

        logger.info("member/myinfo 호출");

        return "member/myinfo.tiles";
    }
}
