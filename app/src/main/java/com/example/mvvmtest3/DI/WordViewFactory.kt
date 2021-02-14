package com.example.mvvmtest3.DI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest3.Data.repository.WordRepository
import com.example.mvvmtest3.WordViewModel

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}