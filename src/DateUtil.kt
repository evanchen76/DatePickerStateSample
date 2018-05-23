import java.text.SimpleDateFormat
import java.util.*

fun createDate(time: String): Date {
    return SimpleDateFormat("yyyy-MM-dd", Locale.TAIWAN)
            .apply { timeZone = TimeZone.getTimeZone("GMT+08:00") }
            .parse(time)
}

fun toSimpleString(date: Date?) : String {
    return when {
        date != null -> {
            val format = SimpleDateFormat("yyyy-MM-dd").apply {
                timeZone = TimeZone.getTimeZone("GMT+08:00")
            }
            format.format(date)
        }
        else -> "null"
    }
}