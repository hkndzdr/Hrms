package hakandizdar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="staffs")
@PrimaryKeyJoinColumn(name = "staff_id")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Staff extends User{
	/*private int hrmsPersonelId;*/
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;


}
