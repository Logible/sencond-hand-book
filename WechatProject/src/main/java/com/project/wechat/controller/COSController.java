package com.project.wechat.controller;

import com.project.wechat.dto.PathListObj;
import com.project.wechat.service.Impl.COSService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/COSOperate")
public class COSController {
    @Autowired
    private COSService cosService;

    @RequestMapping("/toUpload")
    public String toUploadPage(){
        return "upload";
    }

    @ApiOperation("上传单张图片Test")
    @RequestMapping("/uploadUserAvatar")
    @ResponseBody
    public String uploadPic(HttpServletRequest request) throws IOException {
        String openid = request.getParameter("openid");
        MultipartHttpServletRequest multipartHttpServletRequest =
                (MultipartHttpServletRequest) request;
        MultipartFile mf = multipartHttpServletRequest.getFile("file");
        byte[] imageByte = mf.getBytes();
        InputStream in = new ByteArrayInputStream(imageByte);


        return cosService.upload(in,openid);
    }

}
