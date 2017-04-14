
var answerIndex=0;

function newAnswer(){
    var answer=$("#answer");
    answerIndex++;
    answer.append(" <p class='field' id='pAnswer"+answerIndex+"'> <input type='text' name='answer"+answerIndex+"' id='mail"+answerIndex+"' placeholder='Ответ'> <i class='icon-lock icon-large'></i> <button type='button' onclick='removeAnswer("+answerIndex+");'  >Удалить</button></p>");

}

function removeAnswer(index){
    var pAnswer=$("#pAnswer"+index);
    pAnswer.remove();
}

function  generateQuiz() {
    var topic=$("#topic").val();
    var quiz=$("#quiz");
    var deleteQuiz=$("#deleteQuiz");
    var quizResult=$("#quizResult");

    $.get("http://localhost:8080/add",
        {
            topic:topic,
            type: " "
        },
        function(data){
            var answer=JSON.parse(data);
            quiz.text(answer.quizLink);
            deleteQuiz.text(answer.deleteLink);
            quizResult.text(answer.resultsLink);
            
            $("#quizPre").show();
            $("#quizDel").show();
            $("#quizRes").show();
            quiz.show();
            deleteQuiz.show();
            quizResult.show();
        });
}

function  showStatistics() {
    var statistics=$("#statistics");
    var resultLink=$("#ResultLink").val();
    $.get("http://localhost:8080/statistics",
        {
            resultLink:resultLink
        },
        function(data){
            var data=JSON.parse(data);
            statistics.text(data.topic);
            for (i in data.answers) {
                statistics.append("<br>")
                var answer=data.answers[i];
                statistics.append(answer.result);
                statistics.append(answer.counter);

            }

        });
}

function deleteQuiz() {
    var delLink=$("#delLink").val();
    $.get("http://localhost:8080/delete",
        {
            delLink:delLink
        },
        function(data){
           

        });
}

function goToQuiz() {
    var topic=$("#topic");
    var answers=$("#answers");
    var quizLink=$("#quizLink").val();
    $.get("http://localhost:8080/quiz",
        {
            quizLink:quizLink
        },
        function(data){
            var data=JSON.parse(data);
            topic.append("<br>");
            topic.append(data.topic);
            for (i in data.answers) {
                    answers.append("<br>");
                    answers.append("<input type='checkbox' name='"+data.answers[i].id+"'>"+data.answers[i].result+"</input>");
                    
            }
            answers.append("<button type='submit'>Submit</button>");
            answers.show();

        });
}
