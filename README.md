# fgo-autocombat
FGO自动战斗（国服2020淑女莱妮丝事件簿活动巴巴托斯魔神柱讨伐战）

## 实现原理：

### 巴巴托斯魔神柱讨伐战
50万血的杀阶魔神柱讨伐战，使用狂阶水黑贞（带黑杯）/高宝三藏（带满破黑杯）当打手，配合梅林进行1T快速击杀。

因为巴巴托斯有随机色卡Down这种异常恶心的机制存在，所以要安排副拐来解弱体。

翻看大佬的文章，副拐首推枪赖光，可惜小弟没有。第二推荐为玛尔达，拥有解弱体和降防御。借到三藏的话还能直接用极地服即可。

### 2020圣诞无限池终本
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

#### 巴巴托斯魔神柱讨伐战

##### 情况1：借到梅林

前排：狂贞（带100级醉贞，2、3技能10） 梅林（羁绊礼装，1、3技能满） 助战梅林（羁绊礼装或者牛魔王最佳，1、3技能满）

后排：玛尔达（3技能满，带牛魔王礼装） 其余两个位任意

御主礼装：换人服

操作流程：狂贞开23技能；双梅林13开技能；玛尔达换助战梅林，23技能开；御主礼装加攻；然后放宝具。根据微信素材规划小程序计算，伤害下限刚好超过50万。

##### 情况2：借到高宝三藏（三宝以上为佳）

前排：助战三藏（带100级黑杯，1技能10）莎士比亚（3技能10） 梅林（羁绊礼装或者牛魔王最佳，1、3技能满）

后排：随意

御主礼装：极地服

操作流程：三藏1技能；莎士比亚3技能；梅林13技能给三藏；御主礼装1技能解弱体，2技能加攻；然后攻击即可

#### 2020圣诞活动无限池

前排：CBA（技能全满） 女武神（90级1宝） 助战CBA（1，3技能必须满）

后排：孔明（技能满全满） 其余两个位任意

礼装：女武神带50NP初始礼装，其余所有人带加成礼装

御主礼装：换人服

##### 1T

双CBA释放绿魔放给女武神，助战CBA放充能给女武神。女武神自身绿魔放开启，NP充能开启。女武神宝具，回收60NP。

##### 2T

助战CBA降防可开可不开。助战CBA换入孔明，孔明释放1、3技能。女武神宝具，回收约55~58%NP。

##### 3T

CBA开启降防并充能女武神，御主衣服加攻。御主衣服晕眩BOSS。女武神宝具。视情况4T补刀结束战斗。
