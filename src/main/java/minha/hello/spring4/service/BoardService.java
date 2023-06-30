package minha.hello.spring4.service;

import minha.hello.spring4.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> readBoard(int cpg);
    int getCountPages();
}
