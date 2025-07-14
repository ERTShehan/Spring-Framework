package lk.ijse.edu.back_end.service;

import lk.ijse.edu.back_end.dto.JobDTO;

import java.util.List;

public interface JobService {
    void saveJob(JobDTO jobDTO);

    void updateJob(JobDTO jobDTO);

    void deleteJob(String id);

    List<JobDTO> getAllJobs();

    void changeJobStatus(String id);

    List<JobDTO> getAllJobsByKeyword(String keyword);

    JobDTO getJobById(String id);
}
