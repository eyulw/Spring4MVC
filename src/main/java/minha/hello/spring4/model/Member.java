package minha.hello.spring4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Member {

    private String mno;
    private String userid;
    private String passwd;
    private String name;
    private String email;
    private String regdate;


}
