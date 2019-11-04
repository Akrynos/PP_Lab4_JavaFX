package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("PP_LAB04-JavaFX");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Zadanie1");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        series.setName("f(x)=0");
        series2.setName("f(x)=-x^2");
        series3.setName("f(x)=x^2-x+3");
        //populating the series with data
        for(int i=-10; i< 10; i++){
            series.getData().add(new XYChart.Data(i, 0));
            series2.getData().add(new XYChart.Data(i, (-1)*(i*i)));
            series3.getData().add(new XYChart.Data(i, (i*i)-i+3));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        lineChart.getData().add(series3);
        lineChart.getData().add(series2);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
