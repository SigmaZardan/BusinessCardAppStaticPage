package com.bibek.businesscardapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bibek.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp();

                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,

                modifier = Modifier.background(Color(40,82,91))

    ) {
        Column(
            modifier = Modifier.padding(top = 170.dp)
        ) {
            ImageWithText(stringResource(R.string.applicant_name),stringResource(R.string.applicant_occupation))

        }

        Column(
            modifier = Modifier.padding(top = 140.dp)
        ) {
            IconTextGroup()

        }






    }

}

@Composable
fun ImageWithText(name : String , occupation : String) {

 val androidImage = painterResource(R.drawable.android_logo)

    Column(
       horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center ,
        modifier = Modifier.background(Color(40,83,91))

    ){

        Image(painter = androidImage,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Text(text = name,
            fontSize = 55.sp,
            color = Color.White

        )
        Text(text = occupation,
        fontSize = 20.sp,
            color = Color(0xFF3ddc84)
        )
    }
}



@Composable
fun IconTextGroup(){
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .padding(top = 0.5.dp)

    ) {

        LineCompose(id = R.drawable.phone, text = "9814177147 " )
        LineCompose(id = R.drawable.share,text="@Android Dev")
        LineCompose(id = R.drawable.message,text = "bibekbhujel977@gmail")






    }

}


@Composable
fun LineCompose( id : Int , text : String){
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .padding(top = 2.dp)
    ) {
        IconTextComposable(id = id,text = text)
    }

}

@Composable
fun IconTextComposable( id : Int, text:String){
    val icon = painterResource(id = id )
    Row(
        verticalAlignment = Alignment.CenterVertically,



        modifier = Modifier
            .background(Color(40,83,91))
            .fillMaxWidth()


    )
        {
            Icon(painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(47.dp)
                    .padding(top = 10.dp, bottom = 10.dp, start = 20.dp)

            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 60.dp)

            ) {



                  Text( text = text,
                      fontSize =  23.sp,
                      color = Color.White,
                      modifier = Modifier.padding(start = 18.dp))




                }





    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {

    }
}