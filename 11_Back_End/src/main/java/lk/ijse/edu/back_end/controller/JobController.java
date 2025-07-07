package lk.ijse.edu.back_end.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/job")
public class JobController {
    @PostMapping("create")
    public String creatJob() {
        return "Job Created";
    }

    @GetMapping("getall")
    public String getAllJobs() {
        return "Job Retrieved";
    }

    @PutMapping("update")
    public String updateJob() {
        return "Job Updated";
    }

    @PutMapping("changeStatus")
    public String changeJobStatus() {
        return "Job Deleted";
    }

    @GetMapping("search")
    public String searchJob() {
        return "Job Searched";
    }
}
