package school.hei.haapi.endpoint.rest.validator;


import java.util.Objects;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Claim;
import school.hei.haapi.model.exception.BadRequestException;

@Component
public class CreateClaimValidator implements Consumer<Claim> {
  
  public void accept(Claim studentTranscriptClaim,String transcriptId,String versionId) {
      if(!Objects.equals(studentTranscriptClaim.getVersionId(), versionId)){
        throw new BadRequestException("versionId in path is different from versionId in body");
      }
      if(!Objects.equals(studentTranscriptClaim.getTranscriptId(), transcriptId)){
        throw new BadRequestException("transcriptId in path is different from transcriptId in body");
      }
  }
  
  
  @Override
  public void accept(Claim studentTranscriptClaim) {
    if (studentTranscriptClaim.getVersionId()==null){
      throw new BadRequestException("versionId cannot be null");
    }
    if (studentTranscriptClaim.getTranscriptId()==null){
      throw new BadRequestException("transcript cannot be null");
    }
  }
}
