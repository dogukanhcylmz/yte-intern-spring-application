package yte.intern.application.student.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.application.common.response.MessageResponse;
import yte.intern.application.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students") //tüm hepsine etki etmesini sağlıyor
@RequiredArgsConstructor
public class StudentController {

    // url de pathlerin başına /api demek gerekiyor yoksa backende gereksiz istekler de atar

    private final StudentService studentService;

    @PostMapping
    public MessageResponse addStudent(@RequestBody @Valid AddStudentRequest request) {
        return studentService.addStudent(request.toEntity());
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(StudentResponse::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return StudentResponse.fromEntity(studentService.getStudentById(id));
    }

    @PutMapping("/{id}")
    public MessageResponse updateStudent(@RequestBody @Valid UpdateStudentRequest request,
                                         @PathVariable Long id) {
        return studentService.updateStudent(id, request.toEntity());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}