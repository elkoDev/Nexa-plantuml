package at.uibk.dps.nexaplantuml.models;

import java.util.ArrayList;
import java.util.List;

public class State {
  private final String name;
  private final boolean isInitial;
  private final boolean isTerminal;

  private final List<Action> entry;
  private final List<Action> exit;
  private final List<Action> whilee;


  public State(String name, List<Action> entry, List<Action> exit, List<Action> whilee,
      boolean isInitial, boolean isTerminal) {
    this.name = name;
    this.entry = entry;
    this.exit = exit;
    this.whilee = whilee;
    this.isInitial = isInitial;
    this.isTerminal = isTerminal;
  }

  public List<String> getDescription() {
    var list = new ArrayList<String>();

    if (isInitial) {
      list.add("[*] --> " + name);
    }
    if (isTerminal) {
      list.add(name + " --> [*]");
    }

    if (entry != null && !entry.isEmpty()) {
      var builder = new StringBuilder();
      entry.forEach(action -> builder.append(action.toString()).append("; "));
      list.add(name + " : entry / " + builder);
    }

    if (exit != null && !exit.isEmpty()) {
      var builder = new StringBuilder();
      exit.forEach(action -> builder.append(action.toString()).append("; "));
      list.add(name + " : exit / " + builder);
    }

    if (whilee != null && !whilee.isEmpty()) {
      var builder = new StringBuilder();
      whilee.forEach(action -> builder.append(action.toString()).append("; "));
      list.add(name + " : while / " + builder);
    }

    return list;
  }



}
