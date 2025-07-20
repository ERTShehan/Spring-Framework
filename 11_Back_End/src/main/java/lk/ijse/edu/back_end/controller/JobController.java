package lk.ijse.edu.back_end.controller;

import jakarta.validation.Valid;
import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.service.impl.JobServiceImpl;
import lk.ijse.edu.back_end.util.APIResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class JobController {
    private final JobServiceImpl jobService;
//    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @PostMapping("/create")
    public ResponseEntity<APIResponse<String>> createJob(@RequestBody JobDTO jobDTO) {
//        logger.info("Job Created Successfully");
//        logger.debug("Job Details: {}", jobDTO);
//        logger.error("Job Creation Failed");
//        logger.trace("Job Creation Trace Log");
//        logger.warn("Job Creation Warning");

        log.info("Job Created Successfully");
        log.debug("Job Details: {}", jobDTO);
        log.error("Job Creation Failed");
        log.trace("Job Creation Trace Log");
        log.warn("Job Creation Warning");

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
    public ResponseEntity<APIResponse<String>> updateJob(@RequestBody @Valid JobDTO jobDTO) {
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
