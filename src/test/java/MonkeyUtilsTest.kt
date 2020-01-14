import org.junit.Assert
import org.junit.Test
import utils.MonkeyUtils

class MonkeyUtilsTest {
    @Test
    fun testUserWait() {
        val result = MonkeyUtils.userWait(300)
        Assert.assertEquals(result, "UserWait(300)")
    }

    @Test
    fun testUserWaitLessThan0() {
        val result = MonkeyUtils.userWait(-1)
        Assert.assertEquals(result, "UserWait(100)")
    }

}