package com.shiv.demo.ext

import java.util.regex.Pattern


fun String.isValidEmail() =
    Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+").matcher(trim()).matches()

