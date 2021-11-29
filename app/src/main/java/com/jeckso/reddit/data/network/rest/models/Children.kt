package com.jeckso.reddit.data.network.rest.models


import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    val data: ChildrenData,
    @SerializedName("kind")
    val kind: String // t3
)