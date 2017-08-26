package GroovyRestfulClient1

import groovy.json.JsonSlurper

/**
 * Created by REUVENI on 11-Aug-17.
 */

def location = "Stockholm, Sweden"
def endPoint = "https://query.yahooapis.com/v1/public/yql?"
def paramValues = "select item " +
        "from weather.forecast where woeid in " +
        "(select woeid from geo.places(1) " +
        "where text='$location')"
def valuesEncoded = URLEncoder.encode(paramValues, 'UTF-8')
def params = [q: valuesEncoded]

def requestParams = params.collect { it }.join('&')

String url = "$endPoint$requestParams"

def connection = new URL(url).openConnection() as HttpURLConnection


// set some headers
connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
connection.setRequestProperty( 'Accept', 'application/json' )

if ( connection.responseCode == 200 ) {
    // get the JSON response
    def json = connection.inputStream.withCloseable { inStream ->
        new JsonSlurper().parse( inStream as InputStream )
    }


    // extract some data from the JSON, printing a report
    def item = json.query.results.channel.item
    println item.title
    println "Temperature: ${item.condition?.temp}, Condition: ${item.condition?.text}"

    // show some forecasts
    println "Forecasts:"
    item.forecast.each { f ->
        println " * ${f.date} - Low: ${f.low}, High: ${f.high}, Condition: ${f.text}"
    }
} else {
    println connection.responseCode + ": " + connection.inputStream.text
}

