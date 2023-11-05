package be.bstorm.controllers;

import be.bstorm.models.dtos.student.StudentShortDTO;
import be.bstorm.models.entities.persons.Student;
import be.bstorm.models.forms.StudentForm;
import be.bstorm.services.impl.StudentImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final String REDIRECT_TO_LIST = "redirect:/student";
    private final StudentImpl student;

    public StudentController(StudentImpl student) {
        this.student = student;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Student> students = student.findAll();
        List<StudentShortDTO> dtos = students.stream()
                .map(StudentShortDTO::fromEntity)
                .toList();
        model.addAttribute("dtos", dtos);
        return "student/index";
    }

    @GetMapping("/{id}")
    public String findOneById(@PathVariable Long id, Model model) {
        Student students = student.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
//        model.addAttribute("teacherFrom", new TeacherForm());
        return "student/create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute @Valid StudentForm studentForm) {
        Student students = studentForm.toEntity();
        student.create(students);
        return REDIRECT_TO_LIST;
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model) {
        Student students = student.findById(id);
        StudentForm studentForm = StudentForm.fromEntity(students);
        model.addAttribute("id", id);
        model.addAttribute("studentForm", studentForm);
        return "student/update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@ModelAttribute StudentForm studentForm, @PathVariable Long id) {
        Student students = studentForm.toEntity();
        student.update(id, students);
        return REDIRECT_TO_LIST;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        student.delete(id);
        return REDIRECT_TO_LIST;
    }

    @PostMapping("/search")
    public String search(@RequestParam("input") String input, Model model) {
        List<Student> students = student.findManyByName(input);
        List<StudentShortDTO> dtos = students.stream()
                .map(StudentShortDTO::fromEntity)
                .toList();
        model.addAttribute("dtos",dtos);
        return "student/index";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(Model model) {
        student.deleteAll();
        model.addAttribute("deleteAll");
        return REDIRECT_TO_LIST;
    }
}
