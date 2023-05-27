package com.project.wechat.service.Impl;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.project.wechat.dao.DataPoDao;
import com.project.wechat.dao.UserPoDao;
import com.project.wechat.dto.ISBNPo;
import com.project.wechat.mbg.pojo.DataPo;
import com.project.wechat.mbg.pojo.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
* 调用外部接口的方法
* */
@Service
public class ExternalService {
    @Autowired
    private DataPoDao dataPoDao;
    private static final String SECRET_ID = "AKIDPcbMtBF5g3FDwRhjW4kBPO8h291e3FCH";
    private static final String SECRET_KEY = "tZ2IMCqHVWKvJUSDm8HCuRkrlRs67ygG";

    private static String calcAuthorization(String source, String secretId, String secretKey, String datetime)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String signStr = "x-date: " + datetime + "\n" + "x-source: " + source;
        Mac mac = Mac.getInstance("HmacSHA1");
        Key sKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), mac.getAlgorithm());
        mac.init(sKey);
        byte[] hash = mac.doFinal(signStr.getBytes("UTF-8"));
        String sig = new BASE64Encoder().encode(hash);

        String auth = "hmac id=\"" + secretId + "\", algorithm=\"hmac-sha1\", headers=\"x-date x-source\", signature=\"" + sig + "\"";
        return auth;
    }

    private static String urlencode(Map<?, ?> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(String.format("%s=%s",
                    URLEncoder.encode(entry.getKey().toString(), "UTF-8"),
                    URLEncoder.encode(entry.getValue().toString(), "UTF-8")
            ));
        }
        return sb.toString();
    }

    public String getBookInfoByIsbn(String Isbn) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String source = "market";

        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String datetime = sdf.format(cd.getTime());
        // 签名
        String auth = calcAuthorization(source, SECRET_ID, SECRET_KEY, datetime);
        // 请求方法
        String method = "GET";
        // 请求头
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("X-Source", source);
        headers.put("X-Date", datetime);
        headers.put("Authorization", auth);

        // 查询参数
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("isbn", Isbn);
        // body参数
        Map<String, String> bodyParams = new HashMap<String, String>();

        // url参数拼接
        String url = "https://service-osj3eufj-1255468759.ap-shanghai.apigateway.myqcloud.com/release/isbn";
        if (!queryParams.isEmpty()) {
            url += "?" + urlencode(queryParams);
        }

        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod(method);

            // request headers
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }

            // request body
            Map<String, Boolean> methods = new HashMap<>();
            methods.put("POST", true);
            methods.put("PUT", true);
            methods.put("PATCH", true);
            Boolean hasBody = methods.get(method);
            if (hasBody != null) {
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                conn.setDoOutput(true);
                DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                out.writeBytes(urlencode(bodyParams));
                out.flush();
                out.close();
            }

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String result = "";
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }

            return result;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /*
    * 实现转成DataPo(自己实现)
    * */
    public DataPo StringToDataPo(String bookInfo){
        String jsonTest = bookInfo;
        JSONObject jsonObject = JSONObject.parseObject(jsonTest);
        JSONObject showapi_res_body = jsonObject.getJSONObject("showapi_res_body");
        ISBNPo isbnPo = JSONObject.parseObject(showapi_res_body.toString(),new TypeReference<ISBNPo>(){});
        return isbnPo.getData();
    }
    /*
    * 将自己isbn表没有的数据插入
    * */
    public boolean insertISBN(DataPo dataPo){
        return dataPoDao.insertIntoData(dataPo) > 0;
    }
}
