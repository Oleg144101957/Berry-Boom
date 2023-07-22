package video.tik.ui.theme.navigation

sealed class Playsurface(val target: String){
    object PlaySurfaceScreen: Playsurface("playsurface")
}
