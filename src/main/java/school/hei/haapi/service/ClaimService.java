package school.hei.haapi.service;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.Claim;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.repository.ClaimRepository;

@Service
@AllArgsConstructor
public class ClaimService {
  private ClaimRepository claimRepository;
  
  private Claim getClaimById(String versionId,String transcriptId,String id){
    return claimRepository.findByVersion_IdAndTranscript_IdAndId(versionId,transcriptId,id);
  }
  
  private List<Claim> getAllClaim(String versionId, String transcriptId, PageFromOne page,
                                  BoundedPageSize pageSize){
    Pageable pageable = PageRequest.of(
        page.getValue() - 1,
        pageSize.getValue());
    return claimRepository.findAllByVersion_IdAndTranscript_Id(versionId, transcriptId,pageable);
  }
  
  private List<Claim> crupdateClaim(List<Claim> toUpdate){
    
    return claimRepository.saveAll(toUpdate);
  }
}
