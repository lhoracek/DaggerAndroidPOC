package com.generalbytes.myapplication.vm

import androidx.lifecycle.ViewModel
import com.generalbytes.myapplication.model.*
import javax.inject.Inject


class FragmentViewModel @Inject constructor(
    val firstNumber: First,
    val secondNumber: Second,
    val thirdNumber: Third,
    val fourthNumber: Fourth,
    val fifthNumber: Fifth,
    val sixthNumber: Fifth
): ViewModel()