package ui.smartpro.mirafox.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun asTimeSchedule(d1: LocalDateTime): String {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        return d1.format(formatter)
    } else {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("HH:mm")
        return formatter.format(parser.parse(d1.toString()))
    }
}

fun asTimeScheduleApi(d1: String): String {
    val parser = SimpleDateFormat("yyyy.MM.dd HH:mm")
    val formatter = SimpleDateFormat("HH:mm")
    return formatter.format(parser.parse(d1))
}

fun asCustomDate(d1: LocalDateTime): String {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("dd.MM")
        return d1.format(formatter)
    } else {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("dd.MM")
        return formatter.format(parser.parse(d1.toString()))
    }
}

fun asCustomDateApi(d1: String): String {
    val parser = SimpleDateFormat("yyyy.MM.dd HH:mm")
    val formatter = SimpleDateFormat("dd.MM")
    return formatter.format(parser.parse(d1))
}

fun asDate(d1: LocalDateTime): String {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yy")
        return d1.format(formatter)
    } else {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val formatter = SimpleDateFormat("dd.MM.yy")
        return formatter.format(parser.parse(d1.toString()))
    }
}

fun asDateApi(d1: String): String {
    val parser = SimpleDateFormat("yyyy.MM.dd HH:mm")
    val formatter = SimpleDateFormat("dd.MM.yy")
    return formatter.format(parser.parse(d1))
}

@RequiresApi(Build.VERSION_CODES.O)
fun dateConverter(data: String): LocalDateTime {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.getDefault())
    return LocalDateTime.parse(data, formatter)
}

@RequiresApi(Build.VERSION_CODES.O)
fun getDuration(d1: LocalDateTime, d2: LocalDateTime): String {
    var diff: Duration = Duration.between(d1, d2)

    val days: Long = diff.toDays()
    diff = diff.minusDays(days)

    val hours: Long = diff.toHours()
    diff = diff.minusHours(hours)

    var formattedDiff = ""
    if (hours != 0L && days == 0L) {
        if (hours <= 4L) {
            formattedDiff = asTimeSchedule(d1)
        } else if (hours > 4L) {
            formattedDiff = "Сегодня"
        }
    }

    if (days != 0L) {
        if (days <= 1L && d2.year == d1.year) {
            formattedDiff = "Вчера"
        } else if (days in 2..365 && d2.year == d1.year) {
            formattedDiff = asCustomDate(d1)
        } else if (d2.year != d1.year) {
            formattedDiff = asDate(d1)
        }
    }
    return formattedDiff
}

fun asLocalDate(): String {
    val time = Date()
    val timeFormat = SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault())
    return timeFormat.format(time)
}

fun dateConverterApi(data: String): String {
    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm")
    val formatter = SimpleDateFormat("yyyy.MM.dd HH:mm")
    return formatter.format(parser.parse(data))
}

fun asSchedule(data: String, formatA: String, formatB: String): String {
    val parser = SimpleDateFormat(formatA)
    val formatter = SimpleDateFormat(formatB)
    return formatter.format(parser.parse(data))
}

fun getDurationApi(d1: String, d2: String): String {

    val days1: String = asSchedule(d1, "yyyy.MM.dd HH:mm", "dd")
    val days2: String = asSchedule(d2, "yyyy.MM.dd HH:mm", "dd")
    val hours1: String = asSchedule(d1, "yyyy.MM.dd HH:mm", "HH")
    val hours2: String = asSchedule(d2, "yyyy.MM.dd HH:mm", "HH")
    val year1: String = asSchedule(d1, "yyyy.MM.dd HH:mm", "yy")
    val year2: String = asSchedule(d2, "yyyy.MM.dd HH:mm", "yy")

    val hours = hours2.toLong() - hours1.toLong()
    val days = days2.toLong() - days1.toLong()
    val years = year2.toLong() - year1.toLong()

    var formattedDiff = ""
    if (hours != 0L && days == 0L) {
        if (hours <= 4L) {
            formattedDiff = asTimeScheduleApi(d1)
        } else if (hours > 4L) {
            formattedDiff = "Сегодня"
        }
    }

    if (days != 0L) {
        if (days <= 1L && year2 == year1) {
            formattedDiff = "Вчера"
        } else if (days in 2..365 && year2 == year1) {
            formattedDiff = asCustomDateApi(d1)
        } else if (year2 != year1) {
            formattedDiff = asDateApi(d1)
        }
    }
    return formattedDiff
}