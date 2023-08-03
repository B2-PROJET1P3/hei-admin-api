package school.hei.haapi.service.aws;

import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import school.hei.haapi.endpoint.event.EventConf;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
@Service
@AllArgsConstructor
public class S3Service {
  private final EventConf eventConf;

  // Méthode pour télécharger un fichier depuis S3
  public byte[] downloadFile(String bucketName, String key) throws IOException {
    GetObjectRequest getObjectRequest = GetObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .build();

    return eventConf.getS3Client().getObjectAsBytes(getObjectRequest).asByteArray();
  }
  // Méthode pour uploader un fichier vers S3
  public void uploadFile(String bucketName, String key, MultipartFile file) throws IOException {
    PutObjectRequest putObjectRequest = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(key)
        .build();
    eventConf.getS3Client().putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
  }
  // Méthode pour modifier un fichier existant dans S3
  public void modifyFile(String bucketName, String key, MultipartFile file) throws IOException {
    // Vérifier si le fichier existe déjà
    if (eventConf.getS3Client().headObject(headRequest -> headRequest.bucket(bucketName).key(key)).hasMetadata()) {
      // Mettre à jour le contenu du fichier
      PutObjectRequest putObjectRequest = PutObjectRequest.builder()
          .bucket(bucketName)
          .key(key)
          .build();

      eventConf.getS3Client().putObject(putObjectRequest, RequestBody.fromBytes(file.getBytes()));
    } else {
      // Si le fichier n'existe pas, on l'upload simplement
      uploadFile(bucketName, key, file);
    }
  }
}
