package hakandizdar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="employers")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website_address")
	private String websiteAdress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	

}
