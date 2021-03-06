package com.example.kotlinTest.entity

import javax.persistence.*
import java.io.Serializable

@Entity
@Table(name = "board")
class Board : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String? = null
    var description: String? = null
    var writer: String? = null
}