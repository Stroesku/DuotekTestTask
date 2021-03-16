package space.stroesku.duotektask.repo

import space.stroesku.duotektask.User
import javax.inject.Singleton
import kotlin.collections.MutableList

@Singleton
class Repository {
    private val users = mutableListOf<User>()


    fun getList(): MutableList<User> {
        users.add(User("Виктор", "Строеску","Люблю писать код"))
        users.add(User("Александр", "Строеску","Люблю бездельничать"))
        users.add(User("Никита", "Кабанов","Люблю умничать"))
        users.add(User("Алёна", "Кабанов","Люблю умничать"))
        users.add(User("АОЛАЛА", "Кабанов","Люблю умничать"))
        users.add(User("ываловолыа", "Кабанов","Люблю умничать"))
        users.add(User("Коляны", "Кабанов","Люблю умничать"))
        users.add(User("Коыаыалян", "Кабанов","Люблю умничать"))
        users.add(User("ыа", "Кабанов","Люблю умничать"))
        users.add(User("Колян", "Кабанов","Люблю умничать"))
        users.add(User("Колян", "ыфа","Люблю умничать"))
        users.add(User("ыав", "Кабанов","Люблю умничать"))
        users.add(User("Колян", "Кабанов","Люблю умничать"))
        users.add(User("ыва", "Кабанов","Люблю умничать"))
        users.add(User("Колян", "Кабанов","Люблю умничать"))
        users.add(User("ыв", "Кабанов","Люблю умничать"))
        users.add(User("ваы", "Кабанов","Люблю умничать"))
        users.add(User("ыв", "Кабанов","Люблю умничать"))
        users.add(User("ываф", "Кабанов","Люблю умничать"))
        users.add(User("Колян", "Кабанов","Люблю умничать"))
        users.add(User("Колян", "Кабанов","Люблю умничать"))
        return users
    }

}