package gb.controller;

import gb.dto.StudentDto;
import gb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public void addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("delete/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("update")
    public void updateStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
    }


}
