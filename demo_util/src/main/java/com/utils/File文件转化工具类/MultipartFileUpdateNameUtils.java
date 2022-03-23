package com.utils.File文件转化工具类;

import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/29 0:29
 */
@Component
public class MultipartFileUpdateNameUtils {

    /**
     * MultipartFile修改文件名
     * @param multipartFile 文件
     * @param filename 目标文件名
     * @return
     */
    public MultipartFile updateName(MultipartFile multipartFile, String filename) {
        MultipartFile resultFile = null;
        InputStream inputStream = null;
        if (multipartFile != null && !multipartFile.isEmpty()) {

            String originalFilename = multipartFile.getOriginalFilename();
            // 后缀名
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            filename += suffixName;
            // 生成临时file文件(在项目根目录下)
            File file= new File(filename);

            try {
                // 将MultipartFile类型的资源转为File
                multipartFile.transferTo(file);
                inputStream= new FileInputStream(file);
                // 将file改名后转成MultipartFile类型
                resultFile = new MockMultipartFile(file.getName(),file.getName(),
                        ContentType.APPLICATION_OCTET_STREAM.toString(),inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (null != inputStream) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // 转化完毕,删除项目根目录的临时存储文件
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        return resultFile;
    }
}
