package com.napptilus.willywonka.utils

import com.napptilus.willywonka.R

private const val FEMALE = "F"
private const val MALE = "M"
private const val ALL = "All"

enum class FilterType {
    PROFESSION,
    GENDER
}

fun String.getGenderText() =
    when(this) {
        FEMALE -> R.string.female
        MALE -> R.string.male
        ALL ->R.string.all
        else -> R.string.other
    }