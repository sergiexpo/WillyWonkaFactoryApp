package com.napptilus.willywonka.core.result

import java.io.IOException

class NoConnectivityException : IOException() {
    override val message: String = "No internet connection"
}
