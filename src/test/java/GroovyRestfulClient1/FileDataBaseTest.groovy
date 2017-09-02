package GroovyRestfulClient1

import groovy.json.*
import groovy.io.FileType.*

/**
 * Created by REUVENI on 02-Sep-17.
 */
class FileDataBaseTest extends GroovyTestCase {


    void testFlow() {

        def filesList = [];

        def dir = new File("D:\\Temp");
        dir.eachFileRecurse(FileType.FILES){file ->
            filesList << file
        }

        filesList.each {
            println it.path
        }


        def jsonFile = new File('C:\\Users\\REUVENI\\IdeaProjects\\GroovyTest\\src\\main\\resources\\json1.json')

        //def fileData1 = new FileDataBase( fileName:  )

        //println new JsonBuilder( fileData1 ).toPrettyString()

    }

}
