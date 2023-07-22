package video.tik.ui.theme.displays

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import video.tik.R
import video.tik.ui.theme.BerryWhite
import video.tik.ui.theme.navigation.Apple
import video.tik.ui.theme.navigation.Lemon
import video.tik.ui.theme.navigation.Playsurface
import video.tik.ui.theme.navigation.Raspberry
import video.tik.ui.theme.navigation.StrawberryScreen


@Composable
fun StartDisplay(nav: NavHostController){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    Background(nav)
}


@Composable
fun Background(nav: NavHostController){

    val customFont = FontFamily(Font(R.font.gillsansultrabold))

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "back",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        
        Image(
            painter = painterResource(id = R.drawable.raspbium),
            contentDescription = "raspberry",
            modifier = Modifier.align(
                Alignment.TopStart
            )
        )

        Image(
            painter = painterResource(id = R.drawable.blueberyllium),
            contentDescription = "apple",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 64.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.cloudberryllium),
            contentDescription = "bomb",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.currantum),
            contentDescription = "star",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 64.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.blackcurrantium),
            contentDescription = "lemon",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .alpha(0.6f)

        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(bottom = 64.dp)
        ) {
            ButtonPlay(customFont, nav)
            ButtonApple(customFont, nav)
            ButtonLemon(customFont, nav)
            ButtonStrawberry(customFont, nav)
            ButtonRaspberry(customFont, nav)

        }
    }
}


@Composable
fun ColumnScope.ButtonPlay(customFont: FontFamily, nav: NavHostController){
    Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
        Image(
            painter = painterResource(id = R.drawable.strawbium),
            contentDescription = "btn",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    nav.navigate(Playsurface.PlaySurfaceScreen.target)
                }
        )

        Text(
            text = "Play Game",
            fontFamily = customFont,
            color = BerryWhite,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}

@Composable
fun ColumnScope.ButtonApple(customFont: FontFamily, nav: NavHostController){
    Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
        Image(
            painter = painterResource(id = R.drawable.strawbium),
            contentDescription = "btn",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    nav.navigate(Apple.AppleScreen.target)
                }
        )

        Text(
            text = "Rules",
            fontFamily = customFont,
            color = BerryWhite,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}


@Composable
fun ColumnScope.ButtonLemon(customFont: FontFamily, nav: NavHostController){
    Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
        Image(
            painter = painterResource(id = R.drawable.strawbium),
            contentDescription = "btn",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    nav.navigate(Lemon.LemonScreen.target)
                }
        )

        Text(
            text = "Lemon",
            fontFamily = customFont,
            color = BerryWhite,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}


@Composable
fun ColumnScope.ButtonRaspberry(customFont: FontFamily, nav: NavHostController){
    Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
        Image(
            painter = painterResource(id = R.drawable.strawbium),
            contentDescription = "btn",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    nav.navigate(Raspberry.RaspberryScreen.target)
                }
        )

        Text(
            text = "Raspberry",
            fontFamily = customFont,
            color = BerryWhite,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}

@Composable
fun ColumnScope.ButtonStrawberry(customFont: FontFamily, nav: NavHostController){
    Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
        Image(
            painter = painterResource(id = R.drawable.strawbium),
            contentDescription = "btn",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    nav.navigate(StrawberryScreen.StrawberryScre.target)
                }
        )

        Text(
            text = "Strawberry",
            fontFamily = customFont,
            color = BerryWhite,
            modifier = Modifier.align(
                Alignment.Center
            )
        )
    }
}

