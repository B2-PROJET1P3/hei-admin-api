package school.hei.haapi.endpoint.rest.mapper;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Student;
import school.hei.haapi.endpoint.rest.model.Transcript;
import school.hei.haapi.endpoint.rest.model.Version;


@Component
public class VersionMapper {
  public Version toRest(school.hei.haapi.model.Version domain, Transcript transcript, Student user){
    return new Version()
        .id(domain.getId())
        .transcriptId(transcript.getId())
        .ref(BigDecimal.valueOf(domain.getRef()))
        .createdByUserId(String.valueOf(user))
        .creationDatetime(domain.getCreationDatetime());
  }
  public school.hei.haapi.model.Version toDomain(Version rest, school.hei.haapi.model.User user, school.hei.haapi.model.Transcript transcript){
    return school.hei.haapi.model.Version.builder()
        .id(rest.getId())
        .transcriptId(transcript)
        .ref(rest.getRef().intValue())
        .createdBy(user)
        .creationDatetime(rest.getCreationDatetime())
        .build();
  }
}