package com.zzmall.service.impl;

import com.google.common.collect.Lists;
import com.zzmall.service.IFileService;
import com.zzmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by zz on 2018/5/12.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path){
        //得到上传时的文件名
        String fileName = file.getOriginalFilename();
        //获取文件扩展名(jpg)
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //为了避免上传文件时会有重名的麻烦，使用UUID得到上传时的文件名
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        logger.info("开始上传文件，上传的文件名:{},上传的路径:{},新文件名:{}", fileName, path, uploadFileName);

        //上传路径文件夹是否存在，如果不存在则创建
        File fileDir = new File(path);
        if(!fileDir.exists()){
            //设置文件夹为可写操作
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);
        try {
            file.transferTo(targetFile);
            //到此为止已上传文件成功
            //将target文件上传到FTP服务器上
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //删除掉upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }
        return targetFile.getName();
    }
}
