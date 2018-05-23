import java.util.*

class DatePickerStateContext {
    var startDate: Date? = null
    var endDate: Date? = null

    var current: AbstractDatePickerState = NothingSelected(this)

    fun tapDate(date:Date){
        current.selectDate(date)
    }
}
