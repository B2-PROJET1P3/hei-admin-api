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
import school.hei.haapi.endpoint.rest.model.Semester;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TranscriptTemplate
 */
@JsonPropertyOrder({
  TranscriptTemplate.JSON_PROPERTY_ID,
  TranscriptTemplate.JSON_PROPERTY_SEMESTER,
  TranscriptTemplate.JSON_PROPERTY_ACADEMIC_YEAR,
  TranscriptTemplate.JSON_PROPERTY_IS_DEFINITIVE,
  TranscriptTemplate.JSON_PROPERTY_CREATION_DATETIME
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T12:04:02.522846600+03:00[Europe/Moscow]")
public class TranscriptTemplate {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_SEMESTER = "semester";
  private Semester semester;

  public static final String JSON_PROPERTY_ACADEMIC_YEAR = "academic_year";
  private String academicYear;

  public static final String JSON_PROPERTY_IS_DEFINITIVE = "is_definitive";
  private Boolean isDefinitive;

  public static final String JSON_PROPERTY_CREATION_DATETIME = "creation_datetime";
  private java.time.Instant creationDatetime;


  public TranscriptTemplate id(String id) {
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


  public TranscriptTemplate semester(Semester semester) {
    this.semester = semester;
    return this;
  }

   /**
   * Get semester
   * @return semester
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SEMESTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Semester getSemester() {
    return semester;
  }


  @JsonProperty(JSON_PROPERTY_SEMESTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSemester(Semester semester) {
    this.semester = semester;
  }


  public TranscriptTemplate academicYear(String academicYear) {
    this.academicYear = academicYear;
    return this;
  }

   /**
   * Get academicYear
   * @return academicYear
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACADEMIC_YEAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAcademicYear() {
    return academicYear;
  }


  @JsonProperty(JSON_PROPERTY_ACADEMIC_YEAR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAcademicYear(String academicYear) {
    this.academicYear = academicYear;
  }


  public TranscriptTemplate isDefinitive(Boolean isDefinitive) {
    this.isDefinitive = isDefinitive;
    return this;
  }

   /**
   * Get isDefinitive
   * @return isDefinitive
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_IS_DEFINITIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsDefinitive() {
    return isDefinitive;
  }


  @JsonProperty(JSON_PROPERTY_IS_DEFINITIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIsDefinitive(Boolean isDefinitive) {
    this.isDefinitive = isDefinitive;
  }


  public TranscriptTemplate creationDatetime(java.time.Instant creationDatetime) {
    this.creationDatetime = creationDatetime;
    return this;
  }

   /**
   * Get creationDatetime
   * @return creationDatetime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREATION_DATETIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public java.time.Instant getCreationDatetime() {
    return creationDatetime;
  }


  @JsonProperty(JSON_PROPERTY_CREATION_DATETIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreationDatetime(java.time.Instant creationDatetime) {
    this.creationDatetime = creationDatetime;
  }


  /**
   * Return true if this TranscriptTemplate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranscriptTemplate transcriptTemplate = (TranscriptTemplate) o;
    return Objects.equals(this.id, transcriptTemplate.id) &&
        Objects.equals(this.semester, transcriptTemplate.semester) &&
        Objects.equals(this.academicYear, transcriptTemplate.academicYear) &&
        Objects.equals(this.isDefinitive, transcriptTemplate.isDefinitive) &&
        Objects.equals(this.creationDatetime, transcriptTemplate.creationDatetime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, semester, academicYear, isDefinitive, creationDatetime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranscriptTemplate {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    semester: ").append(toIndentedString(semester)).append("\n");
    sb.append("    academicYear: ").append(toIndentedString(academicYear)).append("\n");
    sb.append("    isDefinitive: ").append(toIndentedString(isDefinitive)).append("\n");
    sb.append("    creationDatetime: ").append(toIndentedString(creationDatetime)).append("\n");
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

