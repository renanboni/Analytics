package com.boni.analytics.events

import com.boni.analytics.Event

class FirstPageEvents {
    companion object {
        private const val FIRST_PAGE_BUTTON_A = "first_page_button_a"
        private const val FIRST_PAGE_BUTTON_B = "first_page_button_b"

        fun onFirstButtonClicked() = Event(FIRST_PAGE_BUTTON_A)

        fun onSecondButtonClicked() = Event(FIRST_PAGE_BUTTON_B)
    }
}