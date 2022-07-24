package com.utils.日常api.File文件转化工具类;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.Objects;

/**
 * @项目名称：dossen-observatory-api
 * @类名称：FileUtil
 * @类描述：文件工具类
 * @创建人：万星明
 * @创建时间：2020/10/23
 */
public final class FileUtil {

    /**
     * 输入流转File文件对象
     * @param inputStream 输入流
     * @param file 文件对象
     */
    private static void inputStreamToFile(InputStream inputStream, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inputStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            inputStream.close();
        } catch (Exception e) {
            System.err.println("File工具类:输入流转File文件对象异常!"+e);
        }
    }


    /**
     * MultipartFile对象转File文件对象
     * @param multipartFile  MultipartFile对象
     * @return File文件对象
     */
    public static File multipartFileToFile(MultipartFile multipartFile){
        File file = null;
        try {
            if (multipartFile==null || multipartFile.getSize() <= 0) {
                return null;
            } else {
                InputStream inputStream = multipartFile.getInputStream();
                file = new File( Objects.requireNonNull( multipartFile.getOriginalFilename() ) );
                inputStreamToFile(inputStream, file);
                inputStream.close();
            }
        }catch (IOException e) {
            System.err.println("File工具类:MultipartFile对象转File文件对象异常!"+e);
        }
        return file;
    }


    /**
     * 将文件File转成Base64
     * @param file 文件
     * @return Base64
     */
    public static String getFileBase64(File file){
        InputStream in = null;
        byte[] data = null;
        try{
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }


}
