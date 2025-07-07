package lk.ijse.edu.back_end.service;

import lk.ijse.edu.back_end.dto.JobDTO;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    public void saveJob(JobDTO jobDTO) {
        //save job
        System.out.println("Job saved: " + jobDTO.getJobTitle());
    }
}
