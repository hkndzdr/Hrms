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
@Table(name="hrms_personels")
@PrimaryKeyJoinColumn(name = "hrms_personel_id")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class HrmsPersonel extends User{
	/*private int hrmsPersonelId;*/
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;


}
