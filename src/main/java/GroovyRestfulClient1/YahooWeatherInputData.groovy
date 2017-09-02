package GroovyRestfulClient1

/**
 * Created by REUVENI on 19-Aug-17.
 */
class YahooWeatherInputData {

    def location
    def endPoint
    def paramValues

    String getLocation() {
        return location
    }

    void setLocation(String location) {
        this.location = location
    }

    String getEndPoint() {
        return endPoint
    }

    void setEndPoint(String endPoint) {
        this.endPoint = endPoint
    }

    String getParamValues() {
        return paramValues
    }

    void setParamValues(String paramValues) {
        this.paramValues = paramValues
    }

    private static String requestParamsBuilder (String paramValues){

        def valuesEncoded = URLEncoder.encode(paramValues, 'UTF-8')
        def params = [q: valuesEncoded]

        def requestParams = params.collect { it }.join('&')
        return requestParams
    }

    private static String requestUrlBuilder(String endPoint, String requestParams){
        def url = "$endPoint$requestParams"
        return url
    }


    @Override
    String toString() {
        def requestParams = requestParamsBuilder(paramValues)
        return "YahooWeatherInputData{" +
                "location='" + location + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", paramValues='" + paramValues + '\'' +
                ", url='" + requestUrlBuilder(endPoint,requestParams) + '\'' +
                '}'
    }

}
