package main.java;

import org.junit.Assert;
import org.junit.Test;

public class TransitionTest {
  @Test
  public void ShouldProvideNextStep() throws Exception {
    Transition transition = new Transition();
    transition.insert("q1", "0", "q1");
    transition.insert("q1", "1", "q2");
    transition.insert("q2", "0", "q1");
    transition.insert("q2", "1", "q2");

    Assert.assertEquals("q1",transition.nextState("q1","0"));
    Assert.assertEquals("q2",transition.nextState("q1","1"));
    Assert.assertEquals("q1",transition.nextState("q2","0"));
    Assert.assertEquals("q2",transition.nextState("q2","1"));
  }
}