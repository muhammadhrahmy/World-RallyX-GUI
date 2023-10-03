module com.example.worldrallycrosschampionship {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.worldrallycrosschampionship to javafx.fxml;
    exports com.example.worldrallycrosschampionship;
}