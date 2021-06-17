package hakandizdar.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
    private int jobPositionId;
    private int employerId;
    private String detail;
    private int cityId;
    private int minSalary;
    private int maxSalary;
    private int openPositionCount;
    private LocalDate applicationDeadline;
    private boolean isActive;
    private int workplaceId;
    private int workScheduleId;
}
