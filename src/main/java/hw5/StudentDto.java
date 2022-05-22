package hw5;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    Long id;
    String name;
    Integer mark;
}
