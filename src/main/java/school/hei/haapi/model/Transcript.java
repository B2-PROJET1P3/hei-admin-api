package school.hei.haapi.model;


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
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

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
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "student")
  private User student;
  private String semester;
  private String academicYear;
  private String isDefinitive;
  private Instant creationDatetime;
}
