package com.pavlovens.wordisserver.files

import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException

/**
 *  Функции для работы с файловой сиситемой)
 */

/**
 *  Создает путь состоящий из пути к UserDirectory + путь заданный в childPath
 *
 * @param childPath - относительный путь к дочерней директории
 * @return File
 */
fun getBasePath(childPath: String) : File = FileUtils.getFile(File(FileUtils.getUserDirectoryPath(), childPath))

/**
 *  Создает директорию с путем UserDirectory + путь заданный в childPath
 *
 *  @param childPath - относительный путь к дочерней директории
 *  @return признак того что директория создана - true
 *
 */
fun createBaseDir(childPath: String) : Boolean = !getBasePath(childPath).exists() && getBasePath(childPath).mkdirs()


/**
 * Создает пустой файл в заданной дочерней директории
 *
 *  @param childPath - относительный путь к дочерней директории
 *  @param fileName - имя файла
 *  @return true - в случае успешного создания файла, false - если файл уже существует
 */
@Throws(IOException::class)
fun createEmptyFileInBaseDir(childPath: String, fileName: String) : Boolean =
     FileUtils.getFile(getBasePath(childPath), fileName).createNewFile()

/**
 * Создает пустые файлы с именами указанными в списке
 *
 * @param childPath - относительный путь к дочерней директории
 * @param fileNames - список имен файлов
 */

@Throws(IOException::class)
fun createEmptyFilesInBaseDir(childPath: String, fileNames: List<String>) {
    for (fileName in fileNames) {
        createEmptyFileInBaseDir(childPath, fileName)
    }
}

/**
 * Удаляет файл с указанным именем
 *
 * @param childPath - относительный путь к дочерней директории
 * @param fileName - имя файла
 * @return true - если файл успешно удален, false - иначе
 */

fun deleteFileInBaseDir(childPath: String, fileName: String): Boolean =
     FileUtils.getFile(getBasePath(childPath), fileName).delete()

/**
 * Удаляет файлы с указанными именами в списке
 *
 * @param childPath - относительный путь к дочерней директории
 * @param fileNames - список с именами файлов
 *
 */

fun deleteFilesInBaseDir(childPath: String, fileNames: List<String>) {
    for (fileName in fileNames) {
        deleteFileInBaseDir(childPath, fileName)
    }
}

/**
 * Удаляет все файлы в указанной дочерней директории
 *
 * @param childPath - относительный путь к дочерней директории
 *
 */
@Throws(IOException::class)
fun deleteAllFilesInBaseDir(childPath: String) : Unit = FileUtils.cleanDirectory(getBasePath(childPath))


/**
 *  
 * @param childPath - относительный путь к дочерней директории
 *
 */
fun deleteBaseDir(childPath: String): Boolean = FileUtils.getFile(getBasePath(childPath)).delete()





