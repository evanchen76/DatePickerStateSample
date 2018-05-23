
fun main(args : Array<String>) {
    val context = DatePickerStateContext()

    val date = createDate("2018-05-01")
    context.tapDate(date)

    println("startDate:${toSimpleString(context.startDate)}")
    println("endDate:${toSimpleString(context.endDate)}")

}

