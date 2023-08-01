package school.hei.haapi.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import school.hei.haapi.endpoint.rest.model.Student;

@Entity
@Table(name = "transcript")
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Transcript implements Serializable {
  @Id
  @GeneratedValue
  private String id;

  @ManyToOne
  private Student student;

  @Enumerated(EnumType.STRING)
  private Semester semester;

  private String academicYear;

  private boolean isDefinitive;

  private Instant creationDatetime;

  public enum Semester {
    S1,
    S2,
    S3,
    S4,
    S5,
    S6
  }
}
