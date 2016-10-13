package main.java;

import java.util.Set;

public class DFA {

  private final Set<String> states;
  private final Set<String> alphabets;
  private final String initialState;
  private final Set<String> finalState;
  private final Transition transition;

  DFA(Set<String> states, Set<String> alphabets, String initialState, Transition transition, Set<String> finalState) {
    this.states = states;
    this.alphabets = alphabets;
    this.initialState = initialState;
    this.finalState = finalState;
    this.transition = transition;
  }

  public Boolean isAccepted(String string) {
    String currentState = initialState;
    for (int i = 0; i < string.length(); i++) {
      String alphabet = String.valueOf(string.charAt(i));
      currentState = transition.nextState(currentState, alphabet);
    }
    return finalState.contains(currentState);
  }
}
