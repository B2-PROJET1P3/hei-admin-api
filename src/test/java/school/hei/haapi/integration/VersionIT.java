package school.hei.haapi.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static school.hei.haapi.integration.conf.TestUtils.MANAGER1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT1_ID;
import static school.hei.haapi.integration.conf.TestUtils.STUDENT1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.TEACHER1_TOKEN;
import static school.hei.haapi.integration.conf.TestUtils.VERSION1_ID;
import static school.hei.haapi.integration.conf.TestUtils.anAvailableRandomPort;
import static school.hei.haapi.integration.conf.TestUtils.setUpCognito;
import static school.hei.haapi.integration.conf.TestUtils.version1;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;
import school.hei.haapi.SentryConf;
import school.hei.haapi.endpoint.rest.api.VersionApi;
import school.hei.haapi.endpoint.rest.client.ApiClient;
import school.hei.haapi.endpoint.rest.client.ApiException;
import school.hei.haapi.endpoint.rest.model.Transcript;
import school.hei.haapi.endpoint.rest.model.Version;
import school.hei.haapi.endpoint.rest.security.cognito.CognitoComponent;
import school.hei.haapi.integration.conf.AbstractContextInitializer;
import school.hei.haapi.integration.conf.TestUtils;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
@ContextConfiguration(initializers = VersionIT.ContextInitializer.class)
@AutoConfigureMockMvc
public class VersionIT {

  @MockBean
  private SentryConf sentryConf;
  @MockBean
  private CognitoComponent cognitoComponentMock;

  private static ApiClient anApiClient(String token) {
    return TestUtils.anApiClient(token, CourseIT.ContextInitializer.SERVER_PORT);
  }

  @BeforeEach
  void setUp() {
    setUpCognito(cognitoComponentMock);
  }

  @Test
  public void manager_read_all_ok() throws ApiException {
    ApiClient manager1Client = anApiClient(MANAGER1_TOKEN);
    VersionApi api = new VersionApi(manager1Client);

    Version expected = version1();
    List<Version> actual = api.getStudentVersions(STUDENT1_ID, 1,5);
    assertEquals(expected,actual.get(0) );
  }

  @Test
  public void teacher_read_all_ok() throws ApiException {
    ApiClient teacher1Client = anApiClient(TEACHER1_TOKEN);
    VersionApi api = new VersionApi(teacher1Client);

    Version expected = version1();
    List<Transcript> actual = api.getStudentVersions(STUDENT1_ID, 1,5);
    assertEquals(expected,actual.get(0) );
  }


  @Test
  public void student_read_own_ok() throws ApiException {
    ApiClient student1Client = anApiClient(STUDENT1_TOKEN);
    VersionApi api = new VersionApi(student1Client);

    Version actual = api.getStudentVersionById(STUDENT1_ID, VERSION1_ID);

    assertEquals(actual, version1());
  }

  @Test
  public void student_read_all_own_ok() throws ApiException {
    ApiClient student1Client = anApiClient(STUDENT1_TOKEN);
    VersionApi api = new VersionApi(student1Client);

    List<Transcript> actual = api.getStudentVersions(STUDENT1_ID, 1,5);

    assertEquals(actual.get(0), version1());
  }

  @Test
  public void teacher_read_ok() throws ApiException {
    ApiClient teacher1Client = anApiClient(TEACHER1_TOKEN);
    VersionApi api = new VersionApi(teacher1Client);

    Version actual = api.getStudentVersionById(STUDENT1_ID,VERSION1_ID);

    assertEquals(actual, version1());
  }

  @Test
  public void manager_read_ok() throws ApiException {
    ApiClient manager1Client = anApiClient(MANAGER1_TOKEN);
    VersionApi api = new VersionApi(manager1Client);

    Version actual = api.getStudentVersionById(STUDENT1_ID,VERSION1_ID);

    assertEquals(actual, version1());
  }

  static class ContextInitializer extends AbstractContextInitializer {
    public static final int SERVER_PORT = anAvailableRandomPort();

    @Override
    public int getServerPort() {
      return SERVER_PORT;
    }
  }

}
