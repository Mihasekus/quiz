package hello.MVC.model.repository;

import hello.MVC.model.domain.Quiz;


public interface QuizRepositoryCustom {
    public Quiz getByQuizLink(String link);
    public Quiz getByDelLink(String link);
    public Quiz getByStatLink(String link);

}
