package com.example.core

class Logger(
    private val tag: String,
    private val isDebug: Boolean = true
) {

    fun log(msg: String) {
        if (!isDebug) {
            // Log to Crashlatics or What ever software
        } else {
            printLogd(tag, msg)
        }
    }

    companion object Factory{
        fun buildDebug(tag: String): Logger {
            return Logger(
                tag = tag,
                isDebug = true
            )
        }

        fun buildRelease(tag: String): Logger {
            return Logger(
                tag = tag,
                isDebug = false
            )
        }
    }

}

fun printLogd(tag: String?, msg: String) {
    println("$tag: $msg")
}