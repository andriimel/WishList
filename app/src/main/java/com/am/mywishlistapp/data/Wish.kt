package com.am.mywishlistapp.data

data class Wish (
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google watch 2", description = "An android watch"),
        Wish(title = " watch 2", description = "An da  dsa das as as watch"),
        Wish(title = "Google Yahoo", description = "An  adsds sda ds ads as watch"),
        Wish(title = "Google watch 2", description = "An android saasdasdsd ad as a  sad ")
    )
}