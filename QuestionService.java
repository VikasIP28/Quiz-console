

import java.util.Scanner;

public class QuestionService {
    Question[] questions=new Question[5];
    String[] Selection=new String[5]; 
    Scanner sc=new Scanner(System.in);
    public QuestionService(){
        questions[0] =new Question(1, "What is size of int", "2", "6", "4", "8", "4");
        questions[1] =new Question(2, "What are the core concept of OOPs", "Inheritance", "encapsulation", "Polymorphism", "All the above", "All the above");
        questions[2] =new Question(3, "which of the following is false", "Constructor return Value", "constructor doesnt have return type", "constructor name should be same as class name ", "there is no restriction on access specifier", "Constructor return Value");
        questions[3] =new Question(4, "What is size of long", "2", "6", "4", "8", "2");
        questions[4] =new Question(5, "What is size of Char", "2", "1", "4", "8", "1");
    }

    public void displayQuestion(){
        int i=0;
       
        for (Question q : questions) {
            System.out.println("Q.No "+ q.getId()+" "+q.getQuestion());
           
            System.out.println(" a). "+q.getOpt1());
            System.out.println(" b). "+q.getOpt2());
            System.out.println(" c). "+q.getOpt3());
            System.out.println(" d). "+q.getOpt4());
            System.out.print("Your Answer:");
            
            String raw = sc.nextLine().trim();
            Selection[i] = normalizeChoice(raw, q);
            i++;
            
        }

        System.out.println("Option entered by you are");
        for(String s:Selection){
                System.out.println(s);
        }
    }

    private String normalizeChoice(String input, Question q) {
        if (input == null || input.isEmpty()) return "";
    
        input = input.trim().toLowerCase();
    
        switch (input) {
            case "1":
            case "a":
                return q.getOpt1();
          
            case "2":
            case "b":
                return q.getOpt2();
            case "3":
            case "c":
                return q.getOpt3();
            case "4":
            case "d":
                return q.getOpt4();
            default:
                return "INVALID";
        }
    }
    

    public void printScore(){
        int score=0;
        for(int i=0;i<questions.length;i++){
            Question que=questions[i];
            String actualAns=que.getAns();
            String userAns=Selection[i];
            if(actualAns.equals(userAns)){
                score++;
            }
           
        }
        System.out.println("Score :\n\t"+score);
    }
        
}
