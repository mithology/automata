package main.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class DFATest {
  @Test
  public void shouldBeAbleToCreateADFA() throws Exception {
    Set<String> alphabets = new HashSet<String>(2);
    alphabets.add("0");
    alphabets.add("1");

    Set<String> states = new HashSet<String >(2);
    states.add("q1");
    states.add("q2");

    String initialState = "q1";

    Set<String> finalState = new HashSet<String >(1);
    finalState.add("q2");

    Transition transition = new Transition();
    transition.insert("q1", "0", "q1");
    transition.insert("q1", "1", "q2");
    transition.insert("q2", "0", "q1");
    transition.insert("q2", "1", "q2");

    DFA dfa = new DFA(states, alphabets, initialState, transition, finalState);
    Assert.assertEquals(true, dfa.isAccepted("01"));
    Assert.assertEquals(true, dfa.isAccepted("11"));
    Assert.assertEquals(true, dfa.isAccepted("1110001"));

    Assert.assertEquals(false, dfa.isAccepted("0110"));

  }

  @Test
  public void shouldCreateADFAThatContainsAnyNoOfOnes() throws Exception {
    Set<String> alphabets = new HashSet<String>();
    alphabets.add("0");
    alphabets.add("1");

    Set<String> states = new HashSet<String>();
    states.add("q1");
    states.add("q2");
    states.add("q3");

    String initialState = "q1";

    Set<String> finalState = new HashSet<String >();
    finalState.add("q3");

    Transition transition = new Transition();
    transition.insert("q1", "0", "q2");
    transition.insert("q1", "1", "q3");
    transition.insert("q2", "1", "q3");
    transition.insert("q2", "0", "q2");
    transition.insert("q3", "0", "q3");
    transition.insert("q3", "1", "q3");


    DFA dfa = new DFA(states, alphabets, initialState, transition, finalState);
    Assert.assertEquals(true, dfa.isAccepted("11"));
    Assert.assertEquals(false, dfa.isAccepted("0"));

  }
}