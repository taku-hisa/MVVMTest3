package com.example.mvvmtest3

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmtest3.Data.entity.Word
import com.example.mvvmtest3.Data.repository.WordRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {


    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}