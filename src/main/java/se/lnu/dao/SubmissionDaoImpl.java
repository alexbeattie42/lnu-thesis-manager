package se.lnu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.lnu.entity.Submission;
import se.lnu.repository.SubmissionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubmissionDaoImpl implements SubmissionDao {

    @Autowired
            @Qualifier("submissionRepository")
    SubmissionRepository submissionRepository;

    @Override
    @Transactional
    public Submission saveSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    @Transactional
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }
}
