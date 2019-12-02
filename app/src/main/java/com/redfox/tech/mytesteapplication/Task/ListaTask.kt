package com.redfox.tech.mytesteapplication.Task

import android.os.AsyncTask
import android.util.Log
import com.redfox.tech.mytesteapplication.Utilities.HttpUtils


open class ListaTask(private val Id: String) :
    AsyncTask<Void?, Void?, String?>() {
     override fun doInBackground(vararg p0: Void?): String? {
        return try {
            HttpUtils.post(com.redfox.tech.mytesteapplication.Utilities.Util.BASE_URL_ROUTE, Id)
        } catch (e: Exception) {
            Log.e("ERROR", e.message)
            null
        }
    }


}