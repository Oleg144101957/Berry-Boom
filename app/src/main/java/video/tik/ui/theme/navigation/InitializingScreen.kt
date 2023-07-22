package video.tik.ui.theme.navigation

sealed class InitializingScreen(val target: String) {
    object Initializing : InitializingScreen("initializing")
}