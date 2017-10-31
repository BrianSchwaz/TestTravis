import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.ScriptEngine;

public class Calulator extends Application{
	
	double x = 30,y = 50;
	static String opperation = "";
	static int first = 0,second = 0;
	static boolean before_ops = true;
	static boolean answered = true;
	static Label opperand= new Label(opperation);
	static Label firstInt= new Label("");
	static Label secondInt= new Label("");
	Button one,two,three,four,five,six,seven,eight,nine,add,subtract,multiply,divide,equals;
	boolean calculated;
	public static void main(String[] args) {
        launch(args);
    }
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Calulator");
		Pane root = new Pane();
		Scene scene = new Scene(root, 250, 350);
		opperand.setLayoutX(120);
		opperand.setLayoutY(10);
		firstInt.setLayoutX(10);
		firstInt.setLayoutY(10);
		secondInt.setLayoutX(175);
		secondInt.setLayoutY(10);
		one = createButton(one,"1",x,y);
		adjustXandY();
		two = createButton(two,"2",x,y);
		adjustXandY();
		three = createButton(three,"3",x,y);
		adjustXandY();
		add = createButton(add,"+",x,y);
		adjustXandY();
		four = createButton(four,"4",x,y);
		adjustXandY();
		five = createButton(five,"5",x,y);
		adjustXandY();
		six = createButton(six,"6",x,y);
		adjustXandY();
		subtract = createButton(subtract,"-",x,y);
		adjustXandY();
		seven = createButton(seven,"7",x,y);
		adjustXandY();
		eight = createButton(eight,"8",x,y);
		adjustXandY();
		nine = createButton(nine,"9",x,y);
		adjustXandY();
		multiply = createButton(multiply,"*",x,y);
		adjustXandY();
		divide = createButton(divide,"/",180,200);
		adjustXandY();
		equals = createButton(equals,"=",180,250);
		adjustXandY();
		
		root.getChildren().addAll(opperand,firstInt,secondInt,one,two,three,four,five,six,seven,eight,nine,add,subtract,multiply,divide,equals);

		stage.setScene(scene);
		stage.show();
	}
	
	public void adjustXandY() {
		if(x == 180)
		{
			x = 30;
			y = y + 50;
		}
		else
		{
			x = x + 50;
		}
	}
	
	public Button createButton(Button b, String s,double coordinateX,double coordinateY)
	{
		b = ButtonFactory.getButton(s);
		b.setLayoutX(coordinateX);
		b.setLayoutY(coordinateY);
		return b;
	}
	private static class ButtonFactory {
		
		public static Button getButton(String buttonType)
		{
			if(buttonType == null)
			{
				return null;
			}
			if(buttonType.equalsIgnoreCase("+"))
			{
				Button add = new Button("+");
				add.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						opperation = "+";
						before_ops = false;
						answered = false;
						opperand.setText(opperation);
					}
				});
				return add;
			}
			else if (buttonType.equalsIgnoreCase("-"))
			{
				Button sub = new Button("-");
				sub.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						opperation = "-";
						before_ops = false;
						answered = false;
						opperand.setText(opperation);
					}
				});
				return sub;
			}
			else if (buttonType.equalsIgnoreCase("*"))
			{
				Button mult = new Button("*");
				mult.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						opperation = "*";
						before_ops = false;
						answered = false;
						opperand.setText(opperation);
					}
				});
				return mult;
			}
			else if (buttonType.equalsIgnoreCase("/"))
			{
				Button div = new Button("/");
				div.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						opperation = "/";
						before_ops = false;
						answered = false;
						opperand.setText(opperation);
					}
				});
				return div;
			}
			else if (buttonType.equalsIgnoreCase("="))
			{
				Button eq = new Button("=");
				eq.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						answered = true;
						before_ops = true;
						if(opperation.equals("+"))
						{
							first = first + second;
						}
						else if(opperation.equals("-"))
						{
							first = first - second;
						}
						else if(opperation.equals("*"))
						{
							first = first * second;
						}
						else if(opperation.equals("/"))
						{
							first = first / second;
						}
						second = 0;
						opperation = "";
						opperand.setText(opperation);
						firstInt.setText(Integer.toString(first));
						secondInt.setText("");
					}
				});
				return eq;
			}
			else
			{
				Button num = new Button(buttonType);
				num.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent event) {
						if(answered == true)
						{
							first = Integer.parseInt(buttonType);
							firstInt.setText(Integer.toString(first));
							answered = false;
						}
						else
						{
							if (before_ops == true)
							{
								first = first * 10 + Integer.parseInt(buttonType);
								firstInt.setText(Integer.toString(first));
							}
							else
							{
								second = second * 10 + Integer.parseInt(buttonType);
								secondInt.setText(Integer.toString(second));
							}
						}
					}
				});
				return num;
			}
		}
	}
	
}
