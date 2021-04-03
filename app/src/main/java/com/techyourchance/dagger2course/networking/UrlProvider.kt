package com.techyourchance.dagger2course.networking

import com.techyourchance.dagger2course.Constants

class UrlProvider {

    fun getBaseUrl(): String {
        return Constants.BASE_URL
    }

    fun getOtherBaseUrl(): String {
        return "other_base_url"
    }
}