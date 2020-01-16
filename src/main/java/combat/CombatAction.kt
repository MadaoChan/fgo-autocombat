package combat

import utils.MonkeyUtils
import utils.Global

class CombatAction : ICombatAction {

    private val width = Global.WIDTH.toDouble()
    private val height = Global.HEIGHT.toDouble()
    private val startX = Global.START_X.toDouble()
    private val startY = Global.START_Y.toDouble()

    override fun selectEnemy(enemy: Int): String {
        val xCenterPercent = (enemy - 1) * Global.ENEMY_X_DELTA + Global.ENEMY_X_BASE
        val x = getX(xCenterPercent, Global.ENEMY_X_BIAS)
        val y = getY(Global.ENEMY_Y_BASE, Global.ENEMY_Y_BIAS)
        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(50))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userWait = userClickWait(150)
        return "$downScript\r\n$upScript\r\n$userWait"
    }

    override fun servantSkill(skill: Int, from: Int, wait: Long): String {
        val xCenterPercent = ((from - 1) * Global.SERVANT_X_DELTA + Global.SERVANT_SKILL_X_BASE) +
                (skill - 2) * Global.SERVANT_SKILL_X_DELTA

        val x = getX(xCenterPercent, Global.SKILL_BIAS)
        val y = getY(Global.SERVANT_SKILL_Y_BASE, Global.SKILL_BIAS)
        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(50))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userWait = userWait(wait)
        return "$downScript\r\n$upScript\r\n$userWait"
    }

    override fun servantSkill(skill: Int, from: Int, to: Int, isFriendly: Boolean, wait: Long): String {
        //TODO 选择敌人放buff
        val fromXCenterPercent = ((from - 1) * Global.SERVANT_X_DELTA + Global.SERVANT_SKILL_X_BASE) +
                (skill - 2) * Global.SERVANT_SKILL_X_DELTA

        val fromX = getX(fromXCenterPercent, Global.SKILL_BIAS)
        val fromY = getY(Global.SERVANT_SKILL_Y_BASE, Global.SKILL_BIAS)
        val fromDownScript = MonkeyUtils.downEvent(fromX, fromY, randomClickTime(150))
        val fromUpScript = MonkeyUtils.upEvent(fromX, fromY, 30)
        val userClickWait = userClickWait(300)
        val fromScript = "$fromDownScript\r\n$fromUpScript\r\n$userClickWait"

        val toXCenterPercent = (to - 1) * Global.SELECT_SERVANT_X_DELTA + Global.SELECT_SERVANT_X_BASE
        val toX = getX(toXCenterPercent, Global.SELECT_SERVANT_X_BIAS)
        val toY = getY(Global.SELECT_SERVANT_Y_BASE, Global.SELECT_SERVANT_Y_BIAS)
        val toDownScript = MonkeyUtils.downEvent(toX, toY, randomClickTime(150))
        val toUpScript = MonkeyUtils.upEvent(toX, toY, 30)
        val userWait = userWait(wait)
        val toScript = "$toDownScript\r\n$toUpScript\r\n$userWait"
        return "$fromScript$toScript"
    }

    override fun openMasterSkill(): String {
        val x = getX(Global.MASTER_SKILL_OPEN_X_BASE,  0.toDouble())
        val y = getY(Global.MASTER_SKILL_OPEN_Y_BASE,  0.toDouble())

        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(40))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userWait = userClickWait(300)
        return "$downScript\r\n$upScript\r\n$userWait"
    }

    override fun masterSkill(skill: Int, wait: Long): String {
        val xCenterPercent = (skill - 1) * Global.MASTER_SKILL_X_DELTA + Global.MASTER_SKILL_X_BASE
        val x = getX(xCenterPercent, 0.toDouble())
        val y = getY(Global.MASTER_SKILL_Y_BASE, 0.toDouble())
        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(150))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userWait = userWait(wait)
        return "$downScript\r\n$upScript\r\n$userWait"
    }

    override fun masterSkill(skill: Int, to: Int, isFriendly: Boolean, wait: Long): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeServant(servantLeave: Int, servantCome: Int): String {
        // 点击换人技能
        val openSkill = masterSkill(3, 200)

        // 点击换出从者
        val leaveCenterPercent = (servantLeave - 1) * Global.CHANGE_SERVANT_X_DELTA + Global.CHANGE_SERVANT_X_BASE
        val leaveX = getX(leaveCenterPercent, Global.CHANGE_SERVANT_X_BIAS)
        val leaveY = getY(Global.CHANGE_SERVANT_Y_BASE, Global.CHANGE_SERVANT_Y_BIAS)
        val leaveDownScript = MonkeyUtils.downEvent(leaveX, leaveY, randomClickTime(150))
        val leaveUpScript = MonkeyUtils.upEvent(leaveX, leaveY, 30)
        val leaveUserClickWait = userClickWait(200)
        val leaveScript = "$leaveDownScript\r\n$leaveUpScript\r\n$leaveUserClickWait"

        // 点击换入从者
        val comeCenterPercent = (servantCome - 1) * Global.CHANGE_SERVANT_X_DELTA + Global.CHANGE_SERVANT_X_BASE
        val comeX = getX(comeCenterPercent, Global.CHANGE_SERVANT_X_BIAS)
        val comeY = getY(Global.CHANGE_SERVANT_Y_BASE, Global.CHANGE_SERVANT_Y_BIAS)
        val comeDownScript = MonkeyUtils.downEvent(comeX, comeY, randomClickTime(150))
        val comeUpScript = MonkeyUtils.upEvent(comeX, comeY, 30)
        val comeUserClickWait = userClickWait(200)
        val comeScript = "$comeDownScript\r\n$comeUpScript\r\n$comeUserClickWait"

        // 点击确定
        val confirmX = getX(Global.CHANGE_CONFIRM_X_BASE, Global.CHANGE_CONFIRM_X_BIAS)
        val confirmY = getY(Global.CHANGE_CONFIRM_Y_BASE, Global.CHANGE_CONFIRM_Y_BIAS)
        val confirmDownScript = MonkeyUtils.downEvent(confirmX, confirmY, randomClickTime(150))
        val confirmUpScript = MonkeyUtils.upEvent(confirmX, confirmY, 30)
        val userWait = userWait(7000)
        val confirmScript = "$confirmDownScript\r\n$confirmUpScript\r\n$userWait"
        return "$openSkill$leaveScript$comeScript$confirmScript"
    }

    override fun openAttack(): String {
        val x = getX(Global.ATT_BUTTON_X, Global.ATT_BUTTON_X_BIAS)
        val y = getY(Global.ATT_BUTTON_Y, Global.ATT_BUTTON_Y_BIAS)

        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(40))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userWait = userWait(1500)
        return "$downScript\r\n$upScript\r\n$userWait"
    }

    override fun attack(order: Int): String {
        val xCenterPercent = (order -1) * Global.CARD_X_DELTA + Global.SERVANT_ATT_X_BASE
        val x = getX(xCenterPercent, Global.CARD_X_BIAS)
        val y = getY(Global.SERVANT_ATT_Y_BASE, Global.CARD_Y_BIAS)

        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(150))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userWait = userClickWait(180)
        return "$downScript\r\n$upScript\r\n$userWait"
    }

    override fun noblePhantasm(order: Int): String {
        val xCenterPercent = (order - 1) * Global.CARD_X_DELTA + Global.NP_X_BASE
        val x = getX(xCenterPercent, Global.CARD_X_BIAS)
        val y = getY(Global.NP_Y_BASE, Global.CARD_Y_BIAS)

        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(150))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userWait = userClickWait(200)
        return "$downScript\r\n$upScript\r\n$userWait"
    }

    override fun userWait(time: Long): String {
        return "${MonkeyUtils.userWait(randomWaitTime(time))}\r\n"
    }

    override fun userClickWait(time: Long): String {
        return "${MonkeyUtils.userWait(randomClickTime(time))}\r\n"
    }

    override fun battleFinish(): String {
        // 点击5次屏幕，“结束”按键的位置
        val x = getX(Global.BATTLE_FINISH_X_BASE, Global.BATTLE_FINISH_X_BIAS)
        val y = getY(Global.BATTLE_FINISH_Y_BASE, Global.BATTLE_FINISH_Y_BIAS)
        val downScript = MonkeyUtils.downEvent(x, y, randomClickTime(150))
        val upScript = MonkeyUtils.upEvent(x, y, 30)
        val userClickWait = userClickWait(200)
        val userClickWait2 = userClickWait(500)
        return "$downScript\r\n$upScript\r\n$userClickWait\r\n" +
                "$downScript\r\n$upScript\r\n$userClickWait2\r\n" +
                "$downScript\r\n$upScript\r\n$userClickWait\r\n" +
                "$downScript\r\n$upScript\r\n$userClickWait2\r\n" +
                "$downScript\r\n$upScript\r\n$userClickWait\r\n"
    }

    /**
     * 生成随机点击持续时间（+0~0.1秒内）
     */
    private fun randomClickTime(time: Long): Long {
        val lowerBound = 0.toDouble()
        val upperBound = 100.toDouble()
        return (time + MonkeyUtils.random(lowerBound, upperBound)).toLong()
    }

    /**
     * 生成随机等待时间（+0~1秒内）
     */
    private fun randomWaitTime(base: Long): Long {
        val lowerBound = 0.toDouble()
        val upperBound = 1000.toDouble()
        return (base + MonkeyUtils.random(lowerBound, upperBound)).toLong()
    }

    /**
     * 点击位置
     * @param center 中心点
     * @param bias 可偏离值
     */
    private fun randomLocation(center: Double, bias: Double): Double {
        val lowerBound = center - bias
        val upperBound = center + bias
        return MonkeyUtils.random(lowerBound, upperBound)
    }

    /**
     * 全屏随机点击位置
     *
     */
    fun randomFullScreen() {

    }

    private fun getX(center: Double, bias: Double=0.0): Int {
        return getCoordinate(startX, center, bias, width)
    }

    private fun getY(center: Double, bias: Double=0.0): Int {
        return getCoordinate(startY, center, bias, height)
    }

    private fun getCoordinate(start: Double, center: Double, bias: Double, length: Double): Int {
        return (start + randomLocation(center, bias) * length).toInt()
    }

}