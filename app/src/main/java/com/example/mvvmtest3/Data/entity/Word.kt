package com.example.mvvmtest3.Data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity
//クラス名と異なるテーブル名を指定できる
@Entity(tableName = "word_table")

//主キー
//メンバ変数と異なる列名を指定できる
class Word(@PrimaryKey
           @ColumnInfo(name = "word")
           val word: String
           )