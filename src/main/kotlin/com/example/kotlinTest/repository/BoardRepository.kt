package com.example.kotlinTest.repository

import com.example.kotlinTest.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {
}