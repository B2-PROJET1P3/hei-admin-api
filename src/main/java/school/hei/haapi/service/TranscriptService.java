package school.hei.haapi.service;

import static org.springframework.data.domain.Sort.Direction.DESC;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.model.Transcript;
import school.hei.haapi.repository.TranscriptRepository;
import school.hei.haapi.repository.UserRepository;


@Service
@AllArgsConstructor
public class TranscriptService {

  private final TranscriptRepository transcriptRepository;
  private final UserRepository userRepository;

  public school.hei.haapi.model.Transcript getByIdAndStudentId(String transcriptId, String studentId) {
    return transcriptRepository.getTranscriptByIdAndStudentId(transcriptId, studentId);
  }

  public List<school.hei.haapi.model.Transcript> getAllTranscriptsByStudentId(String studentId, PageFromOne page, BoundedPageSize pageSize) {
    Pageable pageable = PageRequest.of(
        page.getValue() - 1,
        pageSize.getValue(),
        Sort.by(DESC, "creationDatetime"));
    return transcriptRepository.getAllTranscriptsByStudentId(studentId, pageable);
  }

  public List<school.hei.haapi.model.Transcript> getAllByStudentIdWithoutPagination(String studentId) {
    return transcriptRepository.getAllByStudentId(studentId);
  }

  @Transactional
  public List<school.hei.haapi.model.Transcript> saveAll(List<Transcript> transcripts) {
    return transcriptRepository.saveAll(transcripts);
  }
}
