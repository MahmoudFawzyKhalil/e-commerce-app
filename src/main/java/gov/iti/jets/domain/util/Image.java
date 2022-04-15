package gov.iti.jets.domain.util;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.File;

public class Image {

    public static String getImageUrl( String imageName ) {
        String bucketName = "products-image-ecommerce";

        String fileName = imageName;
        String filePath = "C:/DevTools/apache-tomcat-10.0.18/ecommerce/" + imageName;
        S3Client client = S3Client.builder().build();
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName).key(fileName).acl("public-read").build();
        client.putObject(request, RequestBody.fromFile(new File(filePath)));
        return "https://products-image-ecommerce.s3.amazonaws.com/"+imageName;
    }
}
