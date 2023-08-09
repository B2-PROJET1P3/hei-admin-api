package school.hei.haapi.unit.utils;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import school.hei.haapi.service.utils.ByteToFile;

public class ByteToFileTest {
  
  
  @Test
  void write_byte_array_to_custom_multipart_file() throws IOException {
    byte[] inputArray = "Test String".getBytes();
   ByteToFile customMultipartFile = new ByteToFile(inputArray,"application/pdf");
   
    Assertions.assertFalse(customMultipartFile.isEmpty());
    Assertions.assertArrayEquals(inputArray, customMultipartFile.getBytes());
    Assertions.assertEquals(inputArray.length,customMultipartFile.getSize());
    Assertions.assertEquals(customMultipartFile.getContentType(),"application/pdf");
  }
}
