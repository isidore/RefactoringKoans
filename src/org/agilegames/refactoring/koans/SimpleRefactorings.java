package org.agilegames.refactoring.koans;

import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

public class SimpleRefactorings extends TestCase
{
  private String   ___;
  private Sandwich sandwich = new Sandwich();
  /**
   * Keyboard shortcut: Rename = Alt + Shift + R
   * 
   * @throws Exception
   */
  public void testRenamingAField() throws Exception
  {
    REFACTOR_THIS(this.___);
    this.___ = "Have you tried turning it off and on?";
    Object object = getRefactoredField("myFancyField");
    assertEquals("Have you tried turning it off and on?", object);
  }
  public Object getRefactoredField(String refactoredName) throws IllegalAccessException, NoSuchFieldException
  {
    Object object = this.getClass().getDeclaredField(refactoredName).get(this);
    return object;
  }
  public void testExtractingMethods() throws Exception
  {
    String singer;
    if (REFACTOR_THIS(sandwich.includes("Peanut Butter") && sandwich.includes("Bananas")
        && sandwich.includes("Potato Chips") && 1337 == sandwich.getCalories()))
    {
      singer = "Elvis";
    }
    else
    {
      singer = "Rick Astley";
    }
    assertEquals("Elvis", singer);
    assertEquals(true, callRefactoredMethod("isSuitableForElvis"));
  }
  private <T> T REFACTOR_THIS(T in)
  {
    return in;
  }
  private Object callRefactoredMethod(String methodName) throws Exception, IllegalAccessException,
      InvocationTargetException, NoSuchMethodException
  {
    return this.getClass().getDeclaredMethod(methodName).invoke(this);
  }
}
