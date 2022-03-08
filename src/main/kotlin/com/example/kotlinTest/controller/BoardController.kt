package com.example.kotlinTest.controller

import com.example.kotlinTest.entity.Board
import com.example.kotlinTest.repository.BoardRepository
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/board")
class BoardController(val boardRepository: BoardRepository) {
    @GetMapping
    fun getBoardList() = boardRepository.findAll()

    @GetMapping("/{boardId}")
    fun getBoard(@PathVariable("boardId") boardId: Long): Optional<Board>? {
        return boardRepository.findById(boardId)
    }

    @PostMapping
    fun postBoard(@RequestBody board: Board) : Board {
        return boardRepository.save(board)
    }

    @PutMapping("/{boardId}")
    fun updateBoard(@RequestBody board: Board,
                    @PathVariable("boardId") boardId: Long): Board {
        var preBoard: Board = boardRepository.findById(boardId).get()
        preBoard.title=board.title
        preBoard.description=board.description
        preBoard.writer=board.writer
        return boardRepository.save(preBoard)
    }

    @DeleteMapping("/{boardId}")
    fun deleteBoard(@PathVariable("boardId") boardId: Long) {
        boardRepository.deleteById(boardId)
    }
}