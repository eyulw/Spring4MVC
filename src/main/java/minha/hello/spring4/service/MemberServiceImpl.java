package minha.hello.spring4.service;

import minha.hello.spring4.dao.MemberDAO;
import minha.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("msrv")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberDAO mdao;

    @Override
    public boolean saveMember(Member m) {
        boolean isSaved=false;
        if(mdao.insertMember(m)>0) isSaved=true;
        return isSaved;
    }
}
