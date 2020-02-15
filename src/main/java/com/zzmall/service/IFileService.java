package com.zzmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zz on 2018/5/12.
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
