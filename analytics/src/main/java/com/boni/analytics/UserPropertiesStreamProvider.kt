package com.boni.analytics

import io.reactivex.subjects.PublishSubject

interface UserPropertiesStreamProvider {
    val userPropertyStream: PublishSubject<UserProperty>
}