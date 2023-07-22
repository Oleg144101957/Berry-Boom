package video.tik.ui.theme.displays

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import video.tik.Const
import video.tik.R
import video.tik.ui.theme.BerryWhite
import video.tik.ui.theme.vm.BerryVM


@Composable
fun PlayDisplay(nav: NavHostController, berryVM: BerryVM){

    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    val boom = remember {
        mutableStateOf(false)
    }

    val scores = berryVM.scores.collectAsState()


    Box(modifier = Modifier.fillMaxSize()){
        Background()
        ScoreBlock(scores.value)
        PlayGroundBlock(berryVM)

        if (boom.value){



            Image(
                painter = painterResource(id = R.drawable.cloudberryllium),
                contentDescription = "boom",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(0.dp)
            )
        }





    }
}

@Composable
fun Background(){
    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "background berry",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun BoxScope.ScoreBlock(score: Int){
    Box(modifier = Modifier
        .align(Alignment.TopCenter)
    ){

        val customFont = FontFamily(Font(R.font.gillsansultrabold))

        Image(
            painter = painterResource(id = R.drawable.cranbium),
            contentDescription = ""
        )

        Text(
            text = "Score $score",
            modifier = Modifier
                .align(Alignment.Center),
            color = Color.White,
            fontFamily = customFont,
            fontSize = 24.sp
        )
    }
}


@Composable
fun BoxScope.PlayGroundBlock(berryVM: BerryVM){

    val berrysState = berryVM.berryListOfStates.collectAsState()
    val context = LocalContext.current
    val shared = context.getSharedPreferences(Const.SHARE, Context.MODE_PRIVATE)

    LaunchedEffect(Unit){
        berryVM.shuffleList()
        delay(1000)
        berryVM.showBeforeStart()
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.Center)
    ) {
        Row(modifier = Modifier
            .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = if (berrysState.value[0].isShow) berrysState.value[0].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(0)
                    }

            )

            Image(
                painter = painterResource(id = if (berrysState.value[1].isShow) berrysState.value[1].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(1)
                    }

            )

            Image(
                painter = painterResource(id = if (berrysState.value[2].isShow) berrysState.value[2].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(2)
                    }

            )

        }

        Row(modifier = Modifier
            .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = if (berrysState.value[3].isShow) berrysState.value[3].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(3)
                    }

            )

            Image(
                painter = painterResource(id = if (berrysState.value[4].isShow) berrysState.value[4].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(4)
                    }

            )

            Image(
                painter = painterResource(id = if (berrysState.value[5].isShow) berrysState.value[5].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(5)
                    }

            )

        }

        Row(modifier = Modifier
            .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = if (berrysState.value[6].isShow) berrysState.value[6].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(6)
                    }

            )

            Image(
                painter = painterResource(id = if (berrysState.value[7].isShow) berrysState.value[7].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(7)
                    }

            )

            Image(
                painter = painterResource(id = if (berrysState.value[8].isShow) berrysState.value[8].toDisplay else R.drawable.elderbium),
                contentDescription = "byte",
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
                    .clickable {
                        berryVM.changeVisibility(8)
                    }
            )
        }
    }


    Row(modifier = Modifier
        .align(Alignment.BottomCenter)
        .fillMaxWidth()
    ) {

        val avaImage = when(shared.getInt(Const.AVA, 1)){
            1 -> R.drawable.boysenberyllium
            2 -> R.drawable.blueberyllium
            3 -> R.drawable.huckleberyllium
            else -> R.drawable.boysenberyllium
        }

        Image(
            painter = painterResource(id = avaImage),
            contentDescription = "avatar",
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
                .align(Alignment.CenterVertically)
        )


        val customFont = FontFamily(Font(R.font.gillsansultrabold))
        val name = shared.getString(Const.NAME, "Best User") ?: "Best User"

        Text(
            text = "Hello $name you have 0 second's to open all elements",
            fontFamily = customFont,
            color = BerryWhite,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
}
