package hakandizdar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="educations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="university_name")
	private String universityName;
	
	@Column(name="university_branch")
	private String universityBranch;
	
	@Column(name="start_year")
	private String startYear;
	
	@Column(name="graduation_year")
	private String graduationYear;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
}