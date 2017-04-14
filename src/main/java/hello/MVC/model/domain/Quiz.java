package hello.MVC.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String topic;

    private String quizLink;

    private String deleteLink;

    private String resultsLink;

    private String quizType;

    @OneToMany(mappedBy = "quiz",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Answer> answers;

    public List<Answer> getAnswers() {
            return answers;
        }

    public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

    public String getTopic() {
            return topic;
        }

    public void setTopic(String topic) {
            this.topic = topic;
        }

    public String getQuizLink() {
            return quizLink;
        }

    public void setQuizLink(String quizLink) {
            this.quizLink = quizLink;
        }

    public String getDeleteLink() {
            return deleteLink;
        }

    public void setDeleteLink(String deleteLink) {
            this.deleteLink = deleteLink;
        }

    public String getResultsLink() {
            return resultsLink;
        }

    public void setResultsLink(String resultsLink) {
            this.resultsLink = resultsLink;
        }

    public String getQuizType() {
            return quizType;
        }

    public void setQuizType(String quizType) {
            this.quizType = quizType;
        }

    public Integer getId() {
                return id;
            }

    public void setId(Integer id) {
            this.id = id;
        }



}
