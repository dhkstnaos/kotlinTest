package com.example.kotlinTest.entity

import javax.persistence.*

@Entity
@Table(name="todo")
class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null
    var description: String? = null
    var writer: String?= null

}