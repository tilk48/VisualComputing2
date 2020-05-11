package übung2;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Controller2 {

    public void checkNumbers(String text){
        if (!text.matches("^[-+]?\\d+(\\.\\d+)?$") && text == null) {
            System.out.println("Input not valid. Needs numerical numbers.");
        }
        else {
            System.out.println("Input valid.");
        }
    }

    public void checkISBN(String text){
        //isbn pattern with minus sign and a total of 13 numbers
        //needs a 978-1-86197-876-9 pattern
        if (!text.matches("[0-9]*[-][0-9]*[-][0-9]*[-][0-9]*[-][0-9]*") && text == null){
            System.out.println("Input not valid. Needs numerical numbers.");
        }
        else {
            System.out.println("Input valid.");
        }
    }

    public void checkTextfield(Button button, TextField textField1,TextField textField2,TextField textField3){
        if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty()){
            button.disableProperty().bind(textField1.textProperty().isEmpty().
                    or(textField2.textProperty().isEmpty().
                            or(textField3.textProperty().isEmpty())));
        }
    }

    public void checkDate(DatePicker date){
        if (date == null){
            System.out.println("Invalid");
        }
    }
}
