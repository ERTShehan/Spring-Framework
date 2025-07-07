package lk.ijse.edu.back_end.service;

import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.entity.Job;
import lk.ijse.edu.back_end.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    public void saveJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setJobTitle(jobDTO.getJobTitle());
        job.setCompany(jobDTO.getCompany());
        job.setLocation(jobDTO.getLocation());
        job.setType(jobDTO.getType());
        job.setJobDescription(jobDTO.getJobDescription());
        jobRepository.save(job);
//        jobRepository.save(new Job(jobDTO.getJobTitle(), jobDTO.getCompany(), jobDTO.getLocation(), jobDTO.getType(), jobDTO.getJobDescription()));
    }
}
