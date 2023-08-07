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
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.endpoint.rest.model.StudentExamGrade;
import school.hei.haapi.endpoint.rest.model.Teacher;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * StudentCourseExam
 */
@JsonPropertyOrder({
  StudentCourseExam.JSON_PROPERTY_EXAMS,
  StudentCourseExam.JSON_PROPERTY_ID,
  StudentCourseExam.JSON_PROPERTY_CODE,
  StudentCourseExam.JSON_PROPERTY_NAME,
  StudentCourseExam.JSON_PROPERTY_CREDITS,
  StudentCourseExam.JSON_PROPERTY_TOTAL_HOURS,
  StudentCourseExam.JSON_PROPERTY_MAIN_TEACHER
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T12:04:02.522846600+03:00[Europe/Moscow]")
public class StudentCourseExam {
  public static final String JSON_PROPERTY_EXAMS = "exams";
  private List<StudentExamGrade> exams = null;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_CREDITS = "credits";
  private Integer credits;

  public static final String JSON_PROPERTY_TOTAL_HOURS = "total_hours";
  private Integer totalHours;

  public static final String JSON_PROPERTY_MAIN_TEACHER = "main_teacher";
  private Teacher mainTeacher;


  public StudentCourseExam exams(List<StudentExamGrade> exams) {
    this.exams = exams;
    return this;
  }

  public StudentCourseExam addExamsItem(StudentExamGrade examsItem) {
    if (this.exams == null) {
      this.exams = new ArrayList<>();
    }
    this.exams.add(examsItem);
    return this;
  }

   /**
   * Get exams
   * @return exams
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EXAMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<StudentExamGrade> getExams() {
    return exams;
  }


  @JsonProperty(JSON_PROPERTY_EXAMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExams(List<StudentExamGrade> exams) {
    this.exams = exams;
  }


  public StudentCourseExam id(String id) {
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


  public StudentCourseExam code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Get code
   * @return code
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "PROG1", value = "")
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCode() {
    return code;
  }


  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCode(String code) {
    this.code = code;
  }


  public StudentCourseExam name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Algorithmics", value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public StudentCourseExam credits(Integer credits) {
    this.credits = credits;
    return this;
  }

   /**
   * Get credits
   * @return credits
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREDITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCredits() {
    return credits;
  }


  @JsonProperty(JSON_PROPERTY_CREDITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCredits(Integer credits) {
    this.credits = credits;
  }


  public StudentCourseExam totalHours(Integer totalHours) {
    this.totalHours = totalHours;
    return this;
  }

   /**
   * Get totalHours
   * @return totalHours
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TOTAL_HOURS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTotalHours() {
    return totalHours;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_HOURS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalHours(Integer totalHours) {
    this.totalHours = totalHours;
  }


  public StudentCourseExam mainTeacher(Teacher mainTeacher) {
    this.mainTeacher = mainTeacher;
    return this;
  }

   /**
   * Get mainTeacher
   * @return mainTeacher
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MAIN_TEACHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Teacher getMainTeacher() {
    return mainTeacher;
  }


  @JsonProperty(JSON_PROPERTY_MAIN_TEACHER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMainTeacher(Teacher mainTeacher) {
    this.mainTeacher = mainTeacher;
  }


  /**
   * Return true if this StudentCourseExam object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentCourseExam studentCourseExam = (StudentCourseExam) o;
    return Objects.equals(this.exams, studentCourseExam.exams) &&
        Objects.equals(this.id, studentCourseExam.id) &&
        Objects.equals(this.code, studentCourseExam.code) &&
        Objects.equals(this.name, studentCourseExam.name) &&
        Objects.equals(this.credits, studentCourseExam.credits) &&
        Objects.equals(this.totalHours, studentCourseExam.totalHours) &&
        Objects.equals(this.mainTeacher, studentCourseExam.mainTeacher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exams, id, code, name, credits, totalHours, mainTeacher);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StudentCourseExam {\n");
    sb.append("    exams: ").append(toIndentedString(exams)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    credits: ").append(toIndentedString(credits)).append("\n");
    sb.append("    totalHours: ").append(toIndentedString(totalHours)).append("\n");
    sb.append("    mainTeacher: ").append(toIndentedString(mainTeacher)).append("\n");
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

