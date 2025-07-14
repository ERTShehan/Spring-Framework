package lk.ijse.edu.back_end.controller;

import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.service.impl.JobServiceImpl;
import lk.ijse.edu.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
@CrossOrigin
public class JobController {
    private final JobServiceImpl jobService;

    @PostMapping("/create")
    public ResponseEntity<APIResponse<String>> createJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return new ResponseEntity(new APIResponse<>(
                        201,
                        "Job Created Successfully",
                        null), HttpStatus.CREATED);
    }

    @GetMapping("/getjob/{id}")
    public JobDTO getJob(@PathVariable("id") String id) {
        return jobService.getJobById(id);
    }

    @PutMapping("update")
    public ResponseEntity<APIResponse<String>> updateJob(@RequestBody JobDTO jobDTO) {
        jobService.updateJob(jobDTO);
        return ResponseEntity.ok(new APIResponse<>(200, "Job Updated Successfully",null));
    }

    @PatchMapping("/changeStatus/{id}")
    public ResponseEntity<APIResponse<String>> changeJobStatus(@PathVariable("id") String id) {
        jobService.changeJobStatus(id);
        return ResponseEntity.ok(
                new APIResponse<>(
                        200,
                        "Job Status Changed Successfully",
                        null));
    }

    @GetMapping("search/{keyword}")
    public ResponseEntity<APIResponse<List<JobDTO>>>searchJob(@PathVariable("keyword") String keyword) {
        List<JobDTO> jobDTOS = jobService.getAllJobsByKeyword(keyword);
        return ResponseEntity.ok(new APIResponse<>(
                200,
                "",
                jobDTOS
        ));
    }

    @PutMapping(value = "delete" , params = "id")
    public ResponseEntity<APIResponse<String>> deleteJob(@RequestParam("id") String id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok(
                new APIResponse<>(
                        200,
                        "Job Deleted Successfully",
                        null));
    }

    @GetMapping("getalljobs")
    public ResponseEntity<APIResponse<List<JobDTO>>> getAllJobs(){
        List<JobDTO> jobDTOS =  jobService.getAllJobs();
        return ResponseEntity.ok(new APIResponse<>(
           200,
           "Job List Fetch Successfully",
           jobDTOS
        ));
    }
}
