package wechat.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;

/** http客户端请求
 * className: HttpUtils
 * author: peishuai.li
 * dateTime: 2019/5/21 16:07
 * version: 1.0
 */
public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 发送http get请求
     * @param address 请求地址
     * @return 响应信息字符串
     */
    public static String sendGetHttp(String address) {
        return sendGet(address, "HTTP");
    }

    /**
     * 发送https get请求
     * @param address 请求地址
     * @return 响应信息
     */
    public static String sendGetHttps(String address) {
        return sendGet(address, "HTTPS");
    }

    private static String sendGet(String address, String type) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse chr = null;
        String msg = null;
        try {
            if ("HTTPS".equals(type)) {
                httpClient = createSSLInsecureClient();
            } else {
                httpClient = HttpClients.createDefault();
            }
            HttpGet httpGet = new HttpGet(address);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();
            httpGet.setConfig(requestConfig);
            httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");

            chr = httpClient.execute(httpGet);
            HttpEntity entity = chr.getEntity();
            if (null != entity) {
                msg = EntityUtils.toString(entity);
                // 关闭entity流
                EntityUtils.consume(entity);
            }

            log.info("url:{}, response:{}", address, msg);
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally {
            closeHttpClient(httpClient);
            closeHttpResponse(chr);
        }
        return msg;
    }

    /**
     * 创建https请求器
     */
    private static CloseableHttpClient createSSLInsecureClient() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (x509Certificates, s) -> true).build();
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(socketFactory).build();
        } catch (Exception e) {
            e.printStackTrace();
            return HttpClients.createDefault();
        }
    }

    /** 释放CloseableHttpResponse */
    private static void closeHttpResponse(CloseableHttpResponse chr) {
        if (null != chr) {
            try {
                chr.close();
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }
    }
    /** 释放CloseableHttpClient */
    private static void closeHttpClient(CloseableHttpClient httpClient) {
        if (null != httpClient) {
            try {
                httpClient.close();
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }
    }

}
