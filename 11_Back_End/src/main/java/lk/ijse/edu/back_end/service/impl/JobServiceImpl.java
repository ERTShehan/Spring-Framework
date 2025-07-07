package lk.ijse.edu.back_end.service.impl;

import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.entity.Job;
import lk.ijse.edu.back_end.repository.JobRepository;
import lk.ijse.edu.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    public void saveJob(JobDTO jobDTO) {
//        Job job = new Job();
//        job.setJobTitle(jobDTO.getJobTitle());
//        job.setCompany(jobDTO.getCompany());
//        job.setLocation(jobDTO.getLocation());
//        job.setType(jobDTO.getType());
//        job.setJobDescription(jobDTO.getJobDescription());
//        jobRepository.save(job);

        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }


    @Override
    public void updateJob(JobDTO jobDTO) {
        jobRepository.save(modelMapper.map(jobDTO, Job.class));
    }

    public void deleteJob(int id) {
        jobRepository.deleteById(id);
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> allJobs=jobRepository.findAll();
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());
    }

    @Override
    public void changeJobStatus(String jobId) {
        jobRepository.updateJobStatus(jobId);
    }

    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        List<Job> alljobs=jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        return modelMapper.map(alljobs, new TypeToken<List<JobDTO>>(){}.getType());
    }
}
