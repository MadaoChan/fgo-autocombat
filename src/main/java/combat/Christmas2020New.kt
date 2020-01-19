package combat

import java.text.SimpleDateFormat
import java.util.*

class Christmas2020New: Battle() {

    companion object {
        private const val SKILL_WAIT = 2800L
        private const val TURN_WAIT = 32000L
    }

    init {
        action = CombatAction()
    }

    /**
     * 阵容1：带大英雄
     */
    private fun force1(): String {
        // FGO国服2020圣诞无限池Monkey脚本
        // 屏幕分辨率：1280*720
        // 阵容：
        //	1号位 CBA
        //	2号位 大英雄（带满破虚数魔术）
        //	3号位 CBA
        //  4号位 女武神（带50NP初始礼装）
        //	5号位 孔明
        // 衣服：换人服

        val stringBuilder = StringBuilder()
        // 头部参数
        stringBuilder.append(buildHeader())

        // ——————————第1面——————————
        // 2号位大英雄   技能3
        stringBuilder.append(action.servantSkill(3, 2, SKILL_WAIT))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号大英雄   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(4))
        stringBuilder.append(action.attack(3))
        // 宝具结束后，点击跳过遗言
        stringBuilder.append(action.userWait(11000))
        stringBuilder.append(action.openAttack())
        // 等待到第2面
        stringBuilder.append(action.userWait(10000))

        // ——————————第2面——————————
        // 1号位CBA      技能1给女武神
        stringBuilder.append(action.servantSkill(1, 1, 2, true, SKILL_WAIT))
        // 2号位女武神   技能1 技能3
        stringBuilder.append(action.servantSkill(1, 2, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 2, SKILL_WAIT))
        // 3号位CBA 	 技能1给女武神		技能2
        stringBuilder.append(action.servantSkill(1, 3, 2, true, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(2, 3, 2, true, SKILL_WAIT))
        // 点御主技能   技能3换人    4号位孔明换3号位CBA
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.changeServant(3, 4))
        // 3号位孔明 	技能1给女武神	使用技能2	技能3
        stringBuilder.append(action.servantSkill(1, 3, 2, true, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(2, 3, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 3, SKILL_WAIT))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号女武神宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(4))
        stringBuilder.append(action.attack(3))
        // 等待到第2面
        stringBuilder.append(action.userWait(TURN_WAIT))

        // ——————————第3面——————————
        // 1号位CBA   技能2     技能3给女武神
        stringBuilder.append(action.servantSkill(2, 1, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 1, 2, true, SKILL_WAIT))
        // 点御主技能    使用技能1
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(1, 2600))
        // 选择2号敌人
        stringBuilder.append(action.selectEnemy(2))
        // 点御主技能    使用技能2
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(2, 2600))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号女武神宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.attack(3))
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(4))

        return stringBuilder.toString()
    }

    private fun force2(): String {
        // FGO国服2020圣诞无限池Monkey脚本
        // 屏幕分辨率：1280*720
        // 阵容：
        //	1号位 CBA
        //	2号位 女武神（带50NP初始礼装）
        //	3号位 CBA
        //	4号位 孔明
        // 衣服：换人服

        val stringBuilder = StringBuilder()
        // 头部参数
        stringBuilder.append(buildHeader())

        // ——————————第1面——————————
        // 1号位CBA      技能1给女武神
        stringBuilder.append(action.servantSkill(1, 1, 2, true, SKILL_WAIT))
        // 2号位女武神   技能1 技能3
        stringBuilder.append(action.servantSkill(3, 2, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(1, 2, SKILL_WAIT))
        // 3号位CBA 	 技能1给女武神		技能3给女武神
        stringBuilder.append(action.servantSkill(3, 3, 2, true, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(1, 3, 2, true, SKILL_WAIT))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号女武神宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(1))
        stringBuilder.append(action.attack(3))
        // 等待到第2面
        stringBuilder.append(action.userWait(TURN_WAIT))

        // ——————————第2面——————————
        // 3号位CBA 	技能2
//        stringBuilder.append(action.servantSkill(2, 3, SKILL_WAIT))
        // 点御主技能   技能3换人    4号位孔明换3号位CBA
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.changeServant(3, 4))
        // 3号位孔明 	技能1给女武神	使用技能2	技能3
        stringBuilder.append(action.servantSkill(1, 3, 2, true, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(2, 3, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 3, SKILL_WAIT))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号女武神宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(3))
        stringBuilder.append(action.attack(4))
        // 等待到第2面
        stringBuilder.append(action.userWait(TURN_WAIT))

        // ——————————第3面——————————
        // 选择2号敌人
        stringBuilder.append(action.selectEnemy(2))
        // 1号位CBA   技能2     技能3给女武神
        stringBuilder.append(action.servantSkill(2, 1, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 1, 2, true, SKILL_WAIT))
        // 点御主技能    使用技能2
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(2, 2600))
        // 点御主技能    使用技能1
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(1, 2600))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号女武神宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.attack(3))
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(4))

        return stringBuilder.toString()
    }

    private fun force3(): String {
        // FGO国服2020圣诞无限池Monkey脚本
        // 屏幕分辨率：1280*720
        // 阵容：
        //	1号位 CBA
        //	2号位 大英雄（带满破虚数魔术）
        //	3号位 CBA
        //  4号位 女武神（带50NP初始礼装）
        //	5号位 阿塔
        // 衣服：换人服

        val stringBuilder = StringBuilder()
        // 头部参数
        stringBuilder.append(buildHeader())

        // ——————————第1面——————————
        // 2号位大英雄   技能3
        stringBuilder.append(action.servantSkill(3, 2, SKILL_WAIT))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号大英雄   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(4))
        stringBuilder.append(action.attack(3))
        // 宝具结束后，点击跳过遗言
        stringBuilder.append(action.userWait(11000))
        stringBuilder.append(action.openAttack())
        // 等待到第2面
        stringBuilder.append(action.userWait(11000))

        // ——————————第2面——————————
        // 1号位CBA      技能1给女武神
        stringBuilder.append(action.servantSkill(1, 1, 2, true, SKILL_WAIT))
        // 2号位女武神   技能1 技能3
        stringBuilder.append(action.servantSkill(1, 2, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 2, SKILL_WAIT))
        // 3号位CBA 	 技能1给女武神		技能2     技能3给女武神
        stringBuilder.append(action.servantSkill(1, 3, 2, true, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(2, 3, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 3, 2, true, SKILL_WAIT))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号女武神宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(4))
        stringBuilder.append(action.attack(3))
        // 等待到第2面
        stringBuilder.append(action.userWait(TURN_WAIT))

        // ——————————第3面——————————
        // 1号位CBA   技能2     技能3给女武神
        stringBuilder.append(action.servantSkill(2, 1, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 1, 2, true, SKILL_WAIT))
        // 点御主技能    使用技能1
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(1, 2600))
        // 选择2号敌人
        stringBuilder.append(action.selectEnemy(2))
        // 点御主技能    使用技能2
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(2, 2600))
        // 点御主技能   技能3换人    4号位阿塔换3号位CBA
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.changeServant(3, 4))
        // 3号位阿塔 	技能1
        stringBuilder.append(action.servantSkill(1, 3, SKILL_WAIT))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：2号女武神宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.attack(3))
        stringBuilder.append(action.noblePhantasm(2))
        stringBuilder.append(action.attack(4))

        return stringBuilder.toString()
    }

    override fun buildScript(): String {
        return force2()
    }

    private fun buildHeader(): String {
        val dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        return "# $dateTime\r\ncount = 1\r\nspeed = 1.0\r\nstart data >>\r\n"
    }
}