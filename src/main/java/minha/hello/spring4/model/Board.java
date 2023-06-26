package minha.hello.spring4.model;

public class Board {
    private String bno;
    private String title;
    private String userid;
    private String contents;
    private String views;
    private String regdate;

    public Board(String bno, String title, String userid, String contents, String views, String regdate) {
        this.bno = bno;
        this.title = title;
        this.userid = userid;
        this.contents = contents;
        this.views = views;
        this.regdate = regdate;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno='" + bno + '\'' +
                ", title='" + title + '\'' +
                ", userid='" + userid + '\'' +
                ", contents='" + contents + '\'' +
                ", views='" + views + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
