package com.example.composedemo.screens.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R
import com.example.composedemo.screens.utils.MiscUtils.AnswerButton

object RadioButtonUtils {

    @Composable
    fun RadioButtonWithText(text: String, selected: MutableState<Boolean>) {
        Row {
            RadioButton(
                selected = selected.value,
                onClick = { selected.value = true },
                modifier = Modifier
                    .offset(x = 16.dp)
                    .padding(top = 1.dp)
            )
            Text(
                modifier = Modifier.offset(x = 18.dp),
                text = text,
                fontSize = 16.sp
            )
        }
    }

    @Composable
    fun QuizRadioButton(
        quizTitle: String, listOfAnswers: List<String>, onSuccess: () -> Unit = {}, onFail: () -> Unit = {},
    ) {
        Text(
            text = quizTitle,
            modifier = Modifier
                .offset(x = 16.dp)
                .padding(top = 20.dp, bottom = 20.dp),
            fontSize = 16.sp,
        )

        val (selectedOption, onOptionSelected) = remember { mutableStateOf(listOfAnswers[0]) }

        Column(Modifier.selectableGroup()) {
            listOfAnswers.forEach { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(x = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                    Text(
                        modifier = Modifier
                            .offset(x = 8.dp)
                            .padding(bottom = 8.dp),
                        text = text,
                        fontSize = 16.sp
                    )
                }
            }
        }

        AnswerButton(selectedOption != "Kotlin")
    }
}