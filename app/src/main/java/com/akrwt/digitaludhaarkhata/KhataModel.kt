package com.akrwt.digitaludhaarkhata

class KhataModel(
    var name: String,
    var sName: String,
    var take: String,
    var give: String,
    var time: String,
    var date: String
) {
    constructor() : this("", "", "", "", "", "")
}