package school.hei.haapi.integration;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;
import school.hei.haapi.SentryConf;
import school.hei.haapi.endpoint.rest.api.TranscriptApi;
import school.hei.haapi.endpoint.rest.api.UsersApi;
import school.hei.haapi.endpoint.rest.client.ApiClient;
import school.hei.haapi.endpoint.rest.client.ApiException;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.endpoint.rest.model.CourseDirection;
import school.hei.haapi.endpoint.rest.security.cognito.CognitoComponent;
import school.hei.haapi.integration.conf.AbstractContextInitializer;
import school.hei.haapi.integration.conf.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static school.hei.haapi.endpoint.rest.model.CourseStatus.LINKED;
import static school.hei.haapi.endpoint.rest.model.CourseStatus.UNLINKED;
import static school.hei.haapi.integration.conf.TestUtils.MANAGER1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT1_ID;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT2_ID;
import static school.hei.haapi.integration.conf.TestUtils.TEACHER1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.anAvailableRandomPort;
import static school.hei.haapi.integration.conf.TestUtils.assertThrowsApiException;
import static school.hei.haapi.integration.conf.TestUtils.assertThrowsForbiddenException;
import static school.hei.haapi.integration.conf.TestUtils.course1;
import static school.hei.haapi.integration.conf.TestUtils.course2;
import static school.hei.haapi.integration.conf.TestUtils.course3;
import static school.hei.haapi.integration.conf.TestUtils.course4;
import static school.hei.haapi.integration.conf.TestUtils.course5;
import static school.hei.haapi.integration.conf.TestUtils.crupdatedCourse1;
import static school.hei.haapi.integration.conf.TestUtils.crupdatedCourse2;
import static school.hei.haapi.integration.conf.TestUtils.isBefore;
import static school.hei.haapi.integration.conf.TestUtils.setUpCognito;
import static school.hei.haapi.integration.conf.TestUtils.updateStudentCourse;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@ContextConfiguration(initializers = ClaimIT.ContextInitializer.class)
@AutoConfigureMockMvc
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
  
  @Test
  void student_read_ok() throws ApiException {
    ApiClient student1Client = anApiClient(STUDENT1_TOKEN);
    TranscriptApi
  }
  
  @Test
  void student_create_ok() throws ApiException {
  
  }
  
  @Test
  void teacher_read_ok() throws ApiException {
  
  }
  
  
  @Test
  void student_read_own_student_claim_ok() throws ApiException {
  
  }
  
  @Test
  void student_read_student_claim_ko() {
  
  }
  
  
  @Test
  void manager_update_student_claim() throws ApiException {
  
  }
  
  @Test
  void manager_crupdate_ok() throws ApiException {
  
  }
  
  @Test
  void manager_crupdate_ko() {
  
  }
  
  static class ContextInitializer extends AbstractContextInitializer {
    public static final int SERVER_PORT = anAvailableRandomPort();
    
    @Override
    public int getServerPort() {
      return SERVER_PORT;
    }
  }
}
