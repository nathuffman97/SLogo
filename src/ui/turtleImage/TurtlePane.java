package ui.turtleImage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import ui.turtleGraphics.TurtleViewer;
import ui.util.UIComponent;

public class TurtlePane implements UIComponent {
	Pane pane = new Pane();
	ImageView image;
	TurtleViewer tViewer;
	
	public void initialize(TurtleViewer tv){
		tViewer = tv;
	}

	@Override
	public Node getTopLevelNode() {
		return pane;
	}
	
	private void addImage(){
		if (image != null)
			pane.getChildren().add(image);
	}
	
	public void setImage(Image i){
		if (image == null){
			image = new ImageView(i);
			setClicked();
			addImage();
		}
		else
			image.setImage(i);
		fitImage();
	}
	
	private void setClicked(){
		image.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override public void handle(MouseEvent t) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.jpeg"));
			// get current windows learned from https://stackoverflow.com/questions/13585590/how-to-get-parent-window-in-fxml-controller
			Window currentWindow = ((Node)t.getTarget()).getScene().getWindow();
			File selectedFile = fileChooser.showOpenDialog(currentWindow);
			if (selectedFile != null) {
			    String imagePath = selectedFile.getAbsolutePath();
			    if (tViewer==null)System.out.println("!!!");
			    tViewer.changeTurtleImage(imagePath);
			    changeTurtleImage(imagePath);
			}
		    }
		});
	}
	
	private void changeTurtleImage(String path) {
		InputStream is = null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println("Turtle image file not found");
			e.printStackTrace();
			return;
		}
		setImage(new Image(is));
	}
	
	private void fitImage(){
		image.setPreserveRatio(true);
		image.setFitWidth(100);
	}
}
