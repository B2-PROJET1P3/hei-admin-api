package school.hei.haapi.endpoint.rest.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ByteToFile implements MultipartFile {
  
  // from baeldung docs : https://www.baeldung.com/java-convert-byte-array-to-multipartfile
  private byte[] input;
  @Override
  public String getName() {
    return null;
  }
  
  @Override
  public String getOriginalFilename() {
    return null;
  }
  
  @Override
  public String getContentType() {
    return null;
  }
  
  @Override
  public boolean isEmpty() {
    return false;
  }
  
  @Override
  public long getSize() {
    return 0;
  }
  
  @Override
  public byte[] getBytes() throws IOException {
    return new byte[0];
  }
  
  @Override
  public InputStream getInputStream() throws IOException {
    return null;
  }
  
  @Override
  public void transferTo(File dest) throws IOException, IllegalStateException {
    FileUtils.writeByteArrayToFile(dest, input);
  }
}
