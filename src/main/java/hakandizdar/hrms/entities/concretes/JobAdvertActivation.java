package hakandizdar.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertActivation {
	@Id
    @Column(name = "job_advert_id")
    private int jobAdvertId;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "confirm")
    private boolean confirm;

    @Column(name = "confirm_date")
    private LocalDate confirmDate;

}
