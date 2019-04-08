package com.boni.analytics

interface Tracker<in E, out C> {
    fun mapTo(event: E): C
}