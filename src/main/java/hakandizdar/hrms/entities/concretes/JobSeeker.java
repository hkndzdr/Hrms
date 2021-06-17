package hakandizdar.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="job_seekers")
@Data
@PrimaryKeyJoinColumn(name = "job_seeker_id")
@EqualsAndHashCode(callSuper = true)
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
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<Education> educations;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<JobExperience> jobExperience;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<Image> images;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<Language> languages;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<JobSeekerSocialPlatform> jobSeekerSocialPlatforms;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<JobSeekerSkill> jobSeekerSkills;
	
	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnore
	private List<CoverLetter> coverLetters;
	
}
