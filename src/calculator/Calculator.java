
package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {
    //input text to receved number from user
    static TextField input = new TextField();
    // 16 buttons to build buttons of calculator
    static Button btn = new Button("7");
    static Button btn1 = new Button("8");
    static Button btn2 = new Button("9");
    static Button btn3 = new Button("+");
    static Button btn4 = new Button("4");
    static Button btn5 = new Button("5");
    static Button btn6 = new Button("6");
    static Button btn7 = new Button("-");
    static Button btn8 = new Button("1");
    static Button btn9 = new Button("2");
    static Button btn10 = new Button("3");
    static Button btn11 = new Button("*");
    static Button btn12 = new Button("C");
    static Button btn13 = new Button("0");
    static Button btn14 = new Button("=");
    static Button btn15 = new Button("/");
    //to save number 1 from text input
    double number1 ;
     //to save number 2 from text input
    double number2 ;
     //to save operation in it
    double result ;
    //to select operation from it
    char operator ;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(mainScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public Scene mainScene(){
        // container of calculator
        VBox calc = new VBox();
        // used to add input text on it
        VBox screen = new VBox();
        screen.setAlignment(Pos.CENTER);
        // uset to add all buttons on it
        GridPane butt = new GridPane();
        // add screen an butt on calc
        calc.getChildren().addAll(screen, butt);
        // add input text on screen and set some properties to input text
        screen.getChildren().addAll(input);
        input.setMinSize(255, 50);
        input.setFont(new Font(20));
        input.setAlignment(Pos.CENTER_RIGHT);
        // set size an action event to button number seven
        btn.setMinSize(60, 40);
        btn.setOnAction((event) -> {
            setNumber("7");
        });
        btn.setFont(new Font(20));
        // set size an action event to button number eight
        btn1.setMinSize(60, 40);
        btn1.setFont(new Font(20));
        btn1.setOnAction((event) -> {
            setNumber("8");
        });
          // set size an action event to button number nine
        btn2.setMinSize(60, 40);
        btn2.setFont(new Font(20));
        btn2.setOnAction((event) -> {
            setNumber("9");
        });
          // set size an action event to button handdel add operation
        btn3.setMinSize(60, 40);
         btn3.setFont(new Font(20));
         Add add = new Add();
         btn3.setOnAction(add);
        // set size an action event to button number four 
        btn4.setMinSize(60, 40);
        btn4.setFont(new Font(20));
        btn4.setOnAction((event) -> {
           setNumber("4");
        });
        // set size an action event to button number five
        btn5.setMinSize(60, 40);
         btn5.setFont(new Font(20));
         btn5.setOnAction((event) -> {
            setNumber("5");
        });
         // set size an action event to button number six
        btn6.setMinSize(60, 40);
         btn6.setFont(new Font(20));
         btn6.setOnAction((event) -> {
            setNumber("6");
        });
         // set size an action event to button handdel subtract operation
        btn7.setMinSize(60, 40);
         btn7.setFont(new Font(20));
         Sub sub = new Sub();
         btn7.setOnAction(sub);
         // set size an action event to button number one 
        btn8.setMinSize(60, 40);
         btn8.setFont(new Font(20));
         btn8.setOnAction((event) -> {
           setNumber("1");
        });
          // set size an action event to button number two
        btn9.setMinSize(60, 40);
         btn9.setFont(new Font(20));
         btn9.setOnAction((event) -> {
            setNumber("2");
        });
          // set size an action event to button number three
        btn10.setMinSize(60, 40);
         btn10.setFont(new Font(20));
         btn10.setOnAction((event) -> {
            setNumber("3");
        });
         // set size an action event to button handdel mulltiplication operation
        btn11.setMinSize(60, 40);
         btn11.setFont(new Font(20));
         Mull mull = new Mull();
         btn11.setOnAction(mull);
         // set size an action event to button handdel clear 
        btn12.setMinSize(60, 40);
         btn12.setFont(new Font(20));
         btn12.setOnAction((event) -> {
            input.setText("");
        });
         // set size an action event to button number 0
        btn13.setMinSize(60, 40);
         btn13.setFont(new Font(20));
         btn13.setOnAction((event) -> {
            setNumber("0");
        });
         // set size an action event to button handdel equal operation 
        btn14.setMinSize(60, 40);
         btn14.setFont(new Font(20));
         Equal egual = new Equal();
         btn14.setOnAction(egual);
         // set size an action event to button handdel divition operation 
        btn15.setMinSize(60, 40);
         btn15.setFont(new Font(20));
         Div div = new Div();
         btn15.setOnAction(div);
         
         // add all buttons to grid pane
        butt.add(btn, 0, 0);
        butt.add(btn1, 1, 0);
        butt.add(btn2, 2, 0);
        butt.add(btn3, 3, 0);
        butt.add(btn4, 0, 1);
        butt.add(btn5, 1, 1);
        butt.add(btn6, 2, 1);
        butt.add(btn7, 3, 1);
        butt.add(btn8, 0, 2);
        butt.add(btn9, 1, 2);
        butt.add(btn10, 2, 2);
        butt.add(btn11, 3, 2);
        butt.add(btn12, 0, 3);
        butt.add(btn13, 1, 3);
        butt.add(btn14, 2, 3);
        butt.add(btn15, 3, 3);
        butt.setVgap(5);
        butt.setHgap(5);
        butt.setAlignment(Pos.CENTER);
        return new Scene(calc, 255, 245);
    }
    //handdle add operation
     class Add implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            // save number1 from text input and select add operation
           number1 = Double.parseDouble(input.getText());
           input.setText("");
           operator = '+';
        }
        
    }
    //handdle subtract operation
      class Sub implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            // save number1 from text input and select sub operation
            number1 = Double.parseDouble(input.getText());
           input.setText("");
           operator = '-';
        }
        
    }
     //handdle mulltiplication operation
       class Mull implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            // save number1 from text input and select mull operation
           number1 = Double.parseDouble(input.getText());
           input.setText("");
           operator = '*';
        }
        
    }
      //handdle division operation
       class Div implements EventHandler<ActionEvent>{
        @Override
        // save number1 from text input and select div operation
        public void handle(ActionEvent event) {
           number1 = Double.parseDouble(input.getText());
           input.setText("");
           operator = '/';
        }
        
    }
      // handdle equal buton 
     class Equal implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           number2 = Double.parseDouble(input.getText());// save number in  vareiable number2
           switch(operator){ // make operation depend on operation variable
               case '+': // if add make add event
                    result = number1 + number2;
                   break;
               case '-': // if subtract make sub event
                   result = number1 - number2;
                   break;
               case '*'://if multiplaction make mull event
                   result = number1 * number2;
                   break;
               case '/'://if divisio make div event
                   result = number1 / number2;
                   break;
           }
           // show result on input text
           input.setText(String.valueOf(result));
        
        }
        
    }
     private void setNumber(String number){
         String num = input.getText() + number ;
         input.setText(num);
     }
        
}
