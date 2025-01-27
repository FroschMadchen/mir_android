package com.mir.mir.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mir.mir.R

import com.mir.mir.ui.theme.BackgroundBtn
import com.mir.mir.ui.theme.BackgroundBtnGrey



@Composable
fun CustomTextFieldOrigen(title: String,isPassword:Boolean) {
    if (isPassword){
        PasswordFieldText(title = title)
    }else{
        EmailFieldText(title = title)
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordFieldText(title: String){
    var password by rememberSaveable {
        mutableStateOf("")
    }

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.icon_visibility)
    } else {
        painterResource(id = R.drawable.icon_not_visibility)
    }
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Box(
            Modifier
                .border(
                    width = if (password != "") 0.dp else 10.dp,
                    color = if (password != "") BackgroundBtn else Color.Transparent,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(
                    color = BackgroundBtnGrey,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {

            Row(
                Modifier.padding(end = 2.dp, start = 2.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {


                TextField(

                    value = password,
                    onValueChange = { password=it
                    },
                    placeholder = { Text(text = "password") },
                    modifier = Modifier.weight(1f),
                    textStyle = MaterialTheme.typography.headlineLarge,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colorScheme.onSecondary,
                        containerColor = Color.Transparent,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = Color.Gray
                    ),

                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                            Icon(painter = icon, contentDescription = "Visibility password",Modifier.size(20.dp))

                        }
                    },
                    visualTransformation = if (passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailFieldText(title:String){
    var text by rememberSaveable {
        mutableStateOf("")
    }
    
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Box(
            Modifier
                .border(
                    width = if (text != "") 0.dp else 10.dp,
                    color = if (text != "") BackgroundBtn else Color.Transparent,
                    shape = RoundedCornerShape(15.dp)
                )
                .background(
                    color = BackgroundBtnGrey,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {

            Row(
                Modifier.padding(end = 2.dp, start = 2.dp),
                verticalAlignment = Alignment.CenterVertically,

                ) {


                TextField(

                    value = text,
                    onValueChange = { text=it
                    },
                    placeholder = { Text(text = "Введите почту") },
                    modifier = Modifier.weight(1f),
                    textStyle = MaterialTheme.typography.headlineLarge,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colorScheme.onSecondary,
                        containerColor = Color.Transparent,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = Color.Gray
                    ),

                    trailingIcon = {

                            Icon(painter = painterResource(id = R.drawable.icon_email), contentDescription = "Visibility password",Modifier.size(20.dp))

                        }

                )
            }
        }
    }
}