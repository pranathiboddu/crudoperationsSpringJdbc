package com.stackroute.Controller;

import com.stackroute.Dao.StudentDao;
import com.stackroute.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentDao studentDao;//will inject dao from XML file

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */
    @RequestMapping("/studentform")
    public String showform(Model model){
        model.addAttribute("command", new Student());
        return "studentform";
    }
    /*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("student") Student student){
        studentDao.saveStudent(student);
        return "redirect:/viewstudent";//will redirect to viewemp request mapping
    }
    /* It provides list of employees in model object */
    @RequestMapping("/viewstudent")
    public String viewemp(Model model){
        List<Student> list=studentDao.getAllStudents();
        model.addAttribute("list",list);
        return "viewstudent";
    }
    /* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/
    @RequestMapping(value="/editstudent/{id}")
    public String edit(@PathVariable int id, Model model){
        Student student=studentDao.getStudentById(id);
        model.addAttribute("command",student);
        return "studenteditform";
    }
    /* It updates model object. */
    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("student") Student student){
        studentDao.updateStudent(student);
        return "redirect:/viewstudent";
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */
    @RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Student student){
        studentDao.deleteStudent(student);
        return "redirect:/viewstudent";
    }
}

