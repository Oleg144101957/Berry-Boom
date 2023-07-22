package video.tik.ui.theme.navigation

sealed class StartScreen(val target: String) {
    object Start : StartScreen("start")
}