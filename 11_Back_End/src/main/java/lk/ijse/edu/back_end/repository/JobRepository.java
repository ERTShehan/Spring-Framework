package lk.ijse.edu.back_end.repository;

import jakarta.transaction.Transactional;
import lk.ijse.edu.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {

    @Transactional // update wenna na meka anthuwa update eka commit wennona
    @Modifying
    @Query(value = "UPDATE Job SET status='Deactivated' WHERE id = ?1",nativeQuery = true)
    void updateJobStatus(String id);

    List<Job> findJobByJobTitleContainingIgnoreCase(String keyword);

    Job getJobById(int id);
}
