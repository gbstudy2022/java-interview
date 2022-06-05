package gb.service;

import gb.converter.StudentConverter;
import gb.dto.StudentDto;
import gb.entity.Student;
import gb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentConverter converter;

    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(converter::entityToDto)
                .collect(Collectors.toList());
    }

    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found, id: " + id));
        return converter.entityToDto(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void addStudent(StudentDto studentDto) {
        Student student = converter.dtoToEntity(studentDto);
        if(!isNull(student)) {
            studentRepository.saveAndFlush(student);
        }
    }

}
