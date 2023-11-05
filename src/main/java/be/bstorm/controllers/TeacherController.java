package be.bstorm.controllers;

import be.bstorm.models.dtos.teacher.TeacherShortDTO;
import be.bstorm.models.entities.persons.Teacher;
import be.bstorm.models.forms.TeacherForm;
import be.bstorm.services.impl.TeacherImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final String REDIRECT_TO_LIST = "redirect:/teacher";
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
        model.addAttribute("teacherFrom", new TeacherForm());
        return "teacher/create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute @Valid TeacherForm teacherForm) {
        Teacher teachers = teacherForm.toEntity();
        teacher.create(teachers);
        return REDIRECT_TO_LIST;
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model) {
        Teacher teachers = teacher.findById(id);
        TeacherForm teacherForm = TeacherForm.fromEntity(teachers);
        model.addAttribute("id", id);
        model.addAttribute("teacherForm", teacherForm);
        return "teacher/update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@ModelAttribute TeacherForm teacherForm, @PathVariable Long id) {
        Teacher teachers = teacherForm.toEntity();
        teacher.update(id, teachers);
        return REDIRECT_TO_LIST;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        teacher.delete(id);
        return REDIRECT_TO_LIST;
    }

    @PostMapping("/search")
    public String search(@RequestParam("input") String input, Model model) {
        List<Teacher> teachers = teacher.findManyByName(input);
        List<TeacherShortDTO> dtos = teachers.stream()
                .map(TeacherShortDTO::fromEntity)
                .toList();
        model.addAttribute("dtos",dtos);
        return "teacher/index";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(Model model) {
        teacher.deleteAll();
        model.addAttribute("deleteAll");
        return REDIRECT_TO_LIST;
    }
}
