package hello.MVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @RequestMapping(path="/newQuiz")
    public ModelAndView goToQuiz(){
        return new ModelAndView("newQuiz");
    }

    @RequestMapping(path="/showStatistics")
    public ModelAndView goToStatistics(){
        return new ModelAndView("showStatistics");
    }

    @RequestMapping(path="/links")
    public ModelAndView showLinkChoice(){
        return new ModelAndView("links");
    }

    @RequestMapping(path="/quizPage")
    public ModelAndView showQuiz(){
        return new ModelAndView("quizPage");
    }

    @RequestMapping(path="/deletePage")
    public ModelAndView deleteQuiz(){
        return new ModelAndView("deletePage");
    }
}
