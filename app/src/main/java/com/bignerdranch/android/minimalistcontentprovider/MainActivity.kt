package com.bignerdranch.android.minimalistcontentprovider

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private var mTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.txt_response)

    }

    fun onClickDisplayEntries(view: View){
        val queryUri: String = Contract.CONTENT_URI.toString()
        val projection = arrayOf(Contract.CONTENT_PATH)
        val selectionClause: String?
        val selectionArgs: Array<String>?
        val sortOrder: String? = null

        when(view.id) {
            R.id.btn_list_all_words -> {
                selectionClause = null
                selectionArgs = null
            }
            R.id.btn_list_first_words -> {
                selectionClause = "${Contract.WORD_ID} = ?"
                selectionArgs = arrayOf("0")
            }
            else -> {
                selectionClause = null
                selectionArgs = null
            }
        }

        val cursor: Cursor? = contentResolver
            .query(Uri.parse(queryUri),
                projection,
                selectionClause,
                selectionArgs,
                sortOrder)

        if(cursor != null){
            if(cursor.count > 0){
                cursor.moveToFirst()
                val columnIndex: Int = cursor.getColumnIndex(projection[0])
                do{
                    val word: String = cursor.getString(columnIndex)
                    mTextView?.append("$word\n")
                } while (cursor.moveToNext())
            }
            else{
                Log.d(TAG, "onClickDisplayEntries: No data returned.")
                mTextView?.append("No data returned.\n")
            }
            cursor.close()
        }
        else{
            Log.d(TAG, "onClickDisplayEntries: Cursor is null.")
            mTextView?.append("Cursor is null.\n")
        }

    }
}