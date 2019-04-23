package com.ygj;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class StatObject {
    /**
     * MinioClient.statObject() example.
     */
    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, XmlPullParserException {
        try {
      /* play.minio.io for test and development. */
            MinioClient minioClient = new MinioClient("http://s3.yingzi.com:80", "minio", "minio123");

      /* Amazon S3: */
            // MinioClient minioClient = new MinioClient("https://s3.amazonaws.com", "YOUR-ACCESSKEYID",
            //                                           "YOUR-SECRETACCESSKEY");

            // Get object stat information.
            ObjectStat objectStat = minioClient.statObject("asiatrip", "bad/test/dcos_generate_config.sh");
            System.out.println(objectStat);
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
