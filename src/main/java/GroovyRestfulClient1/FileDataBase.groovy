package GroovyRestfulClient1

/**
 * Created by REUVENI on 02-Sep-17.
 */
class FileDataBase {

    def fileName
    def fileType
    def fileLocation

    FileDataBase(fileName) {
        this.fileName = fileName
        this.fileType = "MEDIA"
        this.fileLocation = "File/Location/Path"
    }


}
