package hakandizdar.hrms.entities.dtos;

import java.util.List;

import hakandizdar.hrms.entities.concretes.CoverLetter;
import hakandizdar.hrms.entities.concretes.Education;
import hakandizdar.hrms.entities.concretes.Image;
import hakandizdar.hrms.entities.concretes.JobExperience;
import hakandizdar.hrms.entities.concretes.JobSeeker;
import hakandizdar.hrms.entities.concretes.JobSeekerSkill;
import hakandizdar.hrms.entities.concretes.JobSeekerSocialPlatform;
import hakandizdar.hrms.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private JobSeeker jobSeeker;
	private List<Education> educations;
	private List<JobExperience> jobExperiences;
	private List<Image> images;
	private List<Language> languages;
	private List<JobSeekerSocialPlatform> jobSeekerSocialPlatforms;
	private List<JobSeekerSkill> jobSeekerSkills;
	private List<CoverLetter> coverLetters;
}
