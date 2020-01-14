package combat

open class Battle: IBattle {

    protected lateinit var action: ICombatAction

    override fun buildScript(): String {
        return ""
    }
}