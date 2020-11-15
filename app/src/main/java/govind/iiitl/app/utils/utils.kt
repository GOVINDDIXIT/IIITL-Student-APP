package govind.iiitl.app.utils

import android.content.Context
import android.graphics.Color
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import java.nio.charset.Charset
import java.util.*

fun loadJsonFromAsset(s: String, context: Context): String? {
    var json: String? = null
    try {
        val `in` = Objects.requireNonNull(context)?.assets?.open("timetable/$s")
        val size = `in`?.available()
        val buffer = size?.let { ByteArray(it) }
        `in`?.read(buffer)
        `in`?.close()
        json = buffer?.let { String(it, Charset.forName("UTF-8")) }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return json
}

fun openWebPage( context: Context, url: String) {
    val builder = CustomTabsIntent.Builder()
    builder.setToolbarColor(Color.parseColor("#000000"))
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(context, Uri.parse(url))
}