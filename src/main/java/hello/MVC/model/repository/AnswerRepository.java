package hello.MVC.model.repository;

import hello.MVC.model.domain.Answer;
import org.springframework.data.repository.CrudRepository;


public interface AnswerRepository extends CrudRepository<Answer,Integer>,AnswerRepositoryCustom{


}
