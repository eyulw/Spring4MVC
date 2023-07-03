package minha.hello.spring4.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private String bno;
    private String title;
    private String userid;
    private String contents;
    private String views;
    private String regdate;
}
