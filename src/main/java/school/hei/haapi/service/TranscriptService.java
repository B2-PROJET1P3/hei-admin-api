package school.hei.haapi.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.model.Transcript;
import school.hei.haapi.model.User;
import school.hei.haapi.repository.TranscriptRepository;

@Service
@AllArgsConstructor
public class TranscriptService {
  private final TranscriptRepository transcriptRepository;

  public List<Transcript> getTranscripts(String studentId, PageFromOne page,
                                         BoundedPageSize pageSize) {
    Pageable pageable = PageRequest.of(
        page.getValue() - 1,
        pageSize.getValue());
    return transcriptRepository.findAllByStudentId(studentId, pageable);
  }

  public Transcript getTranscriptById(String studentId, String id) {
    return transcriptRepository.findByStudentIdAndId(studentId, id);
  }
}
