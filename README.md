# fgo-autocombat
FGO自动战斗（国服2020圣诞节无限池）

## 实现原理：

因本次无限池最终票本可以使用双CBA孔明女武神的阵容进行3T速刷，相当机械。故此可以进行脚本化操作。

通过本程序生成Monkey脚本，部署到目标Android设备上运行，从而达到自动战斗的目的。

因据闻国服运营会根据用户点击位置而判断用户使用脚本操作，故此在每次点击的时候都在X和Y轴上加入，使每场战斗都不会点击在同一个位置。而且每次点击之间的等待时间也加上随机值。从而减少被封号的风险。

## 适用场合：

Windows平台下的MuMu模拟器，分辨率1280*720

### MuMu模拟器的ADB链接方式：

#### Windows
adb connect 127.0.0.1:7555

#### Mac
adb kill-server
adb server

## 原始操作脚本
详见example.mks

### 示例阵容

前排：CBA（技能全满） 女武神（90级1宝） 助战CBA（1，3技能必须满）

后排：孔明（技能满全满） 其余两个位任意

礼装：女武神带50NP初始礼装，其余所有人带加成礼装

御主礼装：换人服

####
操作步骤：

##### 1T

双CBA释放绿魔放给女武神，助战CBA放充能给女武神。女武神自身绿魔放开启，NP充能开启。女武神宝具，回收60NP。

##### 2T

助战CBA降防可开可不开。助战CBA换入孔明，孔明释放1、3技能。女武神宝具，回收约55~58%NP。

##### 3T

CBA开启降防并充能女武神，御主衣服加攻。御主衣服晕眩BOSS。女武神宝具。视情况4T补刀结束战斗。
