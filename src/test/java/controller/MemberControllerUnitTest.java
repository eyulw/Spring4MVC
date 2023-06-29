package controller;

import minha.hello.spring4.controller.MemberController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml" ,
        "classpath:spring/root-context.xml"})
@WebAppConfiguration
public class MemberControllerUnitTest {
    @Autowired
    WebApplicationContext wctx;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
//        controller,service,dao 유기적으로 작동해서 standalone이 아니라 webapp~로 해야됨
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wctx).build();
    }
    @Test
    public void joinTest() throws Exception {
        mockMvc.perform(get("/member/join"))
                .andExpect(status().isOk())
                .andExpect(view().name("member/join.tiles"));
    }

    @Test
    @Transactional
    public void joinOkTest() throws Exception {
        mockMvc.perform(post("/member/join")
                        .param("userid","abc123a")
                        .param("passwd","987xyz")
                        .param("name","abc123")
                        .param("email","abc123@987xyz.co.kr"))
                .andExpect(redirectedUrl("/member/login"));
    }
}
