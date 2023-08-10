package school.hei.haapi.service;


import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.haapi.endpoint.rest.mapper.ClaimMapper;
import school.hei.haapi.endpoint.rest.mapper.TranscriptMapper;
import school.hei.haapi.endpoint.rest.mapper.VersionMapper;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.Claim;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.model.Transcript;
import school.hei.haapi.model.Version;
import school.hei.haapi.repository.ClaimRepository;

@Service
@AllArgsConstructor
public class ClaimService {
  private ClaimRepository claimRepository;
  private final VersionService versionService;
  private final VersionMapper versionMapper;
  private final TranscriptService transcriptService;
  private final TranscriptMapper transcriptMapper;
  private final ClaimMapper claimMapper;
  
  public Claim getClaimById(String versionId,String transcriptId,String id){
    return claimRepository.findByVersion_IdAndTranscript_IdAndId(versionId,transcriptId,id);
  }
  
  public List<Claim> getAllClaims(String versionId, String transcriptId, PageFromOne page,
                                  BoundedPageSize pageSize){
    Pageable pageable = PageRequest.of(
        page.getValue() - 1,
        pageSize.getValue());
    return claimRepository.findAllByVersion_IdAndTranscript_Id(versionId, transcriptId,pageable);
  }
  
  public Claim crupdateClaim(school.hei.haapi.endpoint.rest.model.Claim toUpdate, String studentId, String versionId, String transcriptId, String claimId){
    Version version = versionService.getVersionById(studentId,transcriptId,versionId);
    Transcript transcript= transcriptService.getTranscriptById(studentId,transcriptId);
    Claim toSave =  claimMapper.toDomain(toUpdate,version,transcript);
    
    return claimRepository.save(toSave);
  }
  
  
}
