package com.example.mvvmtest3.Data.service

import android.app.Application
import com.example.mvvmtest3.Data.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    //val database by lazy { WordRoomDatabase.getDatabase(this) }
    //val repository by lazy { WordRepository(database.wordDao()) }
    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}