package com.example.counterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel( ) : ViewModel() {
    private val repo: CounterRepository= CounterRepository()

    private val _count =    mutableStateOf(repo.get().count)

    val count: MutableState<Int> = _count

    fun increment() {
        repo.increment()
        _count.value=repo.get().count
    }

    fun decrement() {
        repo.decrement()
        _count.value=repo.get().count}
}
