package minha.hello.spring4.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class BoardServiceAdvice {
    private Logger logger = LogManager.getLogger(BoardServiceAdvice.class);

    //    * 패키지.클래스.메서드(..) => *은 모든 접근제한자, (..) : 매개변수명시x 한개든 두개든 상관없다)
    @Pointcut("execution(* minha.hello.spring4.controller.BoardController.write(..))")
    public void writePoint(){}

    @Around("writePoint()")
    public Object writeAOPProcess(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("writeAOPProcess 호출");
        HttpSession sess = null;

        for (Object o:pjp.getArgs()) {
            if(o instanceof HttpSession)
                sess = (HttpSession) o;
        }

        if(sess.getAttribute("member") == null)
            return "redirect:/member/login";

        Object obj = pjp.proceed();
        return obj;
    }
}
