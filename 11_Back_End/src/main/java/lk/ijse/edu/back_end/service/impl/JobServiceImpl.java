package lk.ijse.edu.back_end.service.impl;

import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.entity.Job;
import lk.ijse.edu.back_end.exceptions.ResourceNotFound;
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

    @Override
    public void saveJob(JobDTO jobDTO) {
//        Job job = new Job();
//        job.setJobTitle(jobDTO.getJobTitle());
//        job.setCompany(jobDTO.getCompany());
//        job.setLocation(jobDTO.getLocation());
//        job.setJobDescription(jobDTO.getJobDescription());
//        job.setType(jobDTO.getType());                            boilerplate code

//        modelMapper.map(jobDTO,Job.class); easy way


        if (jobDTO==null){
            throw new IllegalArgumentException("JobDTO cannot be null");
        }

        jobRepository.save(modelMapper.map(jobDTO,Job.class));

//        dto type eka gaththa job type ekt demma
    }

    @Override
    public void updateJob(JobDTO jobDTO) {
        if (jobDTO==null||jobDTO.getId()==null){
            throw new IllegalArgumentException("Job Id cannot be null");
        }
        jobRepository.findById(jobDTO.getId()).orElseThrow(
                ()->new ResourceNotFound("Job Not Found"));

        jobRepository.save(modelMapper.map(jobDTO,Job.class));
        // update ekatath save eka ganne mekedi wenne
        // primary key eka ekiyanne id eka already thibboth save wenne na update wenne
    }

    @Override
    public void deleteJob(String id) {
        jobRepository.deleteById(Integer.parseInt(id));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> allJobs = jobRepository.findAll();
        if (allJobs.isEmpty()){
            throw new ResourceNotFound("No Job Found");
        }
        return modelMapper.map(allJobs, new TypeToken<List<JobDTO>>(){}.getType());

    }

    @Override
    public void changeJobStatus(String id) {
        if (id==null){
            throw new IllegalArgumentException("Job Id cannot be null");
        }
        jobRepository.updateJobStatus(id);
    }

    @Override
    public List<JobDTO> getAllJobsByKeyword(String keyword) {
        if (keyword==null){
            throw new IllegalArgumentException("Keyword cannot be null");
        }
        List<Job> alljobs= jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        if (alljobs.isEmpty()){
            throw new ResourceNotFound("No Job Found");
        }
        return modelMapper.map(alljobs, new TypeToken<List<JobDTO>>(){}.getType());
    }

    @Override
    public JobDTO getJobById(String id) {
        Job job = jobRepository.getJobById(Integer.parseInt(id));
        return modelMapper.map(job,JobDTO.class);
    }


}

