import combat.Battle
import combat.casefile.CaseFileLineup
import utils.Deploy
import utils.FileUtils

fun main(args: Array<String>) {
    Main()
}

class Main {
    init {
        val fileName = "christmas2020pool.mks"
        val destPath = "/storage/emulated/0/$fileName"
        val battle: Battle = CaseFileLineup()
        val result = battle.buildScript()
        println(result)
        FileUtils.writeFile(fileName, result)
        val deploy = Deploy()
        deploy.adbConnect("127.0.0.1:7555")
        deploy.deploy(fileName, destPath)
    }
}