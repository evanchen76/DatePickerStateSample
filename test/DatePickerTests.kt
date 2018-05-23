
import org.junit.Test
import kotlin.test.assertEquals

class DatePickerTests {

    @Test
    fun tapDate_0501_should_0501() {
        //點0501 => startDate:0501, endDate:null
        //arrange
        val context = DatePickerStateContext()

        val expectedStartDate = createDate("2018-05-01")

        //act
        context.tapDate(createDate("2018-05-01"))

        //assert
        assertEquals(expectedStartDate, context.startDate)
        assertEquals(null, context.endDate)
    }

    @Test
    fun tapDate_0501_0505_should_0501_0505() {
        //第一次點0501，第二次點0505=> startDate:0501, endDate:0505
        //arrange
        val context = DatePickerStateContext()

        val expectedStartDate = createDate("2018-05-01")
        val expectedEndDate = createDate("2018-05-05")

        //act
        context.tapDate(createDate("2018-05-01"))
        context.tapDate(createDate("2018-05-05"))

        //assert
        assertEquals(expectedStartDate, context.startDate)
        assertEquals(expectedEndDate, context.endDate)
    }

    @Test
    fun tapDate_0501_0430_should_0430_0501() {
        //第一次點0501，第二次點0430=> startDate:0430, endDate:0501

        //arrange
        val context = DatePickerStateContext()

        val expectedStartDate = createDate("2018-04-30")
        val expectedEndDate = createDate("2018-05-01")

        //act
        context.tapDate(createDate("2018-05-01"))
        context.tapDate(createDate("2018-04-30"))

        //assert
        assertEquals(expectedStartDate, context.startDate)
        assertEquals(expectedEndDate, context.endDate)
    }

    @Test
    fun tapDate_0501_0502_0503_should_0503_null() {
        //第一次點0501，第二次點0502，第三次點0503 => startDate:0503, endDate:null
        //arrange
        val context = DatePickerStateContext()

        val expectedStartDate = createDate("2018-05-03")
        val expectedEndDate = null

        //act
        context.tapDate(createDate("2018-05-01"))
        context.tapDate(createDate("2018-05-02"))
        context.tapDate(createDate("2018-05-03"))

        //assert
        assertEquals(expectedStartDate, context.startDate)
        assertEquals(expectedEndDate, context.endDate)
    }
}