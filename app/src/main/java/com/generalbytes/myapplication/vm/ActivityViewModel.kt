package com.generalbytes.myapplication.vm

import com.generalbytes.myapplication.model.First
import com.generalbytes.myapplication.model.Second
import com.generalbytes.myapplication.model.Third
import javax.inject.Inject


class ActivityViewModel @Inject constructor(
    val firstNumber: First,
    val secondNumber: Second,
    val thirdNumber: Third
)