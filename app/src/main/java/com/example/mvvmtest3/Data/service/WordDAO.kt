package com.example.mvvmtest3.Data.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmtest3.Data.entity.Word
import kotlinx.coroutines.flow.Flow

//DAO
//インターフェースまたは抽象クラスにする必要がある
@Dao
interface WordDao {

    //すべての単語をアルファベット順に並べ替え
    //Flowはデータベース変更の監視を行います。
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    //単語の挿入(suspend関数)
    //既にリストに存在する単語とまったく同じ場合、onConflictStrategyは新しい単語を無視します。
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    //すべての単語を削除する(suspend関数)
    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}