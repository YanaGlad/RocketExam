package com.example.composedemo.screens.compose.algebra

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composedemo.Navigation
import com.example.composedemo.Navigation.ALGEBRA_MENU
import com.example.composedemo.Navigation.RING_MODULES
import com.example.composedemo.screens.utils.BasicNextButton
import com.example.composedemo.screens.utils.QuizCheckBox
import com.example.composedemo.screens.utils.QuizRadioButton

/*
 * @author Yana Glad
 */
@Composable
fun RingDescribeScreenQuiz(navController: NavController) {

    BackHandler {
        navController.navigate(ALGEBRA_MENU)
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {
        val countCorrect = remember { mutableStateOf(0) }
        val answered = remember { mutableStateOf(0) }

        Text(
            text = " Теперь пройди короткий тест на знание базовых понятий о кольцах",
            modifier = Modifier.offset(y = 16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )

        QuizCheckBox(
            quizTitle = "1) Что включает в себя понятие кольца?",
            countCheckBox = 5,
            listOfNames = listOf("Операция сложения +", "Нейтральный элемент",
                "Операция вычитания -", "Обратимый элемент", "Операция умножения *"),
            correctIndexes = listOf(0, 1, 4),
            onSuccess = { countCorrect.value++ },
            onFinally = { answered.value++ }
        )

        val answer2 = "Такой элемент a, что ab = ba = 1"
        QuizRadioButton(
            quizTitle = "2) Что такое обратимый элемент?",
            listOfAnswers = listOf(
                answer2,
                "Такой элемент а, что ab = ba != 1",
                "Такой элемент а, что ab = ba = -1",
                "Такой элемент а, что ab = ba = 0"),
            condition = answer2,
            onSuccess = { countCorrect.value++ },
            onFinally = { answered.value++ },
        )

        val answer1 = "Операция умножения коммутативна"
        QuizRadioButton(
            quizTitle = "3) Когда кольцо называется коммутативным?",
            listOfAnswers = listOf(
                "Операция сложения коммутативна",
                "Операции сложения и умножения коммутативны",
                answer1,
                "Если есть такой элемент а, что ab = ba = 1"),
            condition = answer1,
            onSuccess = { countCorrect.value++ },
            onFinally = { answered.value++ },
        )

        if (answered.value == 3) {
            BasicNextButton(
                navController = navController,
                destination = "${Navigation.RESULT_ONBOARDING}/${answered.value}/${countCorrect.value}/${RING_MODULES}",
                padding = 20
            )
        }
    }
}
