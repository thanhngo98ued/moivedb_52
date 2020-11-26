package com.edu.movie.data.source.remote.fetchjson

import android.os.AsyncTask
import com.edu.movie.data.source.remote.OnFetchDataJsonListener
import com.edu.movie.utils.TypeModel

class GetJsonFromUrl<T> constructor(
    private val jsonListener: OnFetchDataJsonListener<T>,
    private val typeMode: TypeModel
) : AsyncTask<String?, Unit?, String>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String {
        var data = ""
        try {
            params[0]?.let { data = ParseDataWithJson().getJsonFromUrl(it) }
        } catch (e: Exception) {
            exception = e
        }
        return data
    }

    override fun onPostExecute(result: String) {
        if (result == "") jsonListener.onError(exception)
        else {
            val data = ParseDataWithJson().parseJson(result, typeMode)
            data?.let {
                @Suppress("UNCHECKED_CAST")
                jsonListener.onSuccess(it as T)
            }
        }
    }
}
