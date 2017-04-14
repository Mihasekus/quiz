package hello.MVC.model.repository.impl;

import hello.MVC.model.domain.Quiz;
import hello.MVC.model.repository.QuizRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class QuizRepositoryImpl implements QuizRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;

    public Quiz getByQuizLink(String link) {
        Query query= entityManager.createNativeQuery("SELECT * from quiz where quiz_link=?",Quiz.class);
        query.setParameter(1,link);
        return (Quiz) query.getResultList().get(0);
    }

    public Quiz getByDelLink(String link) {
        Query query= entityManager.createNativeQuery("SELECT * from quiz where delete_link=?",Quiz.class);
        query.setParameter(1,link);
        return (Quiz) query.getResultList().get(0);
    }

    public Quiz getByStatLink(String link) {
        Query query= entityManager.createNativeQuery("SELECT * from quiz where results_link=?",Quiz.class);
        query.setParameter(1,link);
        return (Quiz) query.getResultList().get(0);
    }

}
