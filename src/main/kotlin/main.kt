fun main() {
    val lastActivitySec = 60+1
    print(agoToText(lastActivitySec))
}

fun agoToText(lastActivitySec: Int): String? {

    val msg1 = when (lastActivitySec) {
        in 0..60 -> "только что"
        // от минуты до часа
        in 61 until 60 * 60 -> generateMsg(lastActivitySec / 60, "минут")
        // от часа до суток
        in (60 * 60 )..(24 * 60 * 60) -> generateMsg(lastActivitySec / 60 / 60, "часы")
        // от суток до двух
        in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> "был(а) в сети вчера"
        // от двух до трех суток
        in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> "был(а) в сети позавчера"
        // больше трех суток
        else -> "Давно"
    }
    return msg1
}

fun generateMsg(temp: Int, time: String): String? {
    var timeIndicator = time
    timeIndicator = when {
        temp in 2..4 -> if (time == "минут") "минуты" else "часа"
        temp in 5..20 -> if (time == "минут") "минут" else "часов"
        temp % 10 in 2..4 -> if (time == "минут") "минуты" else "часа"
        temp % 10 == 1 -> if (time == "минут") "минуту" else "час"
        else -> timeIndicator
    }
    return "был(а) в сети $temp $timeIndicator назад"
}

