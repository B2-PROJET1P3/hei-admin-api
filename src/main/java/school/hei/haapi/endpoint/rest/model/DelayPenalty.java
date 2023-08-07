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
import school.hei.haapi.endpoint.rest.model.CreateDelayPenaltyChange;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * DelayPenalty
 */
@JsonPropertyOrder({
  DelayPenalty.JSON_PROPERTY_ID,
  DelayPenalty.JSON_PROPERTY_CREATION_DATETIME,
  DelayPenalty.JSON_PROPERTY_INTEREST_PERCENT,
  DelayPenalty.JSON_PROPERTY_INTEREST_TIMERATE,
  DelayPenalty.JSON_PROPERTY_GRACE_DELAY,
  DelayPenalty.JSON_PROPERTY_APPLICABILITY_DELAY_AFTER_GRACE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-08-07T12:04:02.522846600+03:00[Europe/Moscow]")
public class DelayPenalty {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_CREATION_DATETIME = "creation_datetime";
  private java.time.Instant creationDatetime;

  public static final String JSON_PROPERTY_INTEREST_PERCENT = "interest_percent";
  private Integer interestPercent;

  /**
   * Gets or Sets interestTimerate
   */
  public enum InterestTimerateEnum {
    DAILY("DAILY");

    private String value;

    InterestTimerateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InterestTimerateEnum fromValue(String value) {
      for (InterestTimerateEnum b : InterestTimerateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_INTEREST_TIMERATE = "interest_timerate";
  private InterestTimerateEnum interestTimerate;

  public static final String JSON_PROPERTY_GRACE_DELAY = "grace_delay";
  private Integer graceDelay;

  public static final String JSON_PROPERTY_APPLICABILITY_DELAY_AFTER_GRACE = "applicability_delay_after_grace";
  private Integer applicabilityDelayAfterGrace;


  public DelayPenalty id(String id) {
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


  public DelayPenalty creationDatetime(java.time.Instant creationDatetime) {
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


  public DelayPenalty interestPercent(Integer interestPercent) {
    this.interestPercent = interestPercent;
    return this;
  }

   /**
   * Get interestPercent
   * @return interestPercent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INTEREST_PERCENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getInterestPercent() {
    return interestPercent;
  }


  @JsonProperty(JSON_PROPERTY_INTEREST_PERCENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInterestPercent(Integer interestPercent) {
    this.interestPercent = interestPercent;
  }


  public DelayPenalty interestTimerate(InterestTimerateEnum interestTimerate) {
    this.interestTimerate = interestTimerate;
    return this;
  }

   /**
   * Get interestTimerate
   * @return interestTimerate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INTEREST_TIMERATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InterestTimerateEnum getInterestTimerate() {
    return interestTimerate;
  }


  @JsonProperty(JSON_PROPERTY_INTEREST_TIMERATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInterestTimerate(InterestTimerateEnum interestTimerate) {
    this.interestTimerate = interestTimerate;
  }


  public DelayPenalty graceDelay(Integer graceDelay) {
    this.graceDelay = graceDelay;
    return this;
  }

   /**
   * Get graceDelay
   * @return graceDelay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_GRACE_DELAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getGraceDelay() {
    return graceDelay;
  }


  @JsonProperty(JSON_PROPERTY_GRACE_DELAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGraceDelay(Integer graceDelay) {
    this.graceDelay = graceDelay;
  }


  public DelayPenalty applicabilityDelayAfterGrace(Integer applicabilityDelayAfterGrace) {
    this.applicabilityDelayAfterGrace = applicabilityDelayAfterGrace;
    return this;
  }

   /**
   * Get applicabilityDelayAfterGrace
   * @return applicabilityDelayAfterGrace
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_APPLICABILITY_DELAY_AFTER_GRACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getApplicabilityDelayAfterGrace() {
    return applicabilityDelayAfterGrace;
  }


  @JsonProperty(JSON_PROPERTY_APPLICABILITY_DELAY_AFTER_GRACE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setApplicabilityDelayAfterGrace(Integer applicabilityDelayAfterGrace) {
    this.applicabilityDelayAfterGrace = applicabilityDelayAfterGrace;
  }


  /**
   * Return true if this DelayPenalty object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DelayPenalty delayPenalty = (DelayPenalty) o;
    return Objects.equals(this.id, delayPenalty.id) &&
        Objects.equals(this.creationDatetime, delayPenalty.creationDatetime) &&
        Objects.equals(this.interestPercent, delayPenalty.interestPercent) &&
        Objects.equals(this.interestTimerate, delayPenalty.interestTimerate) &&
        Objects.equals(this.graceDelay, delayPenalty.graceDelay) &&
        Objects.equals(this.applicabilityDelayAfterGrace, delayPenalty.applicabilityDelayAfterGrace);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creationDatetime, interestPercent, interestTimerate, graceDelay, applicabilityDelayAfterGrace);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DelayPenalty {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creationDatetime: ").append(toIndentedString(creationDatetime)).append("\n");
    sb.append("    interestPercent: ").append(toIndentedString(interestPercent)).append("\n");
    sb.append("    interestTimerate: ").append(toIndentedString(interestTimerate)).append("\n");
    sb.append("    graceDelay: ").append(toIndentedString(graceDelay)).append("\n");
    sb.append("    applicabilityDelayAfterGrace: ").append(toIndentedString(applicabilityDelayAfterGrace)).append("\n");
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

