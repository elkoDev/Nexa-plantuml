package at.uibk.dps.nexaplantuml.models;

import java.util.ArrayList;
import java.util.List;

public class OnTransition {

  private String source;
  private String target;
  private List<Action> actions;
  private final String event;
    private List<Guard> guards;

  public OnTransition(String source, String target, List<Action> actions, String event, List<Guard> guards) {
    this.source = source;
    this.target = target;
    this.actions = actions;
    this.event = event;
    this.guards = guards;
  }

  List<String> getDescription() {
    var list = new ArrayList<String>();
    var actionBuilder = new StringBuilder();
    var guardBuilder = new StringBuilder();
    if (guards != null) {
      guards.forEach(guard -> guardBuilder.append(guard.toString()).append(" && "));
    }
    if (actions != null) {
      actions.forEach(action -> actionBuilder.append(action.toString()).append("; "));
    }
    list.add(source + " --> " + target + " : " + event + "[" + guardBuilder + "]" + " / " + actionBuilder);
    return list;
  }

}
