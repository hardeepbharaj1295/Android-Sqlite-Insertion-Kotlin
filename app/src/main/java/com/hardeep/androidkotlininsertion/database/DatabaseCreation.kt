package com.hardeep.androidkotlininsertion.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseCreation(context: Context?) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    val customer = "CREATE TABLE ${DatabaseColumns.CUSTOMER_TABLE} (${DatabaseColumns.CUSTOMER_NAME} TEXT," +
            "${DatabaseColumns.CUSTOMER_PHNO} LONG,${DatabaseColumns.CUSTOMER_ADDRESS} TEXT)"

    val drop_table = "DROP TABLE IF EXISTS ${DatabaseColumns.CUSTOMER_TABLE}"

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(drop_table)
        onCreate(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(customer)
    }

    companion object{
        val DB_NAME = "customer.db"
        val DB_VERSION = 1
    }
}