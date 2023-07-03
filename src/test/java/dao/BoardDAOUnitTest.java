package dao;

import minha.hello.spring4.dao.BoardDAO;
import minha.hello.spring4.model.Board;
import minha.hello.spring4.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml" ,
                    "classpath:spring/root-context.xml"})
@WebAppConfiguration
public class BoardDAOUnitTest {

    @Autowired
    BoardDAO bdao;

    @Test
    public void selectBoard() throws Exception{
        int cpage=3;
        int snum=15*(cpage-1);
        List<Board> results=bdao.selectBoard(snum);
        assertEquals(results.size(),15);
        System.out.println(results);
    }
    @Test
    public void countPages() throws Exception{
        int result=bdao.countPages();
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    public void selectOneBoard() throws Exception{
        String bno = "450";
        Board result=bdao.selectOneBoard(bno);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    @Transactional  // 데이터 입력후 자동삭제
    public void insertBoard() throws Exception{
        Board bd = new Board(null,"새글","abc123","테스트",null,null);
//        assertEquals(테스트메서드, 검증값)
        assertEquals(bdao.insertBoard(bd),1);
    }
}
