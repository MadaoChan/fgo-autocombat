package utils

/**
 * @author Madao Chan (cyf1910@gmail.com)
 * @since 2020/1/13
 */
class MonkeyUtils {
    companion object {

        /**
         * 检查持续时间是否正确
         * @param time 持续时间
         * @param default 默认持续时间（错误的情况下）
         */
        private fun validateTime(time: Long, default: Long=100): Long {
            if (time < 0 || time > Long.MAX_VALUE) {
                return default
            }
            return time
        }

        /**
         * 生成UserWait语句
         * @param time 等待时间
         * @return UserWait语句
         */
        fun userWait(time: Long): String {
            return "UserWait(${validateTime(time)})"
        }

        /**
         * 生成按下语句
         */
        fun downEvent(x: Int, y: Int, duration: Long=100): String {
            val time = validateTime(duration)
            return "DispatchPointer(0, $time, 0, $x, $y, 1, 0, 0, 0, 0, 0, 0, 0)"
        }

        /**
         * 生成弹起语句
         */
        fun upEvent(x: Int, y: Int, duration: Long=100): String {
            val time = validateTime(duration)
            return "DispatchPointer(0, $time, 1, $x, $y, 1, 0, 0, 0, 0, 0, 0, 0)"
        }


        /**
         * 生成随机值
         * @param lowerBound 下限
         * @param upperBound 上限
         */
        fun random(lowerBound: Double, upperBound: Double): Double {
            val random = Math.random()
            return lowerBound + (upperBound - lowerBound) * random
        }
    }
}