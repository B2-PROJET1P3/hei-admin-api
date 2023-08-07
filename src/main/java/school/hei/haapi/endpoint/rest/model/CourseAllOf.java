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
import school.hei.haapi.endpoint.rest.model.Teacher;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CourseAllOf
 */
@JsonPropertyOrder({
  CourseAllOf.JSON_PROPERTY_MAIN_TEACHER
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T12:04:02.522846600+03:00[Europe/Moscow]")
public class CourseAllOf {
  public static final String JSON_PROPERTY_MAIN_TEACHER = "main_teacher";
  private Teacher mainTeacher;


  public CourseAllOf mainTeacher(Teacher mainTeacher) {
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
   * Return true if this Course_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseAllOf courseAllOf = (CourseAllOf) o;
    return Objects.equals(this.mainTeacher, courseAllOf.mainTeacher);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mainTeacher);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CourseAllOf {\n");
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

