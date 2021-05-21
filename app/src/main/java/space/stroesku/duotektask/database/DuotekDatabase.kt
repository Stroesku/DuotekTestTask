package space.stroesku.duotektask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.model.Photo
import space.stroesku.duotektask.model.User

@Database(
    entities = [
        User::class,
        Album::class,
        Photo::class
    ], version = 1
)
abstract class DuotekDatabase : RoomDatabase() {
    abstract val dao: Dao
    companion object {
        @Volatile
        private var INSTANCE: DuotekDatabase? = null

        fun getInstance(context: Context): DuotekDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DuotekDatabase::class.java,
                    "photo_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}