package se.lnu.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import se.lnu.dao.GradeDao;
import se.lnu.dao.UserDao;
import se.lnu.entity.Grade;

@RequestMapping("/")
@Controller
public class GradeController {
	
    @Autowired
    GradeDao gradeDao;
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/grade", method = RequestMethod.GET)
    public String getGrade(ModelMap model) {
    	model.addAttribute( "grade", new Grade());
    	model.addAttribute( "grades", gradeDao.findAllGrades());
    	model.addAttribute( "users", userDao.getUsersByRole("ROLE_USER"));
        return "grade/set_grade";
    }
    
    @RequestMapping(value = "/grade/setGrade", method = RequestMethod.POST)
    public String setGrade(@Valid @ModelAttribute("grade") Grade grade, ModelMap model) {
    	gradeDao.addGrade(grade);
    	model.addAttribute( "grades", gradeDao.findAllGrades());
        return "grade/set_grade";
    }
}