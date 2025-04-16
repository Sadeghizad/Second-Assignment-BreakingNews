package AP;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.net.URI;
import java.util.List;

public class Main extends Application {

    Infrastructure infra;
    List<News> newsList;
    private String selectedNewsFormatted(News news) {
        return "Title: " + news.title + "\n" +
                "Author: " + news.author + "\n" +
                "Source: " + news.sourceName + "\n" +
                "Published At: " + news.publishedAt + "\n\n" +
                "Description: " + news.description + "\n\n" +
                "Content: " + news.content + "\n\n" +
                "Read more: " + news.url;
    }


    @Override
    public void start(Stage primaryStage) {
        TextField queryField = new TextField();
        queryField.setPromptText("Enter search phrase");

        Button searchButton = new Button("Search News");

        ListView<String> newsTitlesList = new ListView<>();
        TextArea detailsArea = new TextArea();
        detailsArea.setWrapText(true);
        detailsArea.setEditable(false);

        Button openUrlBtn = new Button("Open News in Browser");
        openUrlBtn.setDisable(true);

        searchButton.setOnAction(e -> {
            String query = queryField.getText();
            Infrastructure infra = new Infrastructure("ce282472d9a8479b8808363fe180864e", query);
            newsList = infra.getNewsList();
            newsTitlesList.getItems().clear();

            for (News news : newsList) {
                newsTitlesList.getItems().add(news.title);
            }
        });

        newsTitlesList.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            int idx = newVal.intValue();
            if (idx >= 0 && idx < newsList.size()) {
                News selectedNews = newsList.get(idx);
                detailsArea.setText(selectedNewsFormatted(selectedNews));
                openUrlBtn.setDisable(false);
            }
        });

        openUrlBtn.setOnAction(e -> {
            int idx = newsTitlesList.getSelectionModel().getSelectedIndex();
            if (idx >= 0 && Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(newsList.get(idx).url));
                } catch (Exception ex) {
                    System.out.println("Couldn't open URL: " + ex.getMessage());
                }
            }
        });

        VBox root = new VBox(10, queryField, searchButton, newsTitlesList, detailsArea, openUrlBtn);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setTitle("News Finder 2000");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
