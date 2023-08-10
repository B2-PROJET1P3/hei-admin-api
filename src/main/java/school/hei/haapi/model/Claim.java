package school.hei.haapi.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import school.hei.haapi.endpoint.rest.model.ClaimStatus;

import school.hei.haapi.endpoint.rest.model.StudentTranscriptVersion;
import school.hei.haapi.repository.types.PostgresEnumType;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "\"claim\"")
@Getter
@Setter
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
@ToString
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Claim {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String id;
  
  @ManyToOne
  private Version version;
  
  @OneToOne
  private  Transcript transcript;
  
  private String reason;
  
  @Type(type = "pgsql_enum")
  @Enumerated(EnumType.STRING)
  private ClaimStatus status;
  
  private Instant closedDatetime;
  
  @CreationTimestamp
  private Instant creationDatetime;
}
