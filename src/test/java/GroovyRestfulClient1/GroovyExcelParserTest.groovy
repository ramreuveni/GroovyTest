package GroovyRestfulClient1

import org.apache.poi.ss.usermodel.Row
import org.junit.Test

/**
 * Created by REUVENI on 18-Aug-17.
 */
class GroovyExcelParserTest extends GroovyTestCase {

    @Test
    public void testYahooWeatherApi() throws Exception {
        def filename = 'C:\\Users\\REUVENI\\IdeaProjects\\GroovyTest\\src\\main\\resources\\data1.xlsx'
        def parser = new GroovyExcelParser()
        def(headers, rows) = parser.parse(filename)
        println '------------------'
        rows.each {
            row ->
                headers.eachWithIndex {
                    header, index ->
                        println(header + ": " + row[index])

                }
        }
    }

    @Test
    public void testExcelParserToApiRequest(){
        def filename = 'C:\\Users\\REUVENI\\IdeaProjects\\GroovyTest\\src\\main\\resources\\data1.xlsx'
        def parser = new GroovyExcelParser()
        def(headers, rows) = parser.parse(filename)

        def weatherInfo = new YahooWeatherInputData()

        rows.each {
            row ->

                        weatherInfo.setLocation(row[0])
                        weatherInfo.setEndPoint(row[1])
                        weatherInfo.setParamValues(row[2])
                        println(weatherInfo.toString())

        }

    }
}
