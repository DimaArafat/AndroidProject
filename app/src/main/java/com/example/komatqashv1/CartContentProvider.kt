package com.example.komatqashv1

import android.content.*
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import android.text.TextUtils

class CartContentProvider : ContentProvider() {
    companion object {
        val PROVIDER_NAME = "com.example.komatqashv1.CartContentProvider"

        val URL = "content://" + PROVIDER_NAME + "/cart"

        val CONTENT_URI = Uri.parse(URL)

        val _ID = "_id"

        val ITEM = "item"

        val PRICE = "price"

        val ITEMS = 1

        val ITEMS_ID = 2

        val uriMatcher: UriMatcher? = null

        val DATABASE_NAME = "KQBakery"

        val CART_TABLE_NAME = "cart"

        val DATABASE_VERSION = 1

        val CREATE_DB_TABLE = " CREATE TABLE " + CART_TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " item TEXT NOT NULL, " +
                " price REAL NOT NULL);"

        var TOTAL = "0"
    }

    private var db: SQLiteDatabase? = null
    /**
     * Helper class that actually creates and manages * the provider's underlying data repository.
     */
    private class DatabaseHelper internal constructor(context: Context?) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(CREATE_DB_TABLE)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS " + CART_TABLE_NAME)
            onCreate(db)
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        var count = 0
        count = db!!.delete(
                CART_TABLE_NAME, selection,
                selectionArgs
            )
        return count
    }

    override fun getType(uri: Uri): String? {
        when (uriMatcher!!.match(uri)) {
            ITEMS -> return "vnd.android.cursor.dir/vnd.example.students"
            ITEMS_ID -> return "vnd.android.cursor.item/vnd.example.students"
            else -> throw IllegalArgumentException("Unsupported URI: $uri")
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        /**
         * Add a new student record
         */
        val rowID = db!!.insert(CART_TABLE_NAME, "", values)
        /**
         * If record is added successfully
         */

        if (rowID > 0) {
            val _uri = ContentUris.withAppendedId(CONTENT_URI, rowID)
            context!!.contentResolver.notifyChange(_uri, null)
            return _uri
        }
        throw SQLException("Failed to add a record into $uri")
    }

    override fun onCreate(): Boolean {
        val context = context
        val dbHelper = DatabaseHelper(context)
        //db!!.delete(CART_TABLE_NAME, null, null)
        /**
         * Create a write able database which will trigger its
         * creation if it doesn't already exist.  */
        db = dbHelper.writableDatabase
        return if (db == null) false else true
    }

    override fun query(
        uri: Uri, projection: Array<String>?,
        selection: String?, selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val c = db?.rawQuery("select sum(price) from cart", null);
        if(c?.moveToFirst() == true)
            TOTAL = c.getDouble(0).toString();
        else
            TOTAL = (0.0).toString();

        return c
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        var count = 0
        when (uriMatcher!!.match(uri)) {
            ITEMS -> count = db!!.update(
                CART_TABLE_NAME, values, selection,
                selectionArgs
            )
            ITEMS_ID -> count = db!!.update(
                CART_TABLE_NAME,
                values,
                _ID + " = " + uri.pathSegments[1] + (if (!TextUtils.isEmpty(selection)) " AND ($selection)" else ""),
                selectionArgs
            )
            else -> throw IllegalArgumentException("Unknown URI $uri")
        }
        context!!.contentResolver.notifyChange(uri, null)
        return count
    }

    fun doQuery(q: String){
        db!!.execSQL(q)
    }

    private var sUriMatcher = UriMatcher(UriMatcher.NO_MATCH);
    init
    {
        sUriMatcher.addURI(PROVIDER_NAME, "students", ITEMS);
        sUriMatcher.addURI(PROVIDER_NAME, "students/#", ITEMS_ID);
    }
}