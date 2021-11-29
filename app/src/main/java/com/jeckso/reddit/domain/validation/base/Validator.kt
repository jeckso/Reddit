package com.jeckso.reddit.domain.validation.base

interface Validator<T> {

    @Throws(Exception::class)
    suspend fun validate(input: T)
}