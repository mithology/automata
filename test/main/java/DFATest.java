package main.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DFATest {
  @Test
  public void shouldBeAbleToCreateADFA() throws Exception {
    Set<String> alphabets = new HashSet<>(2);
    alphabets.add("0");
    alphabets.add("1");

    Set<String> states = new HashSet<>(2);
    states.add("q1");
    states.add("q2");

    String initialState = "q1";

    Set<String> finalState = new HashSet<>(1);
    finalState.add("q2");

    Transition transition = new Transition();
    transition.insert("q1", "0", "q1");
    transition.insert("q1", "1", "q2");
    transition.insert("q2", "0", "q1");
    transition.insert("q2", "1", "q2");

    DFA dfa = new DFA(states, alphabets, initialState, transition, finalState);
    Assert.assertEquals(true, dfa.isAccepted("01001"));
    Assert.assertEquals(false, dfa.isAccepted("00110"));

  }
}