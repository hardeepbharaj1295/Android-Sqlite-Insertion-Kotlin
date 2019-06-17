package com.hardeep.androidkotlininsertion.database

import android.content.ContentValues
import android.content.Context

class DatabaseQueries {

    private lateinit var sql: DatabaseCreation

    constructor(context: Context)
    {
        sql = DatabaseCreation(context)
    }

    fun addCustomer(name:String,phno:String,address:String): Long
    {
        val db = sql.writableDatabase
        val cv = ContentValues()
        cv.put(DatabaseColumns.CUSTOMER_NAME,name)
        cv.put(DatabaseColumns.CUSTOMER_ADDRESS,address)
        cv.put(DatabaseColumns.CUSTOMER_PHNO,phno)

        return db.insert(DatabaseColumns.CUSTOMER_TABLE, null,cv)
    }
}