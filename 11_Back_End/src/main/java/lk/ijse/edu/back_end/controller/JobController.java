package lk.ijse.edu.back_end.controller;

import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.service.impl.JobServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
@CrossOrigin
public class JobController {
    private final JobServiceImpl jobService;

    @PostMapping("/create")
    public String createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return "Job Added";
    }

    @GetMapping("/getjob/{id}")
    public JobDTO getJob(@PathVariable("id") String id) {
        return jobService.getJobById(id);
    }

    @PutMapping("update")
    public String updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return "Job Updated";

    }

    @PatchMapping("/changeStatus/{id}")
    public String changeJobStatus(@PathVariable("id") String id) {
        jobService.changeJobStatus(id);
        return "Job Status Changed";
    }

    @GetMapping("search/{keyword}")
    public List<JobDTO> searchJob(@PathVariable("keyword") String keyword) {
        return jobService.getAllJobsByKeyword(keyword);
    }

    @PutMapping(value = "delete" , params = "id")
    public String deleteJob(@RequestParam("id") String id) {
        jobService.deleteJob(id);
        return "Job Deleted";
    }

    @GetMapping("getalljobs")
    public List<JobDTO> getAllJobs(){
        return jobService.getAllJobs();
    }
}
