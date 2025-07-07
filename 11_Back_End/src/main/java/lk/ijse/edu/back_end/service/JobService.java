package lk.ijse.edu.back_end.service;

import lk.ijse.edu.back_end.dto.JobDTO;

import java.util.List;

public interface JobService {
    void saveJob(JobDTO jobDTO);
    void updateJob(JobDTO jobDTO);
    void deleteJob(int id);
    List<JobDTO> getAllJobs();}
