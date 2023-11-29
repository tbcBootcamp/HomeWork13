package com.example.homework13.Data

class FieldList {

    fun getFieldList(): List<List<ItemModel>> {
        return listOf(
            listOf(
                ItemModel(1, "UserName", "input", "text", false, true, "https://cdn-icons-png.flaticon.com/512/1077/1077063.png"),
                ItemModel(2, "Email", "input", "text", true, true, "https://cdn-icons-png.flaticon.com/512/561/561127.png"),
                ItemModel(3, "phone", "input", "number", true, true, "https://cdn-icons-png.flaticon.com/512/159/159832.png")
            ),
            listOf(
                ItemModel(4, "FullName", "input", "text", true, true, "https://cdn-icons-png.flaticon.com/512/1077/1077063.png"),
                ItemModel(14, "Jemali", "input", "text", false, true, "https://jemala.png"),
                ItemModel(89, "Birthday", "chooser", "", false, true, "https://cdn-icons-png.flaticon.com/512/55/55281.png"),
                ItemModel(898, "Gender", "chooser", "", false, true, "https://cdn-icons-png.flaticon.com/512/505/505972.png")
            )
        )
    }
}