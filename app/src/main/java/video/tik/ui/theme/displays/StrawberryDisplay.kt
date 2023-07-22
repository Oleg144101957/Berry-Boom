package video.tik.ui.theme.displays

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import video.tik.Const
import video.tik.R
import video.tik.ui.theme.BerryWhite


@Composable
fun StrawberryDisplay(){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    Box(modifier = Modifier
        .fillMaxSize()
    ){
        StrawberryBackground()
        NameAndAvatarChoose()

    }

}

@Composable
fun StrawberryBackground(){
    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "strawberry back",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxScope.NameAndAvatarChoose(){
    val customFont = FontFamily(Font(R.font.gillsansultrabold))
    val context = LocalContext.current
    val shared = context.getSharedPreferences(Const.SHARE, Context.MODE_PRIVATE)

    val matrix = ColorMatrix()
    matrix.setToSaturation(0F)

    val selectedElement = remember {
        mutableStateOf(0)
    }

    val name = remember {
        mutableStateOf(shared.getString(Const.NAME, "") ?: "")
    }


    Column(modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.TopCenter)
    ) {
        Text(
            text = "Chose your avatar and name",
            fontFamily = customFont,
            fontSize = 24.sp,
            color = BerryWhite,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 64.dp, start = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        TextField(
            value = name.value,
            onValueChange = { input ->
                name.value = input
                shared.edit().putString(Const.NAME, input).apply()
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(start = 32.dp, end = 32.dp)
        )
        

        Spacer(modifier = Modifier.height(32.dp))
        
        Row {
            Image(
                painter = painterResource(id = R.drawable.boysenberyllium),
                contentDescription = "ava1",
                colorFilter = if (selectedElement.value != 1) ColorFilter.colorMatrix(matrix) else null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .clickable {
                        selectedElement.value = 1
                        shared
                            .edit()
                            .putInt(Const.AVA, 1)
                            .apply()
                    }
            )

            Text(
                text = "This is Raspberry avatar for big and strong",
                color = BerryWhite,
                fontFamily = customFont,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }

        Row {
            Image(
                painter = painterResource(id = R.drawable.blueberyllium),
                contentDescription = "ava2",
                colorFilter = if (selectedElement.value != 2) ColorFilter.colorMatrix(matrix) else null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .clickable {
                        selectedElement.value = 2
                        shared
                            .edit()
                            .putInt(Const.AVA, 2)
                            .apply()
                    }
            )

            Text(
                text = "This is Apple avatar for clever and tall",
                color = BerryWhite,
                fontFamily = customFont,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }


        Row {
            Image(
                painter = painterResource(id = R.drawable.huckleberyllium),
                contentDescription = "ava3",
                colorFilter = if (selectedElement.value != 3) ColorFilter.colorMatrix(matrix) else null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .clickable {
                        selectedElement.value = 3
                        shared
                            .edit()
                            .putInt(Const.AVA, 3)
                            .apply()
                    }
            )

            Text(
                text = "This is Lemon avatar for small and talent",
                color = BerryWhite,
                fontFamily = customFont,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }



    }


}



