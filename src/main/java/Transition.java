package main.java;

import java.util.HashMap;
import java.util.Map;

public class Transition {
  private HashMap<String, Map<String, String>> transitions = new HashMap<String, Map<String, String>>();


  public void insert(String currentState, String alphabet, String nextState) {
    if (!transitions.containsKey(currentState))
      transitions.put(currentState, new HashMap<String, String>());
    transitions.get(currentState).put(alphabet, nextState);
  }

  public String nextState(String currentState, String alphabet) {
    return transitions.get(currentState).get(alphabet);
  }
}