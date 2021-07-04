package application;

import java.io.File;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) {

		FileChooser fil_chooser = new FileChooser();

		Text text = new Text();
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
		text.setFill(Color.BROWN);
		text.setX(50);
		text.setY(35);

		text.setText("Word Counter");
		Text text1 = new Text();
		text1.setText(
				"___________________________\n\nSelect a file.\n\nIt will calculate number of words.\n\nNumber of lines.\n\nNumber of digits,special characters.\n\n___________________________");
		text1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
		text1.setFill(Color.BLACK);
		text1.setX(50);
		text1.setY(100);
		Button button = new Button("Open File");
		Label v, line, cons, words, digit, spch;

		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				File file = fil_chooser.showOpenDialog(stage);
				String filevar = file.getAbsolutePath();

				int vo = 0, con = 0, li = 0, wo = 0, dig = 0, sp = 0;
				try {
					File myObj = new File(filevar);
					Scanner sc = new Scanner(myObj);
					while (sc.hasNextLine()) {
						String str = sc.nextLine();
						li++;
						for (int i = 0; i < str.length(); i++) {
							char ch = str.charAt(i);
							if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
								if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
									vo++;
								} else
									con++;
							} else if (ch >= '0' && ch <= '9')
								dig++;
							else if (ch == ' ') {
								wo++;
							} else
								sp++;
						}
					}
					sc.close();

				} catch (Exception e1) {
					System.out.println("An error occurred.");
					e1.printStackTrace();
				}
				wo = wo + 1;
				Label v = new Label("The total Vowels are :" + vo);
				Label line = new Label("The total Lines are : " + li);
				Label cons = new Label("The total Consonents are :" + con);
				Label words = new Label("The total Words are :" + wo);
				Label digit = new Label("The total digit's are :" + dig);
				Label spch = new Label("The total special character's are :" + sp);
				Group root1 = new Group(v, line, cons, words, digit, spch);
				line.setTextFill(Color.BROWN);
				line.setFont(new Font("Arial", 20));
				line.setTranslateX(60);
				line.setTranslateY(30);
				v.setTranslateX(60);
				v.setTranslateY(80);
				v.setTextFill(Color.BROWN);
				v.setFont(new Font("Arial", 20));
				cons.setTranslateX(60);
				cons.setTranslateY(130);
				cons.setTextFill(Color.BROWN);
				cons.setFont(new Font("Arial", 20));
				words.setTranslateX(60);
				words.setTranslateY(180);
				words.setTextFill(Color.BROWN);
				words.setFont(new Font("Arial", 20));
				digit.setTranslateX(60);
				digit.setTranslateY(230);
				digit.setTextFill(Color.BROWN);
				digit.setFont(new Font("Arial", 20));
				spch.setTranslateX(60);
				spch.setTranslateY(280);
				spch.setTextFill(Color.BROWN);
				spch.setFont(new Font("Arial", 20));
				Scene scene2 = new Scene(root1, 400, 400, Color.BEIGE);
				stage.setScene(scene2);

			}
		};

		button.setOnAction(event);
		button.setTranslateX(160);
		button.setTranslateY(290);

		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				File file = fil_chooser.showSaveDialog(stage);

				if (file != null) {

					Label non = new Label("No file is selected");
					Group root1 = new Group(non);
					non.setTranslateX(300);
					non.setTranslateY(290);
					Scene scene2 = new Scene(root1, 400, 400, Color.BEIGE);
				}

			}
		};

		Group root = new Group(text, text1, button);

		Scene scene1 = new Scene(root, 400, 350, Color.BEIGE);

		stage.setTitle("Word Counter");
		stage.setScene(scene1);
		stage.setResizable(false);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}