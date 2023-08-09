package school.hei.haapi.service.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ByteToFile implements MultipartFile {
  
  // from baeldung docs : https://www.baeldung.com/java-convert-byte-array-to-multipartfile
  private byte[] input;
  
  public ByteToFile(byte[] input) {
    this.input=input;
  }
  
  
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
    return this.input == null || this.input.length == 0;
  }
  
  @Override
  public long getSize() {
    return this.input.length;
  }
  
  @Override
  public byte[] getBytes() throws IOException {
    return this.input;
  }
  
  @Override
  public InputStream getInputStream() throws IOException {
    return new ByteArrayInputStream(this.input);
  }
  @Override
  public void transferTo(File dest) throws IOException, IllegalStateException {
    FileUtils.writeByteArrayToFile(dest, input);
  }
  
 
}
