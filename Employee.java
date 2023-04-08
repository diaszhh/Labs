package practiceMavenSkillbox;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@ToString
public class Employee {
    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Integer salary;
    @Getter
    @Setter
    private Date workStart;

    public Employee(String name, Integer salary, Date workStart) {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
    }
}


