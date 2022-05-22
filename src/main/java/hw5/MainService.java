package hw5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainService {

    private final StudentDao studentDao;
    private final StudentConverter converter;

    public void addStudent(String name, Integer mark) {
        studentDao.addStudent(name, mark);
    }

    public List<StudentDto> getStudents() {
        return studentDao.getStudents().stream()
                .map(converter::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public StudentDto getStudentById(Long id) {
        return converter.convertEntityToDto(studentDao.getStudentById(id));
    }

    public void updateStudent(StudentDto student) {
        studentDao.updateStudent(converter.convertDtoToEntity(student));
    }

    public void deleteStudentById(Long id) {
        studentDao.deleteStudent(studentDao.getStudentById(id));
    }
}
