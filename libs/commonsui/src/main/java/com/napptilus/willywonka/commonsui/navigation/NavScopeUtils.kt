package com.napptilus.willywonka.commonsui.navigation

import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope


inline fun <reified T : Any> Scope.getWith(vararg parameters: Any?): T {
    return get(T::class, null) { parametersOf(*parameters) }
}


