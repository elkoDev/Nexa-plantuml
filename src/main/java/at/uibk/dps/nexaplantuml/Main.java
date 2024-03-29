package at.uibk.dps.nexaplantuml;

import at.uibk.dps.nexaplantuml.models.*;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    PlantUml plantUml = new PlantUml();
    plantUml.withState(new State("state1", List.of(new Action("Create"), new Action("Delete")), null, null, true, false))
        .withState(new State("state2", null, null, List.of(new Action("Create"), new Action("Delete")), false, false))
        .withState(new State("state3", List.of(new Action("Create"), new Action("Delete")), List.of(new Action("Create"), new Action("Delete")), List.of(new Action("Create"), new Action("Delete")), false, true))
        .withState(new State("state4", List.of(new Action("Create"), new Action("Delete")), List.of(new Action("Create"), new Action("Delete")), List.of(new Action("Create"), new Action("Delete")), false, false))
        .withTransition(new OnTransition("state1", "state2", List.of(new Action("Create"), new Action("Delete")), "event1", null))
        .withTransition(new OnTransition("state2", "state3", List.of(new Action("Create"), new Action("Delete")), "event2", null))
        .withTransition(new OnTransition("state3", "state4", List.of(new Action("Create"), new Action("Delete")), "event3", List.of(new Guard("var1 == 10"), new Guard("var2.res == true"))));

    plantUml.createFile("test.puml");
  }
}
