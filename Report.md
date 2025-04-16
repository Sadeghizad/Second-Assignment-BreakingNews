# Breaking News - Java API Project

A simple Java application that fetches real-time news from NewsAPI.org and presents the latest headlines. This project integrates API requests, JSON parsing, and a JavaFX-based GUI.

## Description

This project is designed as a news aggregator that retrieves news articles from an external API and presents them in an interactive GUI. The application allows users to search for news articles, view article details, and open them in a web browser. Additionally, it incorporates object-oriented programming (OOP) principles and error handling mechanisms to ensure robustness.

## Getting Started

### Dependencies

* Java 21 or later
* Gradle
* Gson (for JSON parsing)
* JavaFX (for GUI implementation)
* NewsAPI.org API key
* Windows 10/11 (Recommended)

### Installing

1. Clone the repository:
   ```bash
   git clone https://github.com/sadeghizad/BreakingNews.git
   cd BreakingNews
   ```
2. Create a new branch for development:
   ```bash
   git checkout -b development
   ```
3. Ensure Gradle and Java are installed:
   ```bash
   java -version
   gradle -v
   ```
4. Add your API key to the `Infrastructure` class:
   ```java
   private static final String API_KEY = "none-of-your-business-bro";
   ```

### Executing Program

1. Build the project using Gradle:
   ```bash
   gradle build
   ```
2. Run the application:
   ```bash
   gradle run
   ```
3. If running via IntelliJ IDEA:
  * Open `Run/Debug Configurations`
  * Set VM options:
    ```
    --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml
    ```
  * Click **Run**

## Features

- **Search News**: Users can enter keywords to fetch related news.
- **View Details**: Clicking a headline expands the news article details.
- **Open in Browser**: Users can open the original article link.
- **Error Handling**: Handles API errors and missing fields.
- **JavaFX GUI**: Provides a clean and interactive user interface.

## Help

If you encounter any issues, try:
```bash
gradle --stacktrace
```
Ensure you have set up JavaFX correctly.

## Authors

- Your Name
- Contact: [Sadeghziad](https://github.com/sadeghizad)

## Version History

* 1.0 - Initial Release

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

## Acknowledgments

- [NewsAPI.org](https://newsapi.org/) for providing free API access.
- [Gson](https://github.com/google/gson) for JSON parsing.
- [JavaFX Tutorials](https://www.youtube.com/c/BroCode) by BroCode.
