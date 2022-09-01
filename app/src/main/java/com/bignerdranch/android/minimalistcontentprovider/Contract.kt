package com.bignerdranch.android.minimalistcontentprovider

import android.net.Uri

object Contract{

    const val AUTHORITY: String =
        "com.bignerdranch.android.minimalistcontentprovider"

    const val CONTENT_PATH: String =
        "words"

    const val COUNT = "count"

    val CONTENT_URI: Uri =
        Uri.parse("content://$AUTHORITY/$CONTENT_PATH")

    const val ALL_ITEMS: Int = -2

    const val WORD_ID: String = "id"

    const val SINGLE_RECORD_MIME_TYPE: String =
        "vnd.android.cursor.item/vnd.com.bignerdranch.words"
    const val MULTIPLE_RECORD_MIME_TYPE: String =
        "vnd.android.cursor.dir/vnd.com.bignerdranch.words"
}