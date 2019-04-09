package com.boni.analytics

interface Mapper<in E, out C> {
    fun mapFrom(event: E): C
}