package main.kotlin

import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import javax.imageio.ImageIO

const val DEFAULT_WALLPAPER_FOLDER_PATH =
    "C:\\Users\\kosty\\AppData\\Local\\Packages\\Microsoft.Windows.ContentDeliveryManager_cw5n1h2txyewy\\LocalState\\Assets"
const val DESTINATION_FOLDER_WITH_WALLPAPERS = "F:\\Image\\тема\\wallpaper"

fun main() {

    val tempDir = createTempDir("wallpaper-", "-tmp")
    val destinationFolder = File(DESTINATION_FOLDER_WITH_WALLPAPERS)

    val defaultWallpaperFilesList = File(DEFAULT_WALLPAPER_FOLDER_PATH).listFiles()
    val wallpaperFilesInTempDir = addExtensionAndCopyToTempDir(defaultWallpaperFilesList, tempDir)
    val selectedImages = selectWallpapers(wallpaperFilesInTempDir)

    selectedImages.forEach{
        val destinationFile = File("${destinationFolder.absolutePath}/${it.name}").toPath()
        Files.copy(it.toPath(), destinationFile, StandardCopyOption.REPLACE_EXISTING)
    }

    tempDir.deleteRecursively()
}

fun addExtensionAndCopyToTempDir(defaultWallpaperFilesList: Array<File>?, tempDir: File): List<File> {
    val wallpaperFilesInTempDir: MutableList<File> = ArrayList()

    if (defaultWallpaperFilesList != null) {
        for (file in defaultWallpaperFilesList) {
            val destinationFile = File("${tempDir.absolutePath}/${file.nameWithoutExtension}").toPath()
            val tmp = Files.copy(file.toPath(), destinationFile, StandardCopyOption.REPLACE_EXISTING).toFile()
            val newFile = File("${tempDir.absolutePath}/${tmp.nameWithoutExtension}.jpg")
            if (tmp.renameTo(newFile)) {
                wallpaperFilesInTempDir.add(newFile)
            }
        }
    }

    return wallpaperFilesInTempDir
}

fun selectWallpapers(files: List<File>): List<File> {
    val selectedImages: MutableList<File> = ArrayList()
    if (files.isNotEmpty()) {
        for (file in files){
            val img = ImageIO.read(file)
            val width = img.width
            val height = img.height

            if(width > 1500 && height > 1000){
                selectedImages.add(file)
            }
        }
    }

    return selectedImages
}