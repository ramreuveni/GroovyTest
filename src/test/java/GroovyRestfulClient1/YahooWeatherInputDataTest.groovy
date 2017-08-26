package GroovyRestfulClient1

import org.junit.Test

/**
 * Created by REUVENI on 19-Aug-17.
 */
class YahooWeatherInputDataTest extends GroovyTestCase {

    @Test
    void testToString() {
        def location = "Stockholm, Sweden"
        def endPoint = "https://query.yahooapis.com/v1/public/yql?"
        def paramValues = "select item " + "from weather.forecast where woeid in " +
                "(select woeid from geo.places(1) " + "where text='$location')"

        def weatherInfo = new YahooWeatherInputData()

        weatherInfo.setLocation(location)
        weatherInfo.setEndPoint(endPoint)
        weatherInfo.setParamValues(paramValues)

        println(weatherInfo.toString())
    }
}
