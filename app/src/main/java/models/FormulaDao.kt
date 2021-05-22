package models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FormulaDao {
    @Query("SELECT * FROM formula")
    fun getformulas(): List<Formula>

    @Query("SELECT * FROM formula WHERE name LIKE :searchParam")
    fun getSearchedFormula(searchParam: String): List<Formula>

    @Insert
    fun insert(formula: Formula?)
}