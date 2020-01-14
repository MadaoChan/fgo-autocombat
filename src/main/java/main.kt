import combat.Battle
import combat.Christmas2020
import utils.Deploy
import utils.FileUtils

fun main(args: Array<String>) {
    Main()
}

class Main {
    init {
        val fileName = "christmas2020pool.mks"
        val destPath = "/storage/emulated/0/$fileName"
        val battle: Battle = Christmas2020()
        val result = battle.buildScript()
        println(result)
        FileUtils.writeFile(fileName, result)
        Deploy().deploy(fileName, destPath)
    }
}