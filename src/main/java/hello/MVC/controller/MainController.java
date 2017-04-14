package hello.MVC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.MVC.model.domain.Answer;
import hello.MVC.model.domain.Quiz;
import hello.MVC.model.repository.AnswerRepository;
import hello.MVC.model.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;


@RestController
public class MainController {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @RequestMapping(path="/add")
    public @ResponseBody String addNewQuiz (@RequestParam String topic
            , @RequestParam String type) throws NoSuchAlgorithmException {
        Quiz quiz = new Quiz();
        String quizLink=new String();
        String deleteLink=new String();
        String resultsLink=new String();
        quiz.setQuizType(type);
        quiz.setTopic(topic);
        quiz.setQuizLink(new Integer((quiz.getTopic()+"quiz"+(new Date())).hashCode()).toString());
        quiz.setResultsLink(new Integer((quiz.getTopic()+"result"+(new Date())).hashCode()).toString());
        quiz.setDeleteLink(new Integer((quiz.getTopic()+"delete"+(new Date())).hashCode()).toString());
        quizRepository.save(quiz);
        quizLink=quiz.getQuizLink();
        deleteLink=quiz.getDeleteLink();
        resultsLink=quiz.getResultsLink();
        return "{\"quizLink\":"+quizLink+"," +
                "\"deleteLink\":"+deleteLink+"," +
                "\"resultsLink\":"+resultsLink+"}";
    }

    @RequestMapping(path="/vote")
    public @ResponseBody String addAnswer (HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
        Map<String, String[]> params=request.getParameterMap();
        for (String a: params.keySet()){
            Answer answer = new Answer();
            answer=answerRepository.findOne(Integer.parseInt(a));
            answer.setCounter(answer.getCounter()+1);
            answerRepository.save(answer);
        }
       return "Saved";
    }

    @RequestMapping(path="/statistics")
    public @ResponseBody String showStatistics(
            @RequestParam String resultLink) throws NoSuchAlgorithmException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Quiz quiz=null;
        try {
            quiz=quizRepository.getByStatLink(resultLink);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mapper.writeValueAsString(quiz);
    }

    @RequestMapping(path="/quiz")
    public @ResponseBody String showQuiz(
            @RequestParam String quizLink) throws NoSuchAlgorithmException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Quiz quiz=null;
        try {
            quiz=quizRepository.getByQuizLink(quizLink);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mapper.writeValueAsString(quiz);
    }

    @RequestMapping(path="/delete")
    public @ResponseBody String deleteQuiz(
            @RequestParam String delLink) throws NoSuchAlgorithmException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Quiz quiz=null;
        try {
            quiz=quizRepository.getByDelLink(delLink);
        }catch (Exception e){
            e.printStackTrace();
        }
        quizRepository.delete(quiz);
        return "Deleted";
    }

}