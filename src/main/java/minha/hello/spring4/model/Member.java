package minha.hello.spring4.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {

    private String mno;
    private String userid;
    private String passwd;
    private String name;
    private String email;
    private String regdate;


}
