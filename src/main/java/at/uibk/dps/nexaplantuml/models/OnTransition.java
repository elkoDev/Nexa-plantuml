package at.uibk.dps.nexaplantuml.models;

import java.util.ArrayList;
import java.util.List;

public class OnTransition {

  private String source;
  private String target;
  private List<Action> actions;
  private final String event;

  public OnTransition(String source, String target, List<Action> actions, String event) {
    this.source = source;
    this.target = target;
    this.actions = actions;
    this.event = event;
  }

  List<String> getDescription() {
    var list = new ArrayList<String>();
    var builder = new StringBuilder();
    actions.forEach(action -> builder.append(action.toString()).append("; "));
    list.add(source + " --> " + target + " : " + event + " / " + builder);
    return list;
  }

}
