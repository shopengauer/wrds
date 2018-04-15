package com.pavlovens.wordisserver.files

import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException


/**
 *  Функции для работы с файловой сиситемой)
 */
object FileUtils {

    /**
     * Создает путь состоящий из пути к UserDirectory + путь заданный в path
     * @param path - относительный путь к базовой директории
     * @return File
     */
    fun getPath(path : String = "/base/", childPath: String = "") : File = FileUtils.getFile(File(FileUtils.getUserDirectoryPath(), path + childPath))


    /**
     *  Создает директорию с путем UserDirectory + путь заданный в path
     *  @param path - путь к дочерней директории
     *  @return признак того что директория создана - true
     */
    fun createDir(path: File) : Boolean = !path.exists() && path.mkdirs()


    /**
     * Создает пустой файл в заданной дочерней директории
     * @param path - относительный путь к дочерней директории
     * @param fileName - имя файла
     * @return true - в случае успешного создания файла, false - если файл уже существует
     */
    @Throws(IOException::class)
    fun createEmptyFileInDir(path: File, fileName: String) : Boolean =
            FileUtils.getFile(path, fileName).createNewFile()

    /**
     * Создает пустые файлы с именами указанными в списке
     * @param path - путь к директории
     * @param fileNames - список имен файлов
     */

    @Throws(IOException::class)
    fun createEmptyFilesInBaseDir(path: File, fileNames: List<String>) {
        for (fileName in fileNames) {
            createEmptyFileInDir(path, fileName)
        }
    }

    /**
     * Удаляет файл с указанным именем
     *
     * @param basePath - относительный путь к дочерней директории
     * @param fileName - имя файла
     * @return true - если файл успешно удален, false - иначе
     */

    fun deleteFileInBaseDir(basePath: String, fileName: String): Boolean =
            FileUtils.getFile(getPath(basePath), fileName).delete()

    /**
     * Удаляет файлы с указанными именами в списке
     * @param basePath - относительный путь к дочерней директории
     * @param fileNames - список с именами файлов
     */
    fun deleteFilesInBaseDir(basePath: String, fileNames: List<String>) {
        for (fileName in fileNames) {
            deleteFileInBaseDir(basePath, fileName)
        }
    }

    /**
     * Удаляет все файлы в указанной дочерней директории
     * @param path - относительный путь к дочерней директории
     *
     */
    @Throws(IOException::class)
    fun deleteAllFilesInBaseDir(path: File) : Unit = FileUtils.cleanDirectory(path)


    /**
     * Удаляет директорию со всем содержимым
     * @param path - относительный путь к дочерней директории
     *
     */
    fun deleteBaseDir(path: File): Boolean = FileUtils.getFile(path).delete()



}