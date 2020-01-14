package utils

class Global {

    companion object {
        // 初始位置
        // 16:9的情况下，均为0。但会存在不是16:9的设备
        var START_X = 0
        var START_Y = 0

        // 设备尺寸（可能会比游戏尺寸大）
        var DEVICE_WIDTH = 1280
        var DEVICE_HEIGHT = 720

        // 游戏可点区域的宽高
        var WIDTH = 1280
        var HEIGHT = 720

        // ———相对位置———
        // 技能
        const val SKILL_BIAS = 0.02     // 相对位置偏差
        const val SERVANT_SKILL_X_BASE = 0.127
        const val SERVANT_SKILL_Y_BASE = 0.8
        const val SERVANT_SKILL_X_DELTA = 0.073
        const val SERVANT_X_DELTA = 0.248

        // 指向性技能，从者选择
        const val SELECT_SERVANT_X_BASE = 0.25
        const val SELECT_SERVANT_Y_BASE = 0.6
        const val SELECT_SERVANT_X_DELTA = 0.25
        const val SELECT_SERVANT_X_BIAS = 0.05
        const val SELECT_SERVANT_Y_BIAS = 0.1

        // 攻击选卡
        const val CARD_X_BIAS = 0.021
        const val CARD_Y_BIAS = 0.105
        const val CARD_X_DELTA = 0.201
        const val SERVANT_ATT_X_BASE = 0.1
        const val SERVANT_ATT_Y_BASE = 0.713

        // 宝具选卡
        const val NP_X_BASE = 0.301
        const val NP_Y_BASE = 0.29

        // 攻击按键
        const val ATT_BUTTON_X = 0.88
        const val ATT_BUTTON_Y = 0.84
        const val ATT_BUTTON_X_BIAS = 0.03
        const val ATT_BUTTON_Y_BIAS = 0.11

        // 御主技能键
        const val MASTER_SKILL_OPEN_X_BASE = 0.934
        const val MASTER_SKILL_OPEN_Y_BASE = 0.434
        const val MASTER_SKILL_OPEN_X_BIAS = 0.012
        const val MASTER_SKILL_OPEN_Y_BIAS = 0.012

        // 御主技能释放
        const val MASTER_SKILL_X_BASE = 0.71
        const val MASTER_SKILL_Y_BASE = 0.43
        const val MASTER_SKILL_X_DELTA = 0.077
        const val MASTER_SKILL_X_BIAS = 0.02
        const val MASTER_SKILL_Y_BIAS = 0.03

        // 换人
        const val CHANGE_SERVANT_X_BASE = 0.108
        const val CHANGE_SERVANT_Y_BASE = 0.48
        const val CHANGE_SERVANT_X_DELTA = 0.156
        const val CHANGE_SERVANT_X_BIAS = 0.023
        const val CHANGE_SERVANT_Y_BIAS = 0.08

        // 换人确定键
        const val CHANGE_CONFIRM_X_BASE = 0.5
        const val CHANGE_CONFIRM_Y_BASE = 0.87
        const val CHANGE_CONFIRM_X_BIAS = 0.1
        const val CHANGE_CONFIRM_Y_BIAS = 0.04

        // 结算画面
        const val BATTLE_FINISH_X_BASE = 0.86
        const val BATTLE_FINISH_Y_BASE = 0.944
        const val BATTLE_FINISH_X_BIAS = 0.03
        const val BATTLE_FINISH_Y_BIAS = 0.03
    }
}