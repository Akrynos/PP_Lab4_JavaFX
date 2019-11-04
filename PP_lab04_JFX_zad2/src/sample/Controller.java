package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public AreaChart areachart;
    public ScatterChart scatterchart;
    public LineChart linechart;
    @FXML
    private ComboBox comboBox;
    @FXML
    private TextField A, B, C;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().addAll("Grid one", "Grid two", "Grid three");

    }

    public void GenerateGridView() {
        if (A != null || B != null || C != null) {
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("X");
            int a = Integer.parseInt(A.getText());
            int b = Integer.parseInt(B.getText());
            int c = Integer.parseInt(C.getText());
            System.out.println(A.getText() + B.getText() + C.getCharacters());
            Integer X = (b * b - (4 * a * c));
            if (X > 0) {
                System.out.println(X);
                String s = (String)comboBox.getValue().toString();
                XYChart.Series series = new XYChart.Series();
                series.setName("f(x)="+a+"x^2+"+b+"x+"+c);
                for(Integer i=-10; i< 10; i++){
                    X = (a*(i*i)+b*i+c);
                    series.getData().add(new XYChart.Data(i, X));
                }
                switch (s) {
                    case "Grid one":
                        System.out.println("HERE IS OPTION ONE");
                        linechart.setVisible(true);
                        scatterchart.setVisible(false);
                        areachart.setVisible(false);
                        linechart.setTitle("Line chart");
                        linechart.getData().add(series);
                        break;
                    case "Grid two":
                        System.out.println("HERE IS OPTION TWO");
                        linechart.setVisible(false);
                        scatterchart.setVisible(true);
                        areachart.setVisible(false);
                        scatterchart.setTitle("Scatter chart");
                        scatterchart.getData().add(series);
                        break;
                    case "Grid three":
                        linechart.setVisible(false);
                        scatterchart.setVisible(false);
                        areachart.setVisible(true);
                        areachart.setTitle("Area chart");
                        areachart.getData().add(series);
                        System.out.println("HERE IS OPTION THREE");
                        break;
                }
            }
        } else {

        }
    }

    public void ClearGridView(ActionEvent actionEvent) {
        String s = (String)comboBox.getValue().toString();
        switch (s) {
            case "Grid one":
                linechart.setVisible(false);
                scatterchart.setVisible(true);
                areachart.setVisible(false);
                linechart.setTitle("Linechart");
                linechart.getData().removeAll(linechart.getData());
                break;
            case "Grid two":
                linechart.setVisible(false);
                scatterchart.setVisible(true);
                areachart.setVisible(false);
                scatterchart.setTitle("Scatter chart");
                scatterchart.getData().removeAll(scatterchart.getData());
                break;
            case "Grid three":
                linechart.setVisible(false);
                scatterchart.setVisible(false);
                areachart.setVisible(true);
                areachart.setTitle("Area chart");
                areachart.getData().removeAll(areachart.getData());
                break;
        }
    }
}
