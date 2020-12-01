package com.edu.movie.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.net.HttpURLConnection
import java.net.URL

class LoadImageFromUrl(private val funcLoadImage: (Bitmap) -> Unit) :
    AsyncTask<String, Unit, Bitmap?>() {

    override fun doInBackground(vararg params: String?): Bitmap? =
        try {
            var bitmap: Bitmap? = null
            val url = URL(params[0])
            val httpURLConnection = (url.openConnection() as HttpURLConnection).apply {
                requestMethod = METHOD_GET
                readTimeout = TIME_OUT
                connectTimeout = TIME_OUT
                doOutput = true
                connect()
            }
            bitmap = BitmapFactory.decodeStream(url.openStream())
            httpURLConnection.disconnect()
            bitmap
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        result?.let {
            funcLoadImage(it)
        }
    }

    companion object {
        private const val TIME_OUT = 10000
        private const val METHOD_GET = "GET"
    }
}
