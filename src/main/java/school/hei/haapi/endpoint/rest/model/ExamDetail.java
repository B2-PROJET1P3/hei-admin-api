/*
 * HEI Admin API
 * _Programmatically connect to a computer programming [school](https://hei.school)._ After [joining us](mailto:contact@hei.school), you can get an identification token from our [dev](https://dev-hei-admin.auth.eu-west-3.amazoncognito.com/oauth2/authorize?client_id=5s8cg50doahmu855rlc8fr6qmp&response_type=token&scope=email+openid&redirect_uri=https%3A%2F%2Fapi-dev.hei.school%2Fwhoami) or [prod](https://prod-hei-admin.auth.eu-west-3.amazoncognito.com/oauth2/authorize?client_id=i8bg538jpfu6mqmqb61m26trd&response_type=token&scope=email+openid&redirect_uri=https%3A%2F%2Fapi-prod.hei.school%2Fwhoami) authentication service. Then, start playing with our system!  The implementation of our API is [publicly disclosed](https://github.com/hei-school/hei-admin-api). You are welcome to try and compromise it. Happy hacking! 
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package school.hei.haapi.endpoint.rest.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import school.hei.haapi.endpoint.rest.model.ExamInfo;
import school.hei.haapi.endpoint.rest.model.StudentGrade;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ExamDetail
 */
@JsonPropertyOrder({
  ExamDetail.JSON_PROPERTY_PARTICIPANTS,
  ExamDetail.JSON_PROPERTY_ID,
  ExamDetail.JSON_PROPERTY_COEFFICIENT,
  ExamDetail.JSON_PROPERTY_TITLE,
  ExamDetail.JSON_PROPERTY_EXAMINATION_DATE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-08T22:43:25.135187600+03:00[Europe/Moscow]")
public class ExamDetail {
  public static final String JSON_PROPERTY_PARTICIPANTS = "participants";
  private List<StudentGrade> participants = null;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_COEFFICIENT = "coefficient";
  private Integer coefficient;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_EXAMINATION_DATE = "examination_date";
  private java.time.Instant examinationDate;


  public ExamDetail participants(List<StudentGrade> participants) {
    this.participants = participants;
    return this;
  }

  public ExamDetail addParticipantsItem(StudentGrade participantsItem) {
    if (this.participants == null) {
      this.participants = new ArrayList<>();
    }
    this.participants.add(participantsItem);
    return this;
  }

   /**
   * Get participants
   * @return participants
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<StudentGrade> getParticipants() {
    return participants;
  }


  @JsonProperty(JSON_PROPERTY_PARTICIPANTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setParticipants(List<StudentGrade> participants) {
    this.participants = participants;
  }


  public ExamDetail id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }


  public ExamDetail coefficient(Integer coefficient) {
    this.coefficient = coefficient;
    return this;
  }

   /**
   * Get coefficient
   * @return coefficient
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_COEFFICIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCoefficient() {
    return coefficient;
  }


  @JsonProperty(JSON_PROPERTY_COEFFICIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCoefficient(Integer coefficient) {
    this.coefficient = coefficient;
  }


  public ExamDetail title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(String title) {
    this.title = title;
  }


  public ExamDetail examinationDate(java.time.Instant examinationDate) {
    this.examinationDate = examinationDate;
    return this;
  }

   /**
   * Get examinationDate
   * @return examinationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EXAMINATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.time.Instant getExaminationDate() {
    return examinationDate;
  }


  @JsonProperty(JSON_PROPERTY_EXAMINATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExaminationDate(java.time.Instant examinationDate) {
    this.examinationDate = examinationDate;
  }


  /**
   * Return true if this ExamDetail object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExamDetail examDetail = (ExamDetail) o;
    return Objects.equals(this.participants, examDetail.participants) &&
        Objects.equals(this.id, examDetail.id) &&
        Objects.equals(this.coefficient, examDetail.coefficient) &&
        Objects.equals(this.title, examDetail.title) &&
        Objects.equals(this.examinationDate, examDetail.examinationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(participants, id, coefficient, title, examinationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExamDetail {\n");
    sb.append("    participants: ").append(toIndentedString(participants)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    coefficient: ").append(toIndentedString(coefficient)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    examinationDate: ").append(toIndentedString(examinationDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

