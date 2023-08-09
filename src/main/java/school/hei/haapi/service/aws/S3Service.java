package school.hei.haapi.service.aws;


import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import school.hei.haapi.service.utils.ByteToFile;
import school.hei.haapi.service.aws.s3Conf.ClientConfig;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;


@Component
@Service

public class S3Service {
  private final String S3_BUCKET_NAME = new ClientConfig().getBucketName();
  private final String AWS_REGION = new ClientConfig().getRegion();
  public void uploadFile(MultipartFile file,String versionId) {
    try {
      S3Client s3Client = S3Client.builder()
          .credentialsProvider(new ClientConfig())
          .region(Region.of(AWS_REGION))
          .build();
      
      String fileName = versionId+".pdf";
      
      PutObjectRequest putObjectRequest = PutObjectRequest.builder()
          .bucket(S3_BUCKET_NAME)
          .key(fileName)
          .contentType(file.getContentType())
          .build();
      s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
    } catch (S3Exception | IOException e) {
      e.printStackTrace();
    }
  }
  
  public ByteToFile getObject(String versionId){
    S3Client s3Client = S3Client.builder()
        .credentialsProvider(DefaultCredentialsProvider.create())
        .region(Region.of(AWS_REGION))
        .build();
    
    GetObjectRequest getObjectRequest = GetObjectRequest.builder()
        .bucket(S3_BUCKET_NAME)
        .key(versionId)
        .build();
    
    ResponseBytes<GetObjectResponse> responseBytes = s3Client.getObjectAsBytes(getObjectRequest);
    byte[] fileBytes = responseBytes.asByteArray();
    
    return new ByteToFile(fileBytes);
  }
  
  

}
