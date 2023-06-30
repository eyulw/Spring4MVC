package minha.hello.spring4.dao;

import minha.hello.spring4.model.Board;

import java.util.List;

public interface BoardDAO {
    List<Board> selectBoard(int snum);
    int countPages();
}
