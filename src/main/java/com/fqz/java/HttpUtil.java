package com.fqz.java;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/9
 * Time: 12:02
 */
public class HttpUtil {
    //HttpClient implementations are expected to be thread safe. It is recommended that the same instance of this class is reused for multiple request executions.
    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    public static String getResource(String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("content-type","application/json");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try{
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity);
            return body;
        }finally {
            if(response != null)
                response.close();
        }
    }

    public static String getResourceWithParameters(String url) throws IOException, URISyntaxException {
        HttpGet httpGet = new HttpGet(url);
        URI uri = new URIBuilder().setParameter("key","value").build();
        httpGet.setURI(uri);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try{
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity);
            return body;
        }finally {
            if(response != null)
                response.close();
        }
    }

    //A request for a route for which the manager already has a persistent connection available in the
    // pool will be serviced by leasing a connection from the pool rather than creating a brand new connection.
    public static String getResourceWithConnectionPool(String url) throws IOException, URISyntaxException {
        HttpGet httpGet = new HttpGet(url);
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try{
            HttpEntity entity = response.getEntity();
            String body = EntityUtils.toString(entity);
            return body;
        }finally {
            if(response != null)
                response.close();
        }
    }

}
