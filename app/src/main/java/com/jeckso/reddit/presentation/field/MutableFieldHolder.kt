package com.jeckso.reddit.presentation.field

interface MutableFieldHolder<T : Any> : FieldHolder<T> {

    fun setValue(value: T?)
}