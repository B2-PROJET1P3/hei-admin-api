package school.hei.haapi.model;

import lombok.Getter;
import school.hei.haapi.model.exception.BadRequestException;

@Getter
public class PageFromOne {

  private final int value;

  public PageFromOne(int value) {
    if (value < 1) {
      throw new BadRequestException("page value must be >=1");
    }
    this.value = value;
  }
}
