package GUI;

import Kernel.Process;
import Kernel.ProcessGenerator;
import MultilevelQueue.MultilevelQueueAghm;
import MultilevelQueue.ProcessGntrOmega;
import Scheduling.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//////////////////////////////////////
import static Kernel.Core.auxCalc;
import static Kernel.ProcessQueue.processesqueue;
/////////////////////////////////////////////

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    ChoiceBox choice;
    @FXML
    TextArea textArea;
    @FXML
    TextField quantum;

    public static int quantumTick;
    public static boolean exterminate = false;
    public static boolean terminar = false;
////////////////////////
    String tr;
    double promEspera;
    double promRespuesta;
    double promPenalizacion;
    //////////
    ProcessGenerator processGenerator = new ProcessGenerator();
    FirstInFirstServe fcfs = new FirstInFirstServe();
    Priority priority = new Priority();
    ShortestJobFirst shortestJobFirst = new ShortestJobFirst();
    Round_Robin roundRobin = new Round_Robin();
    //////Multilevel////////
    ProcessGntrOmega processGntrOmega = new ProcessGntrOmega();
    MultilevelQueueAghm multilevel = new MultilevelQueueAghm();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choice.getItems().addAll(
                "First-In-First-Serve","Priority","ShortestJobFirst","Round Robin","Multilevel Queue");
    }

    @FXML private void startAll(){
        String selecction = (String) choice.getSelectionModel().getSelectedItem();
        switch (selecction){
            case "First-In-First-Serve":
                processGenerator.activateThread();
                fcfs.activar();
                break;
            case "Priority":
                processGenerator.activateThread();
                priority.activar();
                break;
            case "ShortestJobFirst":
                processGenerator.activateThread();
                shortestJobFirst.activar();
                break;
            case "Round Robin":
                processGenerator.activateThread();
                roundRobin.activar();
                break;
            case "Multilevel Queue":
                processGntrOmega.activateThread();
                multilevel.start();
                break;
        }
    }

    @FXML private void stopAll(){
        terminar = true;
        String selecction = (String) choice.getSelectionModel().getSelectedItem();
        switch (selecction){
            case "First-In-First-Serve":
                processGenerator.zombification();
                if (exterminate){
                    fcfs.zombieFication();
                    tr = "";
                    promEspera = 0;
                    for (Process p: auxCalc) {
                        tr += "Tiempo llegada -> " + p.getTiempoLlegada() + " : Ticks -> " + p.getTicks() + " : Tiempo espera real ->" + p.getTiempoEspera() + "\n";
                        promEspera+=p.getTiempoEspera();
                        promRespuesta+=p.gettRespuesta();
                        promPenalizacion+=p.getPenalizacion();
                    }
                    promEspera = promEspera/auxCalc.size();
                    promRespuesta = promRespuesta/auxCalc.size();
                    promPenalizacion = promPenalizacion/auxCalc.size();
                    textArea.appendText(tr);
                    textArea.appendText("Promedio de espera: " + promEspera + "\n");
                    textArea.appendText("Promedio de respuesta: " + promRespuesta + "\n");
                    textArea.appendText("Promedio de penalizacion: " + promPenalizacion + "\n");
                }
                break;
            case "Priority":
                processGenerator.zombification();
                if (exterminate){
                    priority.zombieFication();
                    tr = "";
                    promEspera = 0;
                    for (Process p: auxCalc) {
                        tr += "Tiempo llegada -> " + p.getTiempoLlegada() + " : Ticks -> " + p.getTicks() + " : Tiempo espera real ->" + p.getTiempoEspera() + "\n";
                        promEspera+=p.getTiempoEspera();
                        promRespuesta+=p.gettRespuesta();
                        promPenalizacion+=p.getPenalizacion();
                    }
                    promEspera = promEspera/auxCalc.size();
                    promRespuesta = promRespuesta/auxCalc.size();
                    promPenalizacion = promPenalizacion/auxCalc.size();
                    textArea.appendText(tr);
                    textArea.appendText("Promedio de espera: " + promEspera + "\n");
                    textArea.appendText("Promedio de respuesta: " + promRespuesta + "\n");
                    textArea.appendText("Promedio de penalizacion: " + promPenalizacion + "\n");
                }
                break;
            case "ShortestJobFirst":
                processGenerator.zombification();
                if (exterminate){
                    shortestJobFirst.zombieFication();
                    tr = "";
                    promEspera = 0;
                    for (Process p: auxCalc) {
                        tr += "Tiempo llegada -> " + p.getTiempoLlegada() + " : Ticks -> " + p.getTicks() + " : Tiempo espera real ->" + p.getTiempoEspera() + "\n";
                        promEspera+=p.getTiempoEspera();
                        promRespuesta+=p.gettRespuesta();
                        promPenalizacion+=p.getPenalizacion();
                    }
                    promEspera = promEspera/auxCalc.size();
                    promRespuesta = promRespuesta/auxCalc.size();
                    promPenalizacion = promPenalizacion/auxCalc.size();
                    textArea.appendText(tr);
                    textArea.appendText("Promedio de espera: " + promEspera + "\n");
                    textArea.appendText("Promedio de respuesta: " + promRespuesta + "\n");
                    textArea.appendText("Promedio de penalizacion: " + promPenalizacion + "\n");
                }
                break;
            case "Round Robin":
                processGenerator.zombification();
                System.err.println(exterminate + "<<<<<");
                System.err.println("Queue size: " + processesqueue.size());
                if (exterminate){
                    System.out.println(processesqueue.size());
                    roundRobin.zombieFication();
                    tr = "";
                    promEspera = 0;
                    for (Process p: auxCalc) {
                        tr += "Tiempo llegada -> " + p.getTiempoLlegada() + " : Ticks -> " + p.getTicks() + " : Tiempo espera real ->" + p.getTiempoEspera() + "\n";
                        promEspera+=p.getTiempoEspera();
                        promRespuesta+=p.gettRespuesta();
                        promPenalizacion+=p.getPenalizacion();
                    }
                    promEspera = promEspera/auxCalc.size();
                    promRespuesta = promRespuesta/auxCalc.size();
                    promPenalizacion = promPenalizacion/auxCalc.size();
                    textArea.appendText(tr);
                    textArea.appendText("Promedio de espera: " + promEspera + "\n");
                    textArea.appendText("Promedio de respuesta: " + promRespuesta + "\n");
                    textArea.appendText("Promedio de penalizacion: " + promPenalizacion + "\n");
                }
                break;
            case "Multilevel Queue":
                processGntrOmega.zombification();
                if (exterminate) {
                    multilevel.zombification();
                    tr = "";
                    promEspera = 0;
                    for (Process p : auxCalc) {
                        tr += "Tiempo llegada -> " + p.getTiempoLlegada() + " : Ticks -> " + p.getTicks() + " : Tiempo espera real ->" + p.getTiempoEspera() + "\n";
                        promEspera += p.getTiempoEspera();
                        promRespuesta += p.gettRespuesta();
                        promPenalizacion += p.getPenalizacion();
                    }
                    promEspera = promEspera / auxCalc.size();
                    promRespuesta = promRespuesta / auxCalc.size();
                    promPenalizacion = promPenalizacion / auxCalc.size();
                    textArea.appendText(tr);
                    textArea.appendText("Promedio de espera: " + promEspera + "\n");
                    textArea.appendText("Promedio de respuesta: " + promRespuesta + "\n");
                    textArea.appendText("Promedio de penalizacion: " + promPenalizacion + "\n");
                    break;
                }
        }
    }

    @FXML private void getQuantum(){
        try {
            quantumTick = Integer.parseInt(quantum.getText());
        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("It's not an integer type");
            alert.setContentText(ex.getMessage());
        }
    }

    private void data(){

    }
}
