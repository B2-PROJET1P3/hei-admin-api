package school.hei.haapi.endpoint.rest.mapper;


import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Claim;
import school.hei.haapi.model.Transcript;
import school.hei.haapi.model.Version;

@Component
public class ClaimMapper {
  private UserMapper userMapper;
  
  public Claim toRest(school.hei.haapi.model.Claim domain){
    return new Claim()
        .id(domain.getId())
        .versionId(domain.getVersion().getId())
        .transcriptId(domain.getTranscript().getId())
        .status(domain.getStatus())
        .reason(domain.getReason())
        .closedDatetime(domain.getClosedDatetime())
        .creationDatetime(domain.getCreationDatetime());
  }
  
  public school.hei.haapi.model.Claim toDomain(Claim rest, Version version, Transcript transcript){
    return school.hei.haapi.model.Claim.builder()
        .id(rest.getId())
        .version(version)
        .transcript(transcript)
        .reason(rest.getReason())
        .status(rest.getStatus())
        .closedDatetime(rest.getClosedDatetime())
        .creationDatetime(rest.getCreationDatetime())
        .build();
  }
}
