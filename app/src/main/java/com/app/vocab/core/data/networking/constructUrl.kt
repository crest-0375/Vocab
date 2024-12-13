package com.app.vocab.core.data.networking

import com.app.vocab.BuildConfig

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1)
        url.isEmpty() -> BuildConfig.BASE_URL
        else -> BuildConfig.BASE_URL + url
    }
}