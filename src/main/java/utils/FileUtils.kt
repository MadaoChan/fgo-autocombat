package utils

import java.io.File

class FileUtils() {
    companion object {
        fun writeFile(name: String, content: String) {
            val file = File(name)
            file.writeText(content)
        }
    }
}