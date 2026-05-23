package com.sky.controller.admin;


import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static com.sky.constant.MessageConstant.UPLOAD_FAILED;

@RestController
@RequestMapping("/admin/common")
@Slf4j
@Api(tags = "通用接口")
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    //图片的上传
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        log.info("文件上传：{}",file);
        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取.前边的文件名
            String split = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构建新文件名称uuid
            String objectname = UUID.randomUUID().toString() + split;
            String filePath = aliOssUtil.upload(file.getBytes(),objectname );
            log.info("文件上传成功：{}",filePath);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败",e);
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }

}
