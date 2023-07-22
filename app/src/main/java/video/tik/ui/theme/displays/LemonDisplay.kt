package video.tik.ui.theme.displays

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
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
fun LemonDisplay(){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    Box(modifier = Modifier.fillMaxSize()){
        LemonBackground()
        LemonSettings()


    }
}


@Composable
fun LemonBackground(){
    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "lemon back",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun BoxScope.LemonSettings(){

    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences(Const.SHARE, Context.MODE_PRIVATE)

    val customFont = FontFamily(Font(R.font.gillsansultrabold))

    val time = remember {
        mutableStateOf(20f)
    }

    LaunchedEffect(time.value){
        sharedPref.edit().putInt(Const.TIME, time.value.toInt()).apply()
    }


    Text(
        text = "Set your time",
        fontFamily = customFont,
        fontSize = 48.sp,
        color = BerryWhite,
        modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 64.dp)
    )

    Text(
        text = time.value.toInt().toString(),
        fontSize = 56.sp,
        color = BerryWhite,
        fontFamily = customFont,
        modifier = Modifier.align(Alignment.Center)
    )

    Slider(
        value = time.value,
        onValueChange = { time.value = it },
        valueRange = 20f..40f,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 256.dp, start = 64.dp, end = 64.dp)
    )

}