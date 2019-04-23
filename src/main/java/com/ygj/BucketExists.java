package com.ygj;

import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BucketExists {

    /**
     * MinioClient.bucketExists() example.
     */
    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, XmlPullParserException {
        try {
      /* play.minio.io for test and development. */
            MinioClient minioClient = new MinioClient("http://s3.yingzi.com:80", "minio", "minio123");

      /* Amazon S3: */
            // MinioClient minioClient = new MinioClient("https://s3.amazonaws.com", "YOUR-ACCESSKEYID",
            //                                           "YOUR-SECRETACCESSKEY");

            // Check whether 'my-bucketname' exist or not.
            boolean found = minioClient.bucketExists("my-bucketname");
            if (found) {
                System.out.println("my-bucketname exists");
            } else {
                System.out.println("my-bucketname does not exist");
            }
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
