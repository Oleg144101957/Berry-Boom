package video.tik.ui.theme.displays

import android.app.Activity
import android.content.pm.ActivityInfo
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import video.tik.R


@Composable
fun RaspberryDisplay() {

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    Box(modifier = Modifier.fillMaxSize()){
        RaspberryBackground()
        RasperryLogic()

    }

}


@Composable
fun RaspberryBackground(){
    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "raspberry back",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun BoxScope.RasperryLogic(){

    val customFont = FontFamily(Font(R.font.gillsansultrabold))
    val angle = remember {
        mutableStateOf(0f)
    }

    Image(
        painter = painterResource(id = R.drawable.raspbium),
        contentDescription = "Rasperry",
        modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 64.dp)
            .rotate(angle.value)

    )

    Slider(
        value = angle.value,
        onValueChange = { angle.value = it },
        valueRange = 0f..360f,
        modifier = Modifier
            .align(Alignment.Center)
            .padding(start = 64.dp, end = 64.dp)
    )

    Text(
        text = stringResource(id = R.string.raspberry),
        color = Color.White,
        fontFamily = customFont,
        modifier = Modifier
            .padding(16.dp)
            .align(Alignment.BottomCenter)
    )
}