package be.bstorm.controllers;

import be.bstorm.models.dtos.TeacherShortDTO;
import be.bstorm.models.entities.persons.Teacher;
import be.bstorm.services.impl.TeacherImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherImpl teacher;

    public TeacherController(TeacherImpl teacher) {
        this.teacher = teacher;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Teacher> teachers = teacher.findAll();
        List<TeacherShortDTO> dtos = teachers.stream()
                .map(TeacherShortDTO::fromEntity)
                .toList();
        model.addAttribute("dtos", dtos);
        return "teacher/index";
    }

    @GetMapping("/{id}")
    public String findOneById(@PathVariable Long id, Model model) {
        Teacher teachers = teacher.findById(id);
        model.addAttribute("teacher", teacher);
        return "teacher/detail";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("teacherFrom");
                return null; // TODO: 11/5/2023 todo 
    }
}
