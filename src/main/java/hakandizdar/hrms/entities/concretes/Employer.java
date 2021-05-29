package hakandizdar.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "employer_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User {
	/*
	 * @Column(name="employer_id")
	 *  private int employerId;
	 */
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website_address")
	private String websiteAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;

	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
	/*@OneToOne(mappedBy="employer", cascade=CascadeType.ALL)
	private User user;*/
}
