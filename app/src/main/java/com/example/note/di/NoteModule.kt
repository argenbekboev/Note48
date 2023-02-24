package com.example.note.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.note.data.local.NoteDao
import com.example.note.data.local.NoteDataBase
import com.example.note.data.repository.NoteRepositoryImpl
import com.example.note.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDataBase(@ApplicationContext context: Context): NoteDataBase {
        return Room.databaseBuilder(context,
            NoteDataBase::class.java,
            "note_db").allowMainThreadQueries().build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository = NoteRepositoryImpl(noteDao)
}