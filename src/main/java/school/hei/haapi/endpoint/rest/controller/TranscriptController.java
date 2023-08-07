package school.hei.haapi.endpoint.rest.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.TranscriptMapper;
import school.hei.haapi.endpoint.rest.mapper.UserMapper;
import school.hei.haapi.endpoint.rest.model.Student;
import school.hei.haapi.endpoint.rest.model.Transcript;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.service.TranscriptService;
import school.hei.haapi.service.UserService;

@RestController
@AllArgsConstructor
public class TranscriptController {
  private final TranscriptService transcriptService;
  private final TranscriptMapper transcriptMapper;
  private final UserService userService;
  private final UserMapper userMapper;

  @GetMapping("/students/{student_id}/transcripts")
  public List<Transcript> getTranscripts(@PathVariable("student_id") String studentId,
                                         @RequestParam("page") PageFromOne page,
                                         @RequestParam("page_size") BoundedPageSize pageSize) {

    Student student = userMapper.toRestStudent(userService.getById(studentId));

    return transcriptService.getTranscripts(studentId, page, pageSize).stream()
        .map(transcript -> transcriptMapper.toRest(transcript, student)).collect(
            Collectors.toUnmodifiableList());
  }


  @GetMapping("/students/{student_id}/transcripts/{transcript_id}")
  public Transcript getTranscriptById(@PathVariable("student_id") String studentId,
                                      @PathVariable("transcript_id") String transcriptId) {
    Student student = userMapper.toRestStudent(userService.getById(studentId));
    return transcriptMapper.toRest(transcriptService.getTranscriptById(studentId, transcriptId),
        student);
  }
}
