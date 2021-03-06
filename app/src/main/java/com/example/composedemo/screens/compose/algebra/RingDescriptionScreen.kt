package com.example.composedemo.screens.compose.algebra

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composedemo.Navigation.RING_DESCRIPTION_QUIZ
import com.example.composedemo.R
import com.example.composedemo.screens.utils.BasicNextButton

/*
 * @author Yana Glad
 */
@Composable
fun RingDescribeScreenFirst(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            modifier = Modifier.offset(y = 16.dp),
            text = "Кольца, модули алгебры, категории",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Кольцо R - это абелева группа (Т.е. включает операцию сложения " +
                    "+ и нейтральный элемент 0), в которой так же определен вторая операция - умножение",
            modifier = Modifier
                .offset(y = 16.dp, x = 8.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = "Кольцо ассоциативно, если операция умножения ассоциативна a(bc) = (ab)c",
            modifier = Modifier
                .offset(y = 16.dp, x = 8.dp)
                .padding(end = 8.dp)
        )
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.algebra),
            contentDescription = "Примеры колец",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .offset(y = 25.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.offset(y = 30.dp),
            text = "Коммутативное кольцо",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(R.string.commutate_ring_description),
            modifier = Modifier
                .offset(y = 30.dp, x = 8.dp)
                .padding(end = 8.dp)
        )

        Text(
            modifier = Modifier.offset(y = 30.dp),
            text = "Обратимые элементы",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(R.string.netural_element) + "\n",
            modifier = Modifier
                .offset(y = 35.dp, x = 8.dp)
                .padding(end = 8.dp)
        )

        Text(
            text = "Множество обратимых элементов обычно обозначается К* \n",
            modifier = Modifier
                .offset(y = 35.dp, x = 8.dp)
                .padding(end = 8.dp)
        )

        Text(
            text = stringResource(R.string.ring_with_1),
            modifier = Modifier
                .offset(y = 35.dp, x = 8.dp)
                .padding(end = 8.dp)
        )

        BasicNextButton(navController, RING_DESCRIPTION_QUIZ)
    }
}
