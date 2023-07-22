package video.tik.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import video.tik.ui.theme.displays.AppleDisplay
import video.tik.ui.theme.displays.InitDisplay
import video.tik.ui.theme.displays.LemonDisplay
import video.tik.ui.theme.displays.PlayDisplay
import video.tik.ui.theme.displays.RaspberryDisplay
import video.tik.ui.theme.displays.StartDisplay
import video.tik.ui.theme.displays.StrawberryDisplay
import video.tik.ui.theme.vm.BerryVM


@Composable
fun Navigation() {

    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = InitializingScreen.Initializing.target){

        composable(route = InitializingScreen.Initializing.target){
            InitDisplay(nav)
        }

        composable(route = StartScreen.Start.target){
            StartDisplay(nav)
        }

        composable(route = Playsurface.PlaySurfaceScreen.target){
            val berryViewModel : BerryVM = viewModel()
            PlayDisplay(nav = nav, berryVM = berryViewModel)
        }

        composable(route = Lemon.LemonScreen.target){
            LemonDisplay()
        }

        composable(route = Raspberry.RaspberryScreen.target){
            RaspberryDisplay()
        }

        composable(route = StrawberryScreen.StrawberryScre.target){
            StrawberryDisplay()
        }

        composable(route = Apple.AppleScreen.target){
            AppleDisplay()
        }
    }
}