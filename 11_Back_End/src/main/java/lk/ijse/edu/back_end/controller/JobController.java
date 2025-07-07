package lk.ijse.edu.back_end.controller;

import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.service.impl.JobServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
public class JobController {
    private final JobServiceImpl jobService;

    @PostMapping("create")
    public String createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return "Job Created";
    }

    @PutMapping("update")
    public String updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return "Job Updated";
    }

    @PutMapping("delete")
    public String deleteJob(@RequestParam int id) {
        jobService.deleteJob(id);
        return "Job Deleted";
    }

    @GetMapping("getalljobs")
    public List<JobDTO> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PatchMapping("status/{id}")
    private String changeJobStatus(@PathVariable("id") String jobId){
        System.out.println("Job Id: "+jobId);
        jobService.changeJobStatus(jobId);
        return "Job Status Changed";
    }

    @GetMapping("search/{keyword}")
    public List<JobDTO> searchJob(@PathVariable("keyword") String keyword){
        return jobService.getAllJobsByKeyword(keyword);
    }
}
