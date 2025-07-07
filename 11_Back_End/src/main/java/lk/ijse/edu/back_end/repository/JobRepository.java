package lk.ijse.edu.back_end.repository;

import lk.ijse.edu.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
}
