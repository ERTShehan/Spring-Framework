package lk.ijse.edu.back_end.controller;

import lk.ijse.edu.back_end.dto.JobDTO;
import lk.ijse.edu.back_end.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping("create")
    public String creatJob(@RequestBody JobDTO jobDTO) {
        jobService.saveJob(jobDTO);
        return "Job Created";
    }
}
