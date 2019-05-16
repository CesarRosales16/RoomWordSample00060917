package com.example.roomwordsample.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomwordsample.data.models.Word

@Dao
interface WordDao {

    //@Insert(onConflict = OnConflictStrategy.REPLACE): por si se da algun conflicto
    //Se usa en entidades con mas de una columna
    @Insert
    suspend fun insert(word: Word)

    //se pone @Query y no @Delete porque no se recomienda usar esa anotacion al borrar multiples entidades
    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

}
