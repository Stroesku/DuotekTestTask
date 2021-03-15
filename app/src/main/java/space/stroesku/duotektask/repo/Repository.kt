package space.stroesku.duotektask.repo

import space.stroesku.duotektask.UserModel
import kotlin.collections.MutableList

class Repository {
    private val users = mutableListOf<UserModel>()


    fun getList(): MutableList<UserModel> {
        users.add(UserModel("Виктор", "Строеску","Люблю писать код"))
        users.add(UserModel("Александр", "Строеску","Люблю бездельничать"))
        users.add(UserModel("Никита", "Кабанов","Люблю умничать"))
        users.add(UserModel("Алёна", "Кабанов","Люблю умничать"))
        users.add(UserModel("АОЛАЛА", "Кабанов","Люблю умничать"))
        users.add(UserModel("ываловолыа", "Кабанов","Люблю умничать"))
        users.add(UserModel("Коляны", "Кабанов","Люблю умничать"))
        users.add(UserModel("Коыаыалян", "Кабанов","Люблю умничать"))
        users.add(UserModel("ыа", "Кабанов","Люблю умничать"))
        users.add(UserModel("Колян", "Кабанов","Люблю умничать"))
        users.add(UserModel("Колян", "ыфа","Люблю умничать"))
        users.add(UserModel("ыав", "Кабанов","Люблю умничать"))
        users.add(UserModel("Колян", "Кабанов","Люблю умничать"))
        users.add(UserModel("ыва", "Кабанов","Люблю умничать"))
        users.add(UserModel("Колян", "Кабанов","Люблю умничать"))
        users.add(UserModel("ыв", "Кабанов","Люблю умничать"))
        users.add(UserModel("ваы", "Кабанов","Люблю умничать"))
        users.add(UserModel("ыв", "Кабанов","Люблю умничать"))
        users.add(UserModel("ываф", "Кабанов","Люблю умничать"))
        users.add(UserModel("Колян", "Кабанов","Люблю умничать"))
        users.add(UserModel("Колян", "Кабанов","Люблю умничать"))
        return users
    }

}