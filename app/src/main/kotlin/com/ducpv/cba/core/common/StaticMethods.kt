package com.ducpv.cba.core.common

import android.graphics.PointF
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.math.sin

/**
 * Created by pvduc9773 on 20/09/2023.
 */
object StaticMethods {
    const val yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm"
    const val yyyy_MM_dd = "yyyy-MM-dd"
    const val EEEE_MM_dd = "EEEE, MM/dd"


    /**
     * Get the hours from a Long date to 24 hour format [0,24]
     */
    fun Long.get24HourFormat(): Int {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = this
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    /**
     * Get the current time as string from a Long value retrieved from Date().time
     */
    fun Long?.getHourAsString(): String {
        // set the format
        val formatPattern = "HH:mm"

        // force english locale to get AM/PM instead of
        val locale = Locale.ENGLISH
        return if (this != null) {
            SimpleDateFormat(formatPattern, locale).format(Date(this))
        } else "N/A"
    }

    /**
     * Get the current day as short abbreviation string from a Long value retrieved from Date().time
     * @return Mon, Tue, Wen,...
     */
    fun Long?.getDayAsShortString(): String {
        return if (this != null) {
            SimpleDateFormat("EE", Locale.getDefault()).format(Date(this))
        } else "N/A"
    }

    /**
     * Get the current day as string from a Long value retrieved from Date().time
     * @return Monday, Tuesday, Wednesday,...
     */
    fun Long?.getDayAsString(): String {
        return if (this != null) {
            SimpleDateFormat("EEEE", Locale.getDefault()).format(Date(this))
        } else "N/A"
    }

    /**
     * Get DateTime from a String
     */
    fun String.toDate(pattern: String): Date? {
        return try {
            val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
            dateFormat.parse(this) ?: Date()
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }

    /**
     * Format dateTime to a String
     */
    fun Date.format(pattern: String): String? {
        val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        return try {
            dateFormat.format(this)
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }

    /**
     * Format dateTime to a hour of day String
     */
    fun Date.formatHourTime(): String {
        if (this.isSameHour(Date())) return "Now"
        val dateFormat = SimpleDateFormat("h", Locale.ENGLISH)
        return try {
            dateFormat.format(this)
        } catch (e: Exception) {
            Timber.e(e)
            "Now"
        }
    }

    /**
     * Format dateTime to am/pm
     */
    fun Date.formatHourTimeAmPm(): String {
        if (this.isSameHour(Date())) return ""
        val dateFormat = SimpleDateFormat("a", Locale.ENGLISH)
        return try {
            dateFormat.format(this)
        } catch (e: Exception) {
            Timber.e(e)
            ""
        }
    }

    /**
     * Check is same date
     */
    fun Date.isSameHour(date: Date): Boolean {
        val calendar = Calendar.getInstance().apply { time = this@isSameHour }
        val compareCalendar = Calendar.getInstance().apply { time = date }
        return calendar.get(Calendar.HOUR_OF_DAY) == compareCalendar.get(Calendar.HOUR_OF_DAY)
    }

    /**
     * Check is same date
     */
    fun Date.isSameDate(date: Date): Boolean {
        val calendar = Calendar.getInstance().apply { time = this@isSameDate }
        val compareCalendar = Calendar.getInstance().apply { time = date }
        return calendar.get(Calendar.ERA) == compareCalendar.get(Calendar.ERA) &&
                calendar.get(Calendar.YEAR) == compareCalendar.get(Calendar.YEAR) &&
                calendar.get(Calendar.DAY_OF_YEAR) == compareCalendar.get(Calendar.DAY_OF_YEAR)
    }

    fun Date.addDays(days: Int): Date {
        return Calendar.getInstance().apply {
            time = this@addDays
            add(Calendar.DAY_OF_MONTH, days)
        }.time
    }

    fun Date.isNight(): Boolean {
        val calendar = Calendar.getInstance().apply { time = this@isNight }
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        return hour !in 6..18
    }

    /**
     * Converts the degree value from Celsius to Fahrenheit, for float value
     */
    fun Float.toFahrenheit(): Int {
        return ((this * 1.8f) + 32f).roundToInt()
    }

    /**
     * Converts the degree value from Celsius to Fahrenheit, for integer value
     */
    fun Int.toFahrenheit(): Int {
        return ((this * 1.8f) + 32f).roundToInt()
    }

    /**
     * Map value from one range to another lets say we have the value (this)0.5 is in range [0,1]
     * and we want to map the value to new range [10,20]. Then the returned value will be 15
     */
    fun Float.mapTo(inMin: Float, inMax: Float, outMin: Float, outMax: Float): Float {
        return (this - inMin) * (outMax - outMin) / (inMax - inMin) + outMin
    }

    /**
     * Convert color values set as HSV(hue,saturation,value) to Composable Color
     * @param hue the hue range is [0,360]
     * @param saturation the saturation range is [0,1]
     * @param value the value range is [0,1]
     * @param alpha the alpha [0,1]
     */
    fun hsv(hue: Float, saturation: Float, value: Float, alpha: Float = 1f): Color {

        fun hsvToRgbComponent(n: Int, h: Float, s: Float, v: Float): Float {
            val k = (n.toFloat() + h / 60f) % 6f
            return v - (v * s * max(0f, minOf(k, 4 - k, 1f)))
        }

        val red = hsvToRgbComponent(5, hue, saturation, value)
        val green = hsvToRgbComponent(3, hue, saturation, value)
        val blue = hsvToRgbComponent(1, hue, saturation, value)
        return Color(red, green, blue, alpha, ColorSpaces.Srgb)
    }

    /**
     * Convert color values set as HSL(hue,saturation,lightness) to Composable Color
     * @param hue the hue range is [0,360]
     * @param saturation the saturation range is [0,1]
     * @param lightness the lightness range is [0,1]
     * @param alpha the alpha [0,1]
     */
    fun hsl(hue: Float, saturation: Float, lightness: Float, alpha: Float = 1f): Color {

        fun hslToRgbComponent(n: Int, h: Float, s: Float, l: Float): Float {
            val k = (n.toFloat() + h / 30f) % 12f
            val a = s * min(l, 1f - l)
            return l - a * max(-1f, minOf(k - 3, 9 - k, 1f))
        }

        val red = hslToRgbComponent(0, hue, saturation, lightness)
        val green = hslToRgbComponent(8, hue, saturation, lightness)
        val blue = hslToRgbComponent(4, hue, saturation, lightness)
        return Color(red, green, blue, alpha, ColorSpaces.Srgb)
    }

    /**
     * Rotate a point around a center with given angle
     * @param cx rotary center point x coordinate
     * @param cy rotary center point y coordinate
     * @param x x coordinate of the point that will be rotated
     * @param y y coordinate of the point that will be rotated
     * @param angle angle of rotation in degrees
     * @param antiClockwise rotate clockwise or anti-clockwise
     * @param resultPoint object where the result rotational point will be stored
     */
    fun rotate(
        cx: Float,
        cy: Float,
        x: Float,
        y: Float,
        angle: Float,
        antiClockwise: Boolean = false,
        resultPoint: PointF = PointF()
    ): PointF {
        if (angle == 0f) {
            resultPoint.x = x
            resultPoint.y = y
            return resultPoint
        }

        val radians = if (antiClockwise) {
            (Math.PI / 180) * angle
        } else {
            (Math.PI / -180) * angle
        }

        val cos = cos(radians)
        val sin = sin(radians)
        val nx = (cos * (x - cx)) + (sin * (y - cy)) + cx
        val ny = (cos * (y - cy)) - (sin * (x - cx)) + cy

        resultPoint.x = nx.toFloat()
        resultPoint.y = ny.toFloat()
        return resultPoint
    }
}