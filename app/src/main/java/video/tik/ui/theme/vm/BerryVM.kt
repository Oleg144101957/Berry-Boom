package video.tik.ui.theme.vm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import video.tik.R
import video.tik.dom.Berry
import video.tik.dom.BerryDescription

class BerryVM : ViewModel() {

    val scores = MutableStateFlow(0)
    val boom = MutableStateFlow(false)

    val berryListOfStates = MutableStateFlow(
        listOf(
            Berry(toDisplay = R.drawable.huckleberyllium, berryDescription = BerryDescription(0, "lemon"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.mulberrilium, berryDescription = BerryDescription(1, "bomb"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.boysenberyllium, berryDescription = BerryDescription(2, "raspberry"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.blueberyllium, berryDescription = BerryDescription(3, "apple"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.mulberrilium, berryDescription = BerryDescription(4, "bomb"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.boysenberyllium, berryDescription = BerryDescription(5, "bomb"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.boysenberyllium, berryDescription = BerryDescription(6, "raspberry2"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.huckleberyllium, berryDescription = BerryDescription(7, "strawberry"), isShow = false, isDetonate = false),
            Berry(toDisplay = R.drawable.mulberrilium, berryDescription = BerryDescription(8, "bomb"), isShow = false, isDetonate = false)
        )
    )

    fun shuffleList(){
        val newShuffledList = berryListOfStates.value.shuffled()
        berryListOfStates.value = newShuffledList
    }

    suspend fun showBeforeStart(){
        val newOpenList = berryListOfStates.value.map { it.copy(isShow = true) }
        berryListOfStates.value = newOpenList
        delay(1200)
        val newHiddenList = berryListOfStates.value.map { it.copy(isShow = false) }
        berryListOfStates.value = newHiddenList
    }

    fun changeVisibility(berryNumber: Int){
        val newList = berryListOfStates.value.toMutableList()

        if (berryListOfStates.value[berryNumber].toDisplay == R.drawable.mulberrilium){
            val newElement = newList[berryNumber].copy(isShow = true, isDetonate = true)
            newList[berryNumber] = newElement
            berryListOfStates.value = newList
            boom.value = true


        } else {
            val newElement = newList[berryNumber].copy(isShow = true)
            newList[berryNumber] = newElement
            berryListOfStates.value = newList
        }

        val scoreToIncrease = when(berryListOfStates.value[berryNumber].toDisplay){
            R.drawable.huckleberyllium -> 3
            R.drawable.blueberyllium -> 2
            R.drawable.boysenberyllium -> 1
            else -> 0
        }

        increaseScores(scoreToIncrease)
    }

    fun increaseScores(scoreToAdd: Int){
        val currentScore = scores.value+scoreToAdd
        scores.value = currentScore
    }

}