package com.pavlovens.wordisserver

import com.pavlovens.wordisserver.files.FileUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FileUtilsTests {

    @Value("\${server.filepath.base}")
    lateinit var basePath:String

    @Before
    fun setUp() {
        FileUtils.deleteBaseDir(basePath)
    }

    @Test
    fun createDirectoryTest() {
        val path = FileUtils.getPath(path = basePath, childPath = "upload/")

        Assert.assertFalse(path.exists())

        val isDirCreated = FileUtils.createDir(path = basePath)
        Assert.assertTrue(isDirCreated)

   //     val isFileCreated = FileUtils.

     //   val isDirDeleted = FileUtils.
    }
}