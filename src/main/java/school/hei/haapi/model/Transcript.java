package school.hei.haapi.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import school.hei.haapi.endpoint.rest.model.Semester;

@Entity
@Table(name = "\"transcript\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transcript {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;
  @ManyToOne
  @JoinColumn(name = "student_id")
  private User student;
  private Integer academicYear;
  private Semester semester;
  private boolean isDefinitive;
  private Instant creationDatetime;
}
