package video.tik.ui.theme.navigation

sealed class Raspberry(val target: String) {
    object RaspberryScreen : Raspberry("raspberry")
}