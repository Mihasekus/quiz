package hello.MVC.model.repository;

import hello.MVC.model.domain.Quiz;
import org.springframework.data.repository.CrudRepository;


public interface QuizRepository extends CrudRepository<Quiz, Integer>,QuizRepositoryCustom{

}
