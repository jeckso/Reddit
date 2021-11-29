package com.jeckso.reddit.domain.base

interface UseCase<Input, Output> {

    suspend fun execute(vararg input: Input?): Output

}