package com.akrwt.digitaludhaarkhata

import android.app.Application
import android.content.Context

class MainApplication:Application() {
    override fun attachBaseContext(base: Context?) {
        val lh = LocaleHelper()
        super.attachBaseContext(lh.onAttach(base!!,"en"))

    }
}