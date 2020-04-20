package com.akrwt.digitaludhaarkhata

import android.graphics.Bitmap

class ContactsModel(var name: String, var number: String, var image: Bitmap?) {
    constructor() : this("", "", null)
}