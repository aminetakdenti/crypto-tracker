package com.plcoding.cryptotracker.core.domain.util

enum class NetworkError: Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERENT,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN,
}