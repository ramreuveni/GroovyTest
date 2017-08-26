package GroovyRestfulClient1

import groovy.json.JsonSlurper

/**
 * Created by REUVENI on 19-Aug-17.
 */
class GroovyRestClient {


    def getRestJsonResponse(String url){
        def connection = new URL(url).openConnection() as HttpURLConnection
// set some headers
        connection.setRequestProperty( 'User-Agent', 'groovy-2.4.4' )
        connection.setRequestProperty( 'Accept', 'application/json' )

        if ( connection.responseCode == 200 ) {
            // get the JSON response
            def json = connection.inputStream.withCloseable { inStream ->
                new JsonSlurper().parse(inStream as InputStream)
            }
        }
        else {
            println connection.responseCode + ": " + connection.inputStream.text
        }


    }
}
