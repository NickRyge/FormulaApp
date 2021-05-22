package models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Formula::class], version = 2, exportSchema = false)
abstract class FormulaDatabase : RoomDatabase() {
    abstract fun formulaDao(): FormulaDao

    companion object{
        private var Instance: FormulaDatabase? = null
        fun getFormulaDatabase(context: Context): FormulaDatabase?{
            if (Instance == null){
                Instance = Room.databaseBuilder(context.applicationContext, FormulaDatabase::class.java, "formula-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return Instance
        }
    }
}