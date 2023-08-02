import static javax.persistence.FetchType.LAZY;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import school.hei.haapi.model.User;
import school.hei.haapi.repository.types.PostgresEnumType;

@Entity
@Table(name = "\"transcript\"")
@Getter
@Setter
@ToString
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Transcript implements Serializable {
  @Id
  private String id;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "student_id")
  private User student;

  @Type(type = "pgsql_enum")
  @Enumerated(EnumType.STRING)
  private school.hei.haapi.endpoint.rest.model.Transcript semester;

  private Integer academicYear;

  private Boolean isDefinitive;

  private Instant creationDatetime;
}