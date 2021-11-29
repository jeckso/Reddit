package com.jeckso.reddit.data.network.exception

class InternalHttpException(
    val code: Int,
    override val message: String?
) : Exception()