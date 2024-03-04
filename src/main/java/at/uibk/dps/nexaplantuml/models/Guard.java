package at.uibk.dps.nexaplantuml.models;

public class Guard {
  private final String expression;

    public Guard(String expression) {
        this.expression = expression;
    }

    public String toString() {
        return expression;
    }
}
