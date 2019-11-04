package com.generalbytes.myapplication.vm

import com.generalbytes.myapplication.di.First
import com.generalbytes.myapplication.di.Second
import javax.inject.Inject


class ActivityViewModel @Inject constructor(
    @First val firstNumber: Integer,
    @Second val secondNumber: Integer
) {
}