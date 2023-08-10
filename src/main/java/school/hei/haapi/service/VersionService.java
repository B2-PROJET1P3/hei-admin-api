package school.hei.haapi.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.model.Version;
import school.hei.haapi.repository.VersionRepository;

@Service
@AllArgsConstructor
public class VersionService {
  private final VersionRepository repository;


  public List<Version> getVersions(String transcriptId, PageFromOne page, BoundedPageSize pageSize){
    Pageable pageable = PageRequest.of(
        page.getValue() - 1,
        pageSize.getValue());
    return repository.findAllByTranscript_Id(transcriptId, pageable);
  }

  public Version getVersionById(String transcriptId, String versionId){
    return repository.getVersionByTranscript_IdAndId(transcriptId, versionId);

  }
}
