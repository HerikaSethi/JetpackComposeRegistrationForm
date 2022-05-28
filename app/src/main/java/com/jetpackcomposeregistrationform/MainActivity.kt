package com.jetpackcomposeregistrationform

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // MyFirstLine()
           // StatefulExample()
            Register()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MyFirstLine(){
    Text(text = "Hello World", fontSize = 30.sp)
}

@Preview
@Composable
fun Register(){
    var firstName: String by remember{ mutableStateOf("")}
    var lastName:String by remember { mutableStateOf("")}
    var password: String by remember { mutableStateOf("")}
  LazyColumn(  //lazy for scrollable view by adding property later
      //properties of display position of whatever comes in column layout
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      contentPadding = PaddingValues(horizontal = 20.dp, vertical = 80.dp),
      verticalArrangement = Arrangement.spacedBy(20.dp)

  ){
      item { 
          OutlinedTextField(  //properties of specific text field
              value = firstName,
              label = { Text(text = "First Name")},
              placeholder = { Text(text = "Enter your first name")},
              leadingIcon = { Icon(
                                imageVector = Icons.Filled.Person , contentDescription = "" )},
              shape = RoundedCornerShape(15.dp),
              onValueChange = {
                              firstName = it
              },
          )
      }
      item {
          OutlinedTextField(
              value = lastName,
              label = { Text(text = "Last Name")},
              placeholder = { Text(text = "Enter your last name")},
              leadingIcon = { Icon(
                                imageVector = Icons.Filled.Person , contentDescription = "" )},
              shape = RoundedCornerShape(15.dp),
              onValueChange = {
                              lastName = it
              },
          )
      }
      item {
          OutlinedTextField(
              value = password,
              label = { Text(text = "Password")},
              placeholder = { Text(text = "Enter Password")},
              leadingIcon = { Icon(
                                imageVector = Icons.Filled.Done , contentDescription = "" )},
              shape = RoundedCornerShape(15.dp),
              visualTransformation = PasswordVisualTransformation('\u2022'),
              keyboardOptions = KeyboardOptions(autoCorrect = false, keyboardType = KeyboardType.Password),
              onValueChange = {
                              password = it
              },
          )
      }
      item {
          Button(
              onClick = {
                  Log.d("chk", "FirstName: $firstName LastName: $lastName Password: $password")
              },
              modifier = Modifier.padding(60.dp),
              shape = CircleShape,
              border = BorderStroke(1.dp, color = Color.Black),
          ) {
              Text(text = "Submit")
          }
      }
  }
}

//@Composable
//fun StatefulExample(){
//    var name:String by remember{ mutableStateOf("")}
//    Column {
//        OutlinedTextField(value = name , onValueChange ={ name = it
//        } )
//    }
//}

