package combat.casefile

import combat.Battle
import combat.CombatAction
import java.text.SimpleDateFormat
import java.util.*

class CaseFileLineup: Battle() {
    companion object {
        private const val ATTACKER_SKILL_WAIT = 3500L
        private const val SKILL_WAIT = 2800L
    }

    init {
        action = CombatAction()
    }

    /**
     * 借梅林 不用解弱体
     */
    private fun force1(): String {
        // FGO国服 2020埃尔梅罗二世事件簿 魔神柱Monkey脚本1
        // 屏幕分辨率：1280*720
        // 阵容：
        //  1号位 狂贞（带黑杯）
        //  2号位 梅林（羁绊礼装）
        //  3号位 梅林（牛魔王最佳）
        //  4号位 玛尔达（牛魔王）
        // 衣服：换人服

        val stringBuilder = StringBuilder()
        // 头部参数
        stringBuilder.append(buildHeader())

        // 1号位狂贞 技能2 技能3
        stringBuilder.append(action.servantSkill(2, 1, ATTACKER_SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 1, ATTACKER_SKILL_WAIT))
        // 2号位梅林 技能1 技能3
        stringBuilder.append(action.servantSkill(1, 2, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 2, 1, true, SKILL_WAIT))
        // 3号位梅林 技能1 技能3
        stringBuilder.append(action.servantSkill(1, 3, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 3, 1, true, SKILL_WAIT))
        // 点御主技能   技能3换人    4号位玛尔达换3号位梅林
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.changeServant(3, 4))
        // 3号位玛尔达 技能3降防御
        stringBuilder.append(action.servantSkill(3, 3, SKILL_WAIT))
        // 点御主技能   技能1加攻
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(1, 2600))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：1号狂贞宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(1))
        stringBuilder.append(action.attack(4))
        stringBuilder.append(action.attack(3))

        return stringBuilder.toString()
    }

    /**
     * 借梅林 解弱体
     */
    private fun force2(): String {
        // FGO国服 2020埃尔梅罗二世事件簿 魔神柱Monkey脚本2
        // 屏幕分辨率：1280*720
        // 阵容：
        //  1号位 狂贞（带黑杯）
        //  2号位 梅林（羁绊礼装）
        //  3号位 梅林（牛魔王最佳）
        //  4号位 玛尔达（牛魔王）
        // 衣服：换人服

        val stringBuilder = StringBuilder()
        // 头部参数
        stringBuilder.append(buildHeader())

        // 1号位狂贞 技能2 技能3
        stringBuilder.append(action.servantSkill(2, 1, ATTACKER_SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 1, ATTACKER_SKILL_WAIT))
        // 2号位梅林 技能1 技能3
        stringBuilder.append(action.servantSkill(1, 2, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 2, 1, true, SKILL_WAIT))
        // 3号位梅林 技能1 技能3
        stringBuilder.append(action.servantSkill(1, 3, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 3, 1, true, SKILL_WAIT))
        // 点御主技能   技能3换人    4号位玛尔达换3号位梅林
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.changeServant(3, 4))
        // 3号位玛尔达 技能2解弱体 技能3降防御
        stringBuilder.append(action.servantSkill(2, 3, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 3, SKILL_WAIT))
        // 点御主技能   技能1加攻
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(1, 2600))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：1号狂贞宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(1))
        stringBuilder.append(action.attack(4))
        stringBuilder.append(action.attack(3))

        return stringBuilder.toString()
    }

    /**
     * 解弱体场合 借100级黑杯3宝三藏
     */
    private fun force3(): String {
        // FGO国服 2020埃尔梅罗二世事件簿 魔神柱Monkey脚本3
        // 屏幕分辨率：1280*720
        // 阵容：
        //  1号位 狂贞（带黑杯）
        //  2号位 莎士比亚（牛魔王）
        //  3号位 梅林（羁绊礼装）
        // 衣服：极地服

        val stringBuilder = StringBuilder()
        // 头部参数
        stringBuilder.append(buildHeader())

        // 1号位三藏 技能2 技能3
        stringBuilder.append(action.servantSkill(1, 1, SKILL_WAIT))
        // 2号位莎士比亚 技能2解弱体 技能3降防御
        stringBuilder.append(action.servantSkill(2, 1, SKILL_WAIT))
        // 3号位梅林 技能1 技能3
        stringBuilder.append(action.servantSkill(1, 3, SKILL_WAIT))
        stringBuilder.append(action.servantSkill(3, 3, 1, true, SKILL_WAIT))
        // 点御主技能   技能1解弱体
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(1, 1, true, 2600))
        // 点御主技能   技能2加攻
        stringBuilder.append(action.openMasterSkill())
        stringBuilder.append(action.masterSkill(2, 1, true, 2600))
        // 点攻击
        stringBuilder.append(action.openAttack())
        // 选卡：1号三藏宝具   攻击卡4  攻击卡3
        stringBuilder.append(action.noblePhantasm(1))
        stringBuilder.append(action.attack(4))
        stringBuilder.append(action.attack(3))

        return stringBuilder.toString()
    }

    override fun buildScript(): String {
        // 阵容1：借梅林 不用解弱体
        // 阵容2：借梅林 解弱体
        // 阵容3：借高宝黑杯三藏 无视是否解弱体
        // （阵容1和2之间只差是否需要玛尔达解弱体）
        return force2()
    }

    private fun buildHeader(): String {
        val dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
        return "# $dateTime\r\ncount = 1\r\nspeed = 1.0\r\nstart data >>\r\n"
    }

}