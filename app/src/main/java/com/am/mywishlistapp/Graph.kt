package com.am.mywishlistapp

import android.content.Context
import androidx.room.Room
import com.am.mywishlistapp.data.WishDataBase
import com.am.mywishlistapp.data.WishRepository

object Graph {
    lateinit var database: WishDataBase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDataBase::class.java, "wishlist.db").build()
    }
}