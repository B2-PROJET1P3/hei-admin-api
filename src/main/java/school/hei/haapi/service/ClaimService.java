package school.hei.haapi.service;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.Claim;
import school.hei.haapi.repository.ClaimRepository;

@Service
@AllArgsConstructor
@Slf4j
public class ClaimService {
  private ClaimRepository claimRepository;
  
  private Claim getClaimById(String versionId,String transcriptId,String id){
    return claimRepository.findByVersion_IdAndTranscript_IdAndId(versionId,transcriptId,id);
  }
  
  private List<Claim> getAllClaim(String versionId,String transcriptId){
    return claimRepository.findAllByVersion_IdAndTranscript_Id(versionId, transcriptId);
  }
  
  private List<Claim> crupdateClaim(List<Claim> toUpdate){
    
    return claimRepository.saveAll(toUpdate);
  }
}
