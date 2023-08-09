package school.hei.haapi.integration;

import java.time.Instant;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;
import school.hei.haapi.SentryConf;
import school.hei.haapi.endpoint.rest.api.TranscriptApi;
import school.hei.haapi.endpoint.rest.client.ApiClient;
import school.hei.haapi.endpoint.rest.client.ApiException;
import school.hei.haapi.endpoint.rest.model.ClaimStatus;
import school.hei.haapi.endpoint.rest.model.Group;
import school.hei.haapi.endpoint.rest.security.cognito.CognitoComponent;
import school.hei.haapi.integration.conf.AbstractContextInitializer;
import school.hei.haapi.integration.conf.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import school.hei.haapi.endpoint.rest.model.Claim;

import static org.springframework.test.util.AssertionErrors.assertTrue;
import static school.hei.haapi.integration.conf.TestUtils.CLAIM1_ID;
import static school.hei.haapi.integration.conf.TestUtils.CLAIM2_ID;
import static school.hei.haapi.integration.conf.TestUtils.FEE2_ID;
import static school.hei.haapi.integration.conf.TestUtils.MANAGER1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT1_ID;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT2_ID;
import static school.hei.haapi.integration.conf.TestUtils.TEACHER1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.TRANSCRIPT1_ID;
import static school.hei.haapi.integration.conf.TestUtils.TRANSCRIPT2_ID;
import static school.hei.haapi.integration.conf.TestUtils.VERSION1_ID;
import static school.hei.haapi.integration.conf.TestUtils.VERSION2_ID;
import static school.hei.haapi.integration.conf.TestUtils.anAvailableRandomPort;
import static school.hei.haapi.integration.conf.TestUtils.assertThrowsApiException;
import static school.hei.haapi.integration.conf.TestUtils.assertThrowsForbiddenException;
import static school.hei.haapi.integration.conf.TestUtils.course1;
import static school.hei.haapi.integration.conf.TestUtils.crupdatedCourse2;
import static school.hei.haapi.integration.conf.TestUtils.isValidUUID;
import static school.hei.haapi.integration.conf.TestUtils.setUpCognito;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@ContextConfiguration(initializers = ClaimIT.ContextInitializer.class)
@AutoConfigureMockMvc
@Slf4j
class ClaimIT {
  @MockBean
  private SentryConf sentryConf;
  @MockBean
  private CognitoComponent cognitoComponentMock;
  
  private static ApiClient anApiClient(String token) {
    return TestUtils.anApiClient(token, ClaimIT.ContextInitializer.SERVER_PORT);
  }
  
  @BeforeEach
  void setUp() {
    setUpCognito(cognitoComponentMock);
  }
  
  public static Claim claim1() {
    Claim claim = new Claim();
    claim.setId("claim1_id");
    claim.setVersionId("version1_id");
    claim.setTranscriptId("transcript1_id");
    claim.setReason("string");
    claim.setStatus(ClaimStatus.valueOf("OPEN"));
    claim.setCreationDatetime(Instant.parse("2023-08-08T16:23:09.191Z"));
    return claim;
  }
  
  public static Claim claim2() {
    Claim claim = new Claim();
    claim.setId("claim2_id");
    claim.setVersionId("version2_id");
    claim.setTranscriptId("transcript2_id");
    claim.setReason("string");
    claim.setStatus(ClaimStatus.valueOf("CLOSE"));
    claim.setClosedDatetime(Instant.parse("2023-10-08T16:23:09.191Z"));
    claim.setCreationDatetime(Instant.parse("2023-08-08T16:23:09.191Z"));
    return claim;
  }
  @Test
  void student_read_ko() throws ApiException {
    ApiClient student1Client = anApiClient(STUDENT1_TOKEN);
    TranscriptApi api = new TranscriptApi(student1Client);
    
    assertThrowsForbiddenException(() -> api.getStudentClaims(CLAIM1_ID,TRANSCRIPT1_ID,VERSION1_ID,1,5));
  }
  
  @Test
  void student_create_ok() throws ApiException {
    ApiClient student1Client = anApiClient(STUDENT1_TOKEN);
    TranscriptApi api = new TranscriptApi(student1Client);
    
    Claim claim = api.putStudentClaimsOfTranscriptVersion(STUDENT1_ID,TRANSCRIPT1_ID,VERSION1_ID,CLAIM1_ID,claim1());
    
    assertEquals(claim,claim1());
  }
  
  @Test
  void student_create_ko() throws ApiException {
    ApiClient student1Client = anApiClient(STUDENT1_TOKEN);
    TranscriptApi api = new TranscriptApi(student1Client);
    
    assertThrowsApiException(
        "{\"type\":\"400 BAD_REQUEST\",\"message\":\"transcriptId in path is different from transcriptId in body.\"}",
        () -> api.putStudentClaimsOfTranscriptVersion(STUDENT1_ID,TRANSCRIPT2_ID,VERSION1_ID,CLAIM1_ID,claim1()));
  }
  
  @Test
  void teacher_read_ok() throws ApiException {
    ApiClient teacher1Client = anApiClient(TEACHER1_TOKEN);
    TranscriptApi api = new TranscriptApi(teacher1Client);
    
    List<Claim> claim = api.getStudentClaims(STUDENT1_ID,TRANSCRIPT1_ID,VERSION1_ID,1,5);
    
    
    Assertions.assertEquals(1,claim.size());
  }
  
  
  @Test
  void teacher_write_ko() throws ApiException {
    ApiClient teacher1Client = anApiClient(TEACHER1_TOKEN);
    TranscriptApi api = new TranscriptApi(teacher1Client);
    
    assertThrowsForbiddenException(() -> api.putStudentClaimsOfTranscriptVersion(STUDENT1_ID,TRANSCRIPT1_ID,VERSION1_ID,CLAIM1_ID,claim1()));
  }
  
  
  @Test
  void manager_update_student_claim() throws ApiException {
    ApiClient manager1Client = anApiClient(MANAGER1_TOKEN);
    TranscriptApi api = new TranscriptApi(manager1Client);
   Claim claim = api.putStudentClaimsOfTranscriptVersion(STUDENT2_ID,TRANSCRIPT2_ID,VERSION2_ID,CLAIM2_ID,claim2());
    
    
    claim2().setId(claim.getId());
    assertNotNull(claim.getCreationDatetime());
    
   assertEquals(claim,claim2());
  }
  
  @Test
  void manager_crupdate_ok() throws ApiException {
    ApiClient manager1Client = anApiClient(MANAGER1_TOKEN);
    TranscriptApi api = new TranscriptApi(manager1Client);
    
    Claim claim = api.putStudentClaimsOfTranscriptVersion(STUDENT1_ID,TRANSCRIPT1_ID,VERSION1_ID,CLAIM1_ID,claim1());
  
    assertEquals(claim,claim1());
  }
  
  @Test
  void manager_read_ok() throws ApiException {
    ApiClient manager1client = anApiClient(TEACHER1_TOKEN);
    TranscriptApi api = new TranscriptApi(manager1client);
    
    List<Claim> claim = api.getStudentClaims(STUDENT1_ID,TRANSCRIPT1_ID,VERSION1_ID,1,2);
    log.info(claim.toString());
    Assertions.assertEquals(claim.get(0),claim1());
  }
  
  @Test
  void manager_crupdate_ko() {
    ApiClient manager1Client = anApiClient(MANAGER1_TOKEN);
    TranscriptApi api = new TranscriptApi(manager1Client);
    ApiException exception1 = assertThrows(ApiException.class,
        () -> api.putStudentClaimsOfTranscriptVersion(STUDENT1_ID,TRANSCRIPT1_ID,VERSION2_ID,CLAIM1_ID,claim1()));
    String exceptionMessage = exception1.getMessage();
    Assertions.assertTrue(exceptionMessage.contains("versionId in path is different from versionId in body"));
    
    
  }
  
  static class ContextInitializer extends AbstractContextInitializer {
    public static final int SERVER_PORT = anAvailableRandomPort();
    
    @Override
    public int getServerPort() {
      return SERVER_PORT;
    }
  }
}
