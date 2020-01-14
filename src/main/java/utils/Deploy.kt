package utils

import java.io.File
import java.lang.Exception

class Deploy {

    fun deploy(srcPath: String, destPath: String, count: Int=1) {
        val file = File(srcPath)
        if (!file.exists()) {
            println("脚本文件不存在！")
            return
        }
        val adbPush = "adb push $srcPath $destPath"
        if (runCmd(adbPush)) {
            val monkey = "adb shell monkey -f $destPath $count"
            runCmd(monkey)
        }
    }

    private fun runCmd(cmd: String): Boolean {
        var isSuccess = false
        try {
            val process = Runtime.getRuntime().exec(cmd)
            val exitValue = process.waitFor()
            if (exitValue != 0) {
                println("命令 $cmd 执行失败，返回码$exitValue")
            } else {
                isSuccess = true
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            return isSuccess
        }
    }
}