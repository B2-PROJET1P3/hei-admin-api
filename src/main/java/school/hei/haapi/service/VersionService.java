package school.hei.haapi.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.model.Version;
import school.hei.haapi.repository.VersionRepository;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@AllArgsConstructor
public class VersionService {
  private final VersionRepository repository;
  
  public List<Version> getVersions(String studentId, String transcriptId, PageFromOne page, BoundedPageSize pageSize){
    Pageable pageable = PageRequest.of(
        page.getValue() - 1,
        pageSize.getValue());
    return repository.findAllByCreatedBy_IdAndTranscript_Id(studentId,transcriptId, pageable);
  }
  
  public Version getVersionById(String studentId, String transcriptId, String versionId){
    return repository.getVersionByCreatedBy_IdAndTranscript_IdAndId(studentId, transcriptId, versionId);
  }
  
  public Version getLatestVersion(){
      return repository.findAll( Sort.by(DESC, "creationDatetime")).get(0);
  }
}