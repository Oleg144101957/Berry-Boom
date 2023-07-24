package video.tik.ui.theme.displays

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import video.tik.ui.theme.BerryBlack
import video.tik.ui.theme.BerryWhite
import video.tik.ui.theme.BerryWhiteWhite
import video.tik.ui.theme.navigation.StartScreen
import video.tik.ui.theme.vm.BerryVM


@Composable
fun PlayDisplay(nav: NavHostController, berryVM: BerryVM){

    val customFont = FontFamily(Font(R.font.gillsansultrabold))
    val a = LocalContext.current as Activity
    a.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    val boom = berryVM.boom.collectAsState()
    val scores = berryVM.scores.collectAsState()
    val bombSize = remember {
        Animatable(0f)
    }

    LaunchedEffect(boom.value){
        if (boom.value){
            bombSize.animateTo(
                targetValue = 2000f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1000,
                        easing = FastOutLinearInEasing
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
    }


    Box(modifier = Modifier.fillMaxSize()){
        Background()
        ScoreBlock(scores.value)
        PlayGroundBlock(berryVM, nav)

        if (boom.value){
            Box(modifier = Modifier
                .fillMaxSize()
                .background(BerryBlack)
            ){

                Text(
                    text = "Game Over",
                    color = BerryWhiteWhite,
                    fontFamily = customFont,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 16.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.cloudberryllium),
                    contentDescription = "boom",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(bombSize.value.dp)
                )

                Text(
                    text = "Boom !",
                    color = Color.Yellow,
                    fontFamily = customFont,
                    fontSize = 56.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                Image(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "close",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp)
                        .clickable {
                            nav.navigate(StartScreen.Start.target)
                        }
                )
            }
        }


    }
}

@Composable
fun Background(){
    Image(
        painter = painterResource(id = R.drawable.bg),
        contentDescription = "background berry",
        modifier = Modifier
            .fillMaxSize(),
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


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BoxScope.PlayGroundBlock(berryVM: BerryVM, nav: NavHostController){


    val customFont = FontFamily(Font(R.font.gillsansultrabold))
    val berrysState = berryVM.berryListOfStates.collectAsState()
    val context = LocalContext.current
    val shared = context.getSharedPreferences(Const.SHARE, Context.MODE_PRIVATE)
    val timer = remember {
        mutableStateOf(shared.getInt(Const.TIME, 20))
    }

    LaunchedEffect(key1 = "timer"){
        while (timer.value != 0){
            delay(1000)
            timer.value -= 1
        }
    }

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
            text = "Hello $name you have ${timer.value} second's to open all elements",
            fontFamily = customFont,
            color = BerryWhite,
            modifier = Modifier
                .align(Alignment.CenterVertically)
        )
    }
    
    
    if (timer.value == 0){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(BerryBlack)){

            val currentTime = shared.getInt(Const.TIME, 20)
            val newTime = currentTime - 5
            shared.edit().putInt(Const.TIME, newTime).apply()

            Text(
                text = "The time is Up, next time you'll have only $newTime seconds",
                fontFamily = customFont,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )

            Text(
                text = "Your score is ${berryVM.scores.value}",
                fontFamily = customFont,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = 64.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "close",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
                    .clickable {
                        nav.navigate(StartScreen.Start.target)
                    }
            )
        }
    }
}
