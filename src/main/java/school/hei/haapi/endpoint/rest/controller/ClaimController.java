package school.hei.haapi.endpoint.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.ClaimMapper;
import school.hei.haapi.endpoint.rest.mapper.TranscriptMapper;
import school.hei.haapi.endpoint.rest.mapper.VersionMapper;
import school.hei.haapi.endpoint.rest.model.Claim;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.model.Transcript;
import school.hei.haapi.model.Version;
import school.hei.haapi.service.ClaimService;
import school.hei.haapi.service.TranscriptService;
import school.hei.haapi.service.VersionService;

@RestController
@AllArgsConstructor
public class ClaimController {

  private final ClaimService claimService;
  private final ClaimMapper claimMapper;
 
  
  @GetMapping("/students/{student_id}/transcripts/{transcript_id}/versions/{version_id}/claims")
  public List<Claim> getAllClaimsByTranscriptVersionId(@PathVariable(value = "version_id") String versionId,
                                                       @PathVariable(value = "transcript_id") String transcriptId,
                                                       @RequestParam("page") PageFromOne page,
                                                       @RequestParam("page_size") BoundedPageSize pageSize){
    
    return claimService.getAllClaims(versionId,transcriptId,page,pageSize).stream().map(claimMapper::toRest).collect(
        Collectors.toUnmodifiableList());
  }
  
  @GetMapping("/students/{student_id}/transcripts/{transcript_id}/versions/{version_id}/claims/{claims_id}")
  public Claim getClaimById(@PathVariable(value = "version_id") String versionId,
                                                       @PathVariable(value = "transcript_id") String transcriptId,
                                                       @PathVariable(value = "claims_id") String claimId){
    
    return claimMapper.toRest(claimService.getClaimById(versionId,transcriptId,claimId));
  }
  
  @PutMapping("/students/{student_id}/transcripts/{transcript_id}/versions/{version_id}/claims/{claims_id}")
  public List<Claim> crupdateClaim(@PathVariable(value = "student_id") String studentId,
                             @PathVariable(value = "version_id") String versionId,
                            @PathVariable(value = "transcript_id") String transcriptId,
                            @PathVariable(value = "claims_id") String claimId,
                            @RequestBody List<Claim> claim
  ){
   
    
    
    return claimService.crupdateClaim(claim,studentId,versionId,transcriptId,claimId).stream().map(claimMapper::toRest).collect(
        Collectors.toUnmodifiableList());
  }
  
  
}
