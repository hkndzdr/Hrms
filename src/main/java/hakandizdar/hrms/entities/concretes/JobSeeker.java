package hakandizdar.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="job_seekers")
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "job_seeker_id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User{
	/*@Column(name="job_seeker_id")
	private int jobSeekerId;*/
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	/*@OneToOne(mappedBy="job_seeker", cascade=CascadeType.ALL)
	private User user;*/

}
