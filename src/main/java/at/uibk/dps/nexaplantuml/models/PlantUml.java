package at.uibk.dps.nexaplantuml.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlantUml {
  private final List<State> states = new ArrayList<>();
  private final List<OnTransition> transitions = new ArrayList<>();

  public PlantUml withState(State state) {
    states.add(state);
    return this;
  }

  public PlantUml withTransition(OnTransition transition) {
    transitions.add(transition);
    return this;
  }

  public String getDescription() {
    var builder = new StringBuilder();
    builder.append("@startuml\n");
    states.forEach(state -> state.getDescription().forEach(s -> builder.append(s).append("\n")));
    transitions.forEach(transition -> transition.getDescription().forEach(s -> builder.append(s).append("\n")));
    builder.append("@enduml");
    return builder.toString();
  }

  public void createFile(String path) {
    var file = new File(path);
    try {
      var writer = new FileWriter(file);
      writer.write(getDescription());
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
