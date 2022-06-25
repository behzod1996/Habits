package uz.behzoddev.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Habit(
    @ColumnInfo(name = Schema.NAME)
    val name: String,
    @ColumnInfo(name = Schema.REMINDER)
    val reminder: Long,
    @ColumnInfo(name = Schema.IS_NOTIFYING)
    val isNotifying: Boolean,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Schema.ID)
    var id: Int = 0
) {
    private object Schema {
        const val TABLE_NAME = "habit_table_name"
        const val NAME = "name"
        const val REMINDER = "reminder"
        const val IS_NOTIFYING = "is_notifying"
        const val ID = "id"
    }
}
