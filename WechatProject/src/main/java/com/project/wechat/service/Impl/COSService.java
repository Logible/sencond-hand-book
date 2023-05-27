package com.project.wechat.service.Impl;

import com.project.wechat.dto.PathListObj;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class COSService {
    private final String COS_SECRETID = "AKIDPcbMtBF5g3FDwRhjW4kBPO8h291e3FCH";
    private final String COS_SECRETKEY = "tZ2IMCqHVWKvJUSDm8HCuRkrlRs67ygG";
    private final String BUCKET_NAME = "dragon-1304210912";
    private final String COS_REGION = "ap-guangzhou";

    //初始化COSClient
   private COSClient initCOSClient(){
        // 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = COS_SECRETID;
        String secretKey = COS_SECRETKEY;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region(COS_REGION);
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
       return  new COSClient(cred, clientConfig);
    }

    //上传单张图片
    public String uploadPic(String localFilePath,String openId){
       COSClient cosClient = initCOSClient();
        // 指定要上传的文件
        File localFile = new File(localFilePath);
        // 指定文件将要存放的存储桶
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = openId + "_" +  System.currentTimeMillis() + ".jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        cosClient.shutdown();

        String status = putObjectResult.getETag();
        return status != null?
                "https://" + BUCKET_NAME + ".cos." + COS_REGION + ".myqcloud.com/" + key
                :"upload failed";
    }


    //upload
    public String upload(InputStream image, String openId) throws IOException {
        COSClient cosClient = initCOSClient();

        String key = openId + "_" +  System.currentTimeMillis() + ".jpg";
        ObjectMetadata objectMetadata = new ObjectMetadata();
        // 设置输入流长度
        objectMetadata.setContentLength(image.available());
        // 设置 Content type, 默认是 application/octet-stream
        objectMetadata.setContentType("image/jpeg");
        PutObjectResult putObjectResult = cosClient.putObject(BUCKET_NAME, key, image, objectMetadata);
        String etag = putObjectResult.getETag();
        System.out.println(etag);

        cosClient.shutdown();

        return "https://" + BUCKET_NAME + ".cos." + COS_REGION + ".myqcloud.com/" + key;
    }
}
