package school.hei.haapi.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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


@Entity
@Table(name = "\"version\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Version {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
 
  private String transcriptId;
  
  @Column(unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int ref;
  
  @ManyToOne
  @JoinColumn(name = "created_by")
  private User createdBy;
  
  @Column(name = "creation_datetime")
  private Instant creationDatetime;
  

}
