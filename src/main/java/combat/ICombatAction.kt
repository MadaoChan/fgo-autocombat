package combat

interface ICombatAction {
    /**
     * 从者技能（无指向）
     * @param skill 技能编号 (1/2/3)
     * @param from 从者编号 (1/2/3)
     * @param wait 等待技能完成时间
     * @return MonkeyScript语句
     */
    fun servantSkill(skill: Int, from: Int, wait: Long): String

    /**
     * 从者技能（有指向）
     * @param skill 技能编号 (1/2/3)
     * @param from 从者编号 (1/2/3)
     * @param to 目标编号 (1/2/3)
     * @param isFriendly 是否友军
     * @param wait 等待技能完成时间
     * @return MonkeyScript语句
     */
    fun servantSkill(skill: Int, from: Int, to: Int, isFriendly: Boolean, wait: Long): String

    /**
     * 打开御主技能
     */
    fun openMasterSkill(): String

    /**
     * 御主技能（无指向）
     * @param skill 技能编号 (1/2/3)
     * @param wait 等待技能完成时间
     * @return MonkeyScript语句
     */
    fun masterSkill(skill: Int, wait: Long): String

    /**
     * 御主技能（有指向）
     * @param skill 技能编号 (1/2/3)
     * @param to 目标编号 (1/2/3)
     * @param isFriendly 是否友军
     * @param wait 等待技能完成时间
     * @return MonkeyScript语句
     */
    fun masterSkill(skill: Int, to: Int, isFriendly: Boolean, wait: Long): String

    /**
     * 换人（换人服限定）
     * @param servantLeave 换出从者编号（1/2/3/4/5/6）
     * @param servantCome 换入从者编号（1/2/3/4/5/6）
     * @return MonkeyScript语句
     */
    fun changeServant(servantLeave: Int, servantCome: Int): String

    /**
     * 点攻击按键
     * @return MonkeyScript语句
     */
    fun openAttack(): String

    /**
     * 普攻选卡
     * @param order 普攻卡编号（1/2/3）
     * @return MonkeyScript语句
     */
    fun attack(order: Int): String

    /**
     * 宝具选卡
     * @param order 宝具卡（1/2/3）
     * @return MonkeyScript语句
     */
    fun noblePhantasm(order: Int): String

    /**
     * 等待
     * @param time 等待时间（毫秒）
     * @return MonkeyScript语句
     */
    fun userWait(time: Long): String

    /**
     * 点击等待（比较短）
     * @param time 等待时间（毫秒）
     * @return MonkeyScript语句
     */
    fun userClickWait(time: Long): String

    /**f
     * 结算画面点击
     */
    fun battleFinish(): String
}