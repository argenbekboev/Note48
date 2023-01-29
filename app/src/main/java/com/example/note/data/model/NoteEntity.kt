package com.example.note.data.model

@Entity(tableName = "notes")

class NoteEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val createdAt: Long

)