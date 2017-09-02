package GroovyRestfulClient1

import groovy.json.*
import groovy.io.FileType.*
import org.junit.Test
import java.util.Properties

/**
 * Created by REUVENI on 02-Sep-17.
 */
class FileDataBaseTest extends GroovyTestCase {


    @Test
    void testFlow() {

        Properties prop = new Properties()
        File propertiesFile = new File('C:\\Users\\REUVENI\\IdeaProjects\\GroovyTest\\src\\main\\resources\\test.properties')
        propertiesFile.withInputStream {
            prop.load(it)
        }

        /*
        Set initial JSON file with one FileDataBase object
         */
        def jsonFile = new File('C:\\Users\\REUVENI\\IdeaProjects\\GroovyTest\\src\\main\\resources\\json1.json')
        def fileData1 = new FileDataBase( 'InitialFileName' )
        jsonFile.append(new JsonBuilder( fileData1 ).toPrettyString())
        println(jsonFile.getText('UTF-8'))

        /*
        Get all files from directory
         */
        def filesList = [];
        def dirPAth = prop.getProperty('filesDirPath')
        def dir = new File(dirPAth);
        dir.eachFileRecurse(){file ->
            filesList << file
        }

        /*
        Append each file as FileDataBase object to JSON file
         */
        filesList.each {
            def s=(it.path).substring(8)
            def fileDataObj = new FileDataBase(s)
            jsonFile << new JsonBuilder( fileDataObj ).toPrettyString()
        }

        println(jsonFile.getText('UTF-8'))
    }
}
