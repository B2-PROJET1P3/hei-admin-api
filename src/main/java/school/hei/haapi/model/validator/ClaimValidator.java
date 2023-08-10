package school.hei.haapi.model.validator;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import school.hei.haapi.model.Claim;
import school.hei.haapi.model.exception.BadRequestException;
@Component
@AllArgsConstructor
public class ClaimValidator implements Consumer<Claim> {
  @Override
  public void accept(Claim claim) {
    Set<String> violationMessages = new HashSet<>();
    
    if(claim.getCreationDatetime().isBefore(claim.getClosedDatetime())){
      violationMessages.add("Creation datetime cannot be before closed datetime");
    }
    if(claim.getTranscript()==null){
      violationMessages.add("Transcript is mandatory");
    }
    if(claim.getVersion()==null){
      violationMessages.add("Version is mandatory");
    }
    if (claim.getReason()==null){
      violationMessages.add("Claims reason cannot be null");
    }
    if (!violationMessages.isEmpty()) {
      String formattedViolationMessages = violationMessages.stream()
          .map(String::toString)
          .collect(Collectors.joining(". "));
      throw new BadRequestException(formattedViolationMessages);
    }
  }
}
