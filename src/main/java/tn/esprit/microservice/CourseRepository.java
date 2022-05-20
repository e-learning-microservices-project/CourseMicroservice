package tn.esprit.microservice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course,Integer>{
	@Query("select c from course c where c.subject like :subject  ")
	public Page<Course> CourseBySubject(@Param("subject") String n, Pageable pageable);
}
