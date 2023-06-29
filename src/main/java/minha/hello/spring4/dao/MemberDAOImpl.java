package minha.hello.spring4.dao;

import minha.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{

    //sql.properties에 작성한 sql 불러오기
    //@Value : 값이 넘어감
    @Value("#{sql['insertMember']}") private String insertSQL;
    @Value("#{sql['loginMember']}") private String loginSQL;
    @Value("#{sql['selectOneMember']}") private String selectOneSQL;

    //@Autowired : 객체가 넘어감
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertMember(Member m) {
        //매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(),
                m.getPasswd(),
                m.getName(),
                m.getEmail()
        };

        //쿼리 실행 : update(sql문, 매개변수)
        return jdbcTemplate.update(insertSQL,params);
    }

    public Member loginMember(Member m) {
        //매개변수 정의
        Object[] params = new Object[]{
                m.getUserid(),
                m.getPasswd(),
        };

        //로그인 매퍼 선언 - 콜백함수 (이벤트 발생시 처리)
        RowMapper<Member> mapper = new LoginMapper();

        //쿼리 실행 : query(sql문, 매개변수,매퍼) - 단일값 반환
        m = jdbcTemplate.queryForObject(loginSQL,params,mapper);
        return m;
    }

    private class LoginMapper implements RowMapper<Member> {
//        rs객체가 있다면 Member 객체 만들고 값 넣기
        @Override
        public Member mapRow(ResultSet rs, int num) throws SQLException {
            Member m = new Member();
            m.setUserid(rs.getString(1));
            m.setName(rs.getString(2));
            return m;
        }
    }

    public Member selectOneMember(String userid){
        Object[] params = new Object[]{
                userid
        };

        RowMapper<Member> mapper = new MemberMapper();

        return jdbcTemplate.queryForObject(selectOneSQL,params,mapper);

    }

    private class MemberMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int num) throws SQLException {
            Member m = new Member(
                    rs.getString(1),
                    rs.getString(2),
                    null,
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
            );
            return m;
        }
    }
}
