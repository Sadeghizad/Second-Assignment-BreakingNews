package AP;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.LocalDate;

public class Infrastructure {

    private final String URL;
    private final String APIKEY;
    private final String JSONRESULT;
    private ArrayList<News> newsList;


    public Infrastructure(String APIKEY, String query) {
        this.APIKEY = APIKEY;
        this.URL = "https://newsapi.org/v2/everything?q=" + query +
                "&from=" + LocalDate.now().minusDays(2) + "&sortBy=publishedAt&apiKey=";
        this.JSONRESULT = getInformation();
        this.newsList = new ArrayList<>(); // initialize clearly!
        parseInformation();
    }



    private String getInformation() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL + APIKEY))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new IOException("HTTP error code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("!!Exception : " + e.getMessage());
        }
        return null;
    }
    private void parseInformation() {
        try {
            // existing JSON parsing

        newsList = new ArrayList<>();
        if(JSONRESULT == null) return;

        JsonObject jsonObject = JsonParser.parseString(JSONRESULT).getAsJsonObject();
        JsonArray articles = jsonObject.getAsJsonArray("articles");

        for (int i = 0; i < Math.min(20, articles.size()); i++) {
            JsonObject article = articles.get(i).getAsJsonObject();

            String title = article.get("title").isJsonNull() ? "No title" : article.get("title").getAsString();
            String description = article.get("description").isJsonNull() ? "No description" : article.get("description").getAsString();
            String sourceName = article.getAsJsonObject("source").get("name").getAsString();
            String author = article.get("author").isJsonNull() ? "Unknown" : article.get("author").getAsString();
            String url = article.get("url").isJsonNull() ? "Unknown" : article.get("url").getAsString();
            String publishedAt = article.get("publishedAt").isJsonNull() ? "Unknown" : article.get("publishedAt").getAsString();
            String content = article.get("content").isJsonNull() ? "No content" : article.get("content").getAsString();

            newsList.add(new News(title, description, sourceName, author, url, publishedAt,content));
        }

        } catch (Exception e) {
            e.printStackTrace(); // helps pinpoint the exact error
        }
    }
    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public void displayNewsList() {

        if(newsList == null || newsList.isEmpty()) {
            System.out.println("No news found.");
            return;
        }
        System.out.println("Top News Headlines:");
        for (int i = 0; i < newsList.size(); i++) {
            System.out.println((i+1) + ". " + newsList.get(i).title);
        }
    }


}
