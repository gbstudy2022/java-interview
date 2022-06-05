package gb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private Long id;
    private String name;
    private Integer age;
}
