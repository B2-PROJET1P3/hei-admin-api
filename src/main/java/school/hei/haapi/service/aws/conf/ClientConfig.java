package school.hei.haapi.service.aws.s3Conf;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;

@Configuration
@Data
public class ClientConfig implements AwsCredentialsProvider {
  @Value("${cloud.aws.credentials.accessKey}")
  private String awsId;
  
  @Value("${cloud.aws.credentials.secretAccessKey}")
  private String awsKey;
  
  @Value("${aws.region}")
  private String region;
  
  @Value("${cloud.aws.credentials.bucketName}")
  private String bucketName;
  
  
  @Override
  public AwsCredentials resolveCredentials() {
    return new AwsCredentials() {
      @Override
      public String accessKeyId() {
        return awsId;
      }
      
      @Override
      public String secretAccessKey() {
        return awsKey;
      }
    };
  }
}

