package com.ygj;

import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.MinioException;
import io.minio.messages.Item;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ListObjects {

    public static void main(String[] args)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, XmlPullParserException {
        try {
      /* play.minio.io for test and development. */
            MinioClient minioClient = new MinioClient("http://s3.yingzi.com:80", "minio", "minio123");

      /* Amazon S3: */
            // MinioClient minioClient = new MinioClient("https://s3.amazonaws.com", "YOUR-ACCESSKEYID",
            //                                           "YOUR-SECRETACCESSKEY");

            // Check whether 'my-bucketname' exist or not.
            boolean found = minioClient.bucketExists("asiatrip");
            if (found) {
                // List objects from 'my-bucketname'
                Iterable<Result<Item>> myObjects = minioClient.listObjects("asiatrip");
                for (Result<Item> result : myObjects) {
                    Item item = result.get();
                    System.out.println(item.lastModified() + ", " + item.size() + ", " + item.objectName());
                }
            } else {
                System.out.println("my-bucketname does not exist");
            }
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
