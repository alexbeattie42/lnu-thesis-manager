package se.lnu.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.lnu.dao.DocumentDao;
import se.lnu.entity.Feedback;

@RequestMapping("/document")
@Controller
public class DocumentController {
    final static Logger LOG = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    private DocumentDao DocumentDao;

    @RequestMapping(method = RequestMethod.GET)
    public Feedback saveFeedback(ModelMap modelMap){

        return null;
    }



}
