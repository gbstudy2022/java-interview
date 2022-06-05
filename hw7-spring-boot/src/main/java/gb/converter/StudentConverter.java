package gb.converter;

import gb.dto.StudentDto;
import gb.entity.Student;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class StudentConverter {

    public StudentDto entityToDto(Student student) {
        if(isNull(student)) {
            return null;
        }
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .build();
    }

    public Student dtoToEntity(StudentDto studentDto) {
        if(isNull(studentDto)) {
            return null;
        }
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return student;
    }
}
