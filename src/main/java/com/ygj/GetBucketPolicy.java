package com.ygj;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import io.minio.policy.PolicyType;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class GetBucketPolicy {
    /**
     * MinioClient.getBucketPolicy() example.
     */
    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, XmlPullParserException {
        try {
      /* play.minio.io for test and development. */
            MinioClient minioClient = new MinioClient("http://s3.yingzi.com:80", "minio", "minio123");
      /* Amazon S3: */
            // MinioClient minioClient = new MinioClient("https://s3.amazonaws.com", "YOUR-ACCESSKEYID",
            //                                           "YOUR-SECRETACCESSKEY");

            Map<String, PolicyType> policy = minioClient.getBucketPolicy("01new");
            System.out.println("Current policy: " + policy);
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
