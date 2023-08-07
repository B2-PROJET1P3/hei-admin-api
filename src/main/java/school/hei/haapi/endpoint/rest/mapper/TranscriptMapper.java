package school.hei.haapi.endpoint.rest.mapper;

import org.springframework.stereotype.Component;
import school.hei.haapi.endpoint.rest.model.Student;
import school.hei.haapi.endpoint.rest.model.Transcript;
import school.hei.haapi.model.User;

@Component
public class TranscriptMapper {
  public Transcript toRest(school.hei.haapi.model.Transcript domain, Student student) {
    return new Transcript()
        .id(domain.getId())
        .academicYear(domain.getAcademicYear())
        .creationDatetime(domain.getCreationDatetime())
        .student(student)
        .isDefinitive(domain.isDefinitive())
        .semester(domain.getSemester());
  }

  public school.hei.haapi.model.Transcript toDomain(Transcript rest, User student){
    return school.hei.haapi.model.Transcript.builder()
        .id(rest.getId())
        .academicYear(rest.getAcademicYear())
        .isDefinitive(rest.getIsDefinitive())
        .semester(rest.getSemester())
        .creationDatetime(rest.getCreationDatetime())
        .student(student)
        .build();
  }
}
