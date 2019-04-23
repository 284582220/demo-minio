package com.ygj;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // 使用Minio服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://s3.yingzi.com:80", "minio", "minio123");

//            minioClient.makeBucket("test001", "doc");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("test001");
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("test001");

            }

            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject("test001", "test/pom.xml", "D:\\code\\git\\kafka-eagle\\kafka-eagle-web\\pom.xml");
            System.out.println("/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
