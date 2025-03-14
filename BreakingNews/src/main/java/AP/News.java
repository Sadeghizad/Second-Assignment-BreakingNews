package AP;

public class News {
    String title;
    String description;
    String sourceName;
    String author;
    String url;
    String publishedAt;
    String content;

    public News(String title, String description, String sourceName,
                String author, String url, String publishedAt, String content) {
        this.title = title;
        this.description = description;
        this.sourceName = sourceName;
        this.author = author;
        this.url = url;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public void displayNews() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Source: " + sourceName);
        System.out.println("Published At: " + publishedAt);
        System.out.println("Description: " + description);
        System.out.println("Content: " + content);
        System.out.println("Read more: " + url);
    }
}