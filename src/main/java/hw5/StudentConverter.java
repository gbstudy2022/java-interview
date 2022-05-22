package hw5;

import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentDto convertEntityToDto(Student student) {
        return student ==null? null : StudentDto.builder()
                .id(student.getId())
                .mark(student.getMark())
                .name(student.getName())
                .build();
    }

    public Student convertDtoToEntity(StudentDto studentDto) {
        if(studentDto==null) {
            return null;
        }
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setMark(studentDto.getMark());
        student.setName(studentDto.getName());
        return student;
    }
}
