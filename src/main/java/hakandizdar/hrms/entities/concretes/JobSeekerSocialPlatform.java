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
@Table(name="job_seeker_social_platform")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerSocialPlatform {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "platform_link")
	private String platformLink;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	
}
