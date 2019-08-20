package com.lambda.debugthis

class ShoppingRepository {
    companion object {
        val shoppingList = mutableListOf<ShoppingItem>()
        fun createShoppingList() {
            for (i in 0 until itemIds.size) {
                shoppingList.add(
                    ShoppingItem(
                        itemIds[i],
                        itemNames[i]
                    )
                )
            }
        }
    }
}