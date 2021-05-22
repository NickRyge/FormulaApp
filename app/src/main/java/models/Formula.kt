package models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "formula")
class Formula{
    @JvmField
    @PrimaryKey(autoGenerate = true)
    var uid = 0
    @JvmField
    var name: String? = null
    @JvmField
    var category: String? = null
    @JvmField
    var form: String? = null
    @JvmField
    var mathJaxForm: String? = null
    @JvmField
    var description: String? = null
}