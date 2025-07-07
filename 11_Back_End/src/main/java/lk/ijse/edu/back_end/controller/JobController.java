package lk.ijse.edu.back_end.controller;

import lk.ijse.edu.back_end.dto.JobDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job")
public class JobController {
    @PostMapping("create")
    public String creatJob(@RequestBody JobDTO jobDTO) {
        System.out.println("Job Title: " + jobDTO.getJobTitle());
        return "Job Created";
    }
}
