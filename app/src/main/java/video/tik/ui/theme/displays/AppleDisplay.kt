package video.tik.ui.theme.displays

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import video.tik.ui.theme.BerryWhite


@Composable
fun AppleDisplay() {

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    BackgroundApple()




}

@Composable
fun BackgroundApple(){

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "background berry",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        AppleSurface()
    }
}

@Composable
fun BoxScope.AppleSurface(){

    val customFont = FontFamily(Font(R.font.gillsansultrabold))


    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )




    Column(modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.BottomCenter))
    {

        Image(
            painter = painterResource(id = R.drawable.blueberyllium),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .rotate(angle)
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = stringResource(id = R.string.apple),
            color = Color.White,
            fontFamily = customFont,
            modifier = Modifier
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.huckleberyllium),
                contentDescription = "lemon",
                modifier = Modifier.padding(16.dp).size(64.dp)
            )

            Text(
                text = "This fruit cost 3 scores",
                color = BerryWhite,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }


        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.blueberyllium),
                contentDescription = "apple",
                modifier = Modifier.padding(16.dp).size(64.dp)

            )

            Text(
                text = "This fruit cost 2 scores",
                color = BerryWhite,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }


        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.boysenberyllium),
                contentDescription = "raspberry",
                modifier = Modifier.padding(16.dp).size(64.dp)

            )

            Text(
                text = "This fruit cost 1 scores",
                color = BerryWhite,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.mulberrilium),
                contentDescription = "bomb",
                modifier = Modifier.padding(16.dp).size(64.dp)

            )

            Text(
                text = "It will be big boom !!!",
                color = BerryWhite,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }

    }

}