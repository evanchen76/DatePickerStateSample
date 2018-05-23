import java.util.*

abstract class AbstractDatePickerState(private val context:DatePickerStateContext) {

    abstract fun selectDate(date:Date)
}

//未有日期被選取的狀態
class NothingSelected(private val context:DatePickerStateContext) :AbstractDatePickerState(context){

    override fun selectDate(date: Date) {
        context.startDate = date

        //將狀態改為起始日被選取
        context.current = FirstDateSelected(context)
    }
}

//起始日期被還取的狀態
class FirstDateSelected (private val context:DatePickerStateContext) :AbstractDatePickerState(context){
    override fun selectDate(date: Date) {
        when {
            date > context.startDate -> {
                //選的日期比上次選的日期大
                context.endDate = date
            }
            date < context.startDate -> {
                //選的日期比上次選的日期小
                context.endDate = context.startDate
                context.startDate = date
            }
            else -> {
                //選的日期比上次選的一樣
                context.startDate = date
                context.endDate = date
            }
        }

        //將狀態改為起始、結束日期都選了
        context.current = BothDateSelected(context)
    }
}

//起始、結束日期都被選取的狀態
class BothDateSelected (private val context:DatePickerStateContext) :AbstractDatePickerState(context){
    override fun selectDate(date: Date) {
        context.startDate = date
        context.endDate = null
        //將狀態改為只選起始日
        context.current = FirstDateSelected(context)
    }
}
