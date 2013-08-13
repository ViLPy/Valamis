package com.arcusys.learn.questionbank

import org.openqa.selenium._
import interactions.Actions
import internal.Locatable
import org.junit.Assert._
import com.arcusys.learn.base.UITestBase
import org.openqa.selenium.support.ui.Select
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers
import org.openqa.selenium.interactions.internal.Coordinates

class QuestionTest (_driver:WebDriver) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Question Editor" should "be able to create questions" in {
    // test 6.1, 6.2
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.id("questionbankAddQuestions")).click()

    setTitle("Test question")
    driver.findElement(By.id("questionbankUpdate")).click()

    val element = driver.findElement(By.partialLinkText("Test question"))
    assertNotNull(element)
    assertTrue(element.isDisplayed)

    // 6.3
    driver.findElement(By.id("questionbankEdit")).click()
    setContent("Test question text")

    driver.findElement(By.id("SCORMEditExplanation")).click()
    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('explanation');")
    driver.findElement(By.xpath("//button[@type='button']")).click()

    addAnswer("answer1", 1, true)
    addAnswer("answer2", 2, false)
    clickUpdate()

    val answers = driver.findElements(By.className("SCORMAnswer"))
    assertEquals(2, answers.size)

    val explanation = driver.findElement(By.id("SCORMQuestionExplanation")).findElement(By.className("SCORMResult"))
    assertEquals("explanation",  explanation.getText)

    val isBounded = driver.findElement(By.id("SCORMQuestionBounded"))
    assertEquals("true", isBounded.getAttribute("disabled"))

  }

  // test 6.4
  it should "be able to change question type" in{
    driver.get(baseUrl + questionUrl)
    wait(1)
    driver.findElement(By.partialLinkText("Test question")).click()
    driver.findElement(By.id("questionbankEdit")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Short answer question")

    clickUpdate()

    val answers = driver.findElements(By.className("SCORMAnswer"))
    assertEquals(0, answers.size)

    val explanation = driver.findElement(By.id("SCORMQuestionExplanation")).findElement(By.className("SCORMResult"))
    assertEquals("explanation",  explanation.getText)

    driver.findElement(By.id("questionbankRemoveElement")).click()
    assertEquals("This will delete all included elements!", closeAlertAndGetItsText)

    assertFalse(isElementPresent(By.partialLinkText("Test question")))
  }

  // test 6.5
  it should "be able to create choise question" in{
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    setTitle("choise")
    setContent("<p>Test choise question.</p><p>You should see comboboxes.</p><p>Correct answer - <b>A</b></p>")
    addAnswer("B", 1, false)
    addAnswer("A", 2, true)
    clickUpdate()

    assertTrue(driver.findElement(By.partialLinkText("choise")).isDisplayed)
  }

  // test 6.6
  it should "be able to create choise radio buttons question" in{
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    setTitle("choise radio")
    setContent("<p>Test choise question.</p><p>You should see radio buttons and select only 1 correct answer.</p><p>Correct answer - <b>1</b></p>")

    driver.findElement(By.id("SCORMQuestionBounded")).click()

    addAnswer("3", 1, false)
    addAnswer("2", 2, false)
    addAnswer("1", 3, true)
    clickUpdate()

    assertTrue(driver.findElement(By.partialLinkText("choise radio")).isDisplayed)
  }

  // test 6.7
  it should "be able to create short answer question case sensitive" in{
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Short answer question")
    setTitle("short case sensitive")
    driver.findElement(By.id("SCORMQuestionCaseSensitive")).click()
    addShortAnwser("CASE", 1)

    driver.findElement(By.id("SCORMEditText")).click()

    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('" +
      "<p>test content for short answer question. IMAGE should be there.</p><p>answer - CASE</p>" + "');")

    driver.findElement(By.cssSelector("span.mceIcon.mce_image")).click()

    val mainWindow = driver.getWindowHandle

    // switch to latest opened window
    driver.getWindowHandles().toArray.foreach(winHandle =>
      driver.switchTo().window(winHandle.toString)
    )

    driver.findElement(By.id("src")).clear()
    val url = "http://www.arcusys.fi/arcusys-6.1-theme/images/arcusys/ArcusysCorporateLogo.png"
    driver.findElement(By.id("src")).sendKeys(url)
    driver.findElement(By.id("insert")).click()

    driver.switchTo.window(mainWindow)

    driver.findElement(By.xpath("//button[@type='button']")).click()
    clickUpdate()
    assertTrue(isElementPresent(By.partialLinkText("short case sensitive")))
    val image = driver.findElement(By.id("SCORMQuestionContentDiv")).findElement(By.className("SCORMResult"))
      .findElement(By.xpath("//img"))
    assertNotNull(image)
  }

  // test 6.8
  it should "be able to create short answer question" in{
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Short answer question")
    setTitle("short")

    addShortAnwser("a", 1)
    addShortAnwser("b", 2)

    setContent("short question. Answers = a or b")
    clickUpdate()
    assertTrue(isElementPresent(By.partialLinkText("short")))
  }

  // test 6.9
  it should "be able to create numeric answer question" in{
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Numeric question")
    setTitle("numeric")
    driver.findElement(By.id("SCORMButtonAddAnswer")).click()
    driver.findElement(By.id("SCORMAnswerRangeFrom")).clear()
    driver.findElement(By.id("SCORMAnswerRangeFrom")).sendKeys("10")
    driver.findElement(By.id("SCORMAnswerRangeTo")).clear()
    driver.findElement(By.id("SCORMAnswerRangeTo")).sendKeys("20")
    setContent("<p>This is numeric question.</p><p>Correct answer is between 10 and 20</p>")
    clickUpdate()
    assertTrue(isElementPresent(By.partialLinkText("numeric")))
  }

  //6.10
  it should "be able to create positioning question" in{
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Positioning question")
    setTitle("positioning question")
    setContent("<p>This is positioning question</p><p>You should order answers - 1 2 3</p>")

    addAnswer("1", 1, false)
    addAnswer("2", 2, false)
    addAnswer("3", 3, false)

    wait(2)
    val editor = driver.findElement(By.id("SCORMQuestionAnswersEditors"))
    new Actions(driver).clickAndHold(editor.findElement(By.xpath("(//div[@class='SCORMAnswer'])[2]"))).moveByOffset(1,-5).build().perform()
    wait(2)
    new Actions(driver).moveByOffset(0, -250).build().perform()
    wait(2)
    val hoverItem = editor.findElement(By.xpath("(//div[@class='SCORMAnswer'])[1]")).asInstanceOf[Locatable]
    val mouse = (driver.asInstanceOf[HasInputDevices]).getMouse
    mouse.mouseMove(hoverItem.getCoordinates)
    wait(1)
    new Actions(driver).release().build().perform()
    //new Actions(driver).dragAndDropBy(editor.findElement(By.xpath("(//div[@class='SCORMAnswer'])[2]")), 0, -95).build().perform()
    wait(5)
    clickUpdate()
    assertTrue(isElementPresent(By.partialLinkText("positioning question")))
  }

  //6.11
  it should "be able to create matching question" in {
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Matching question")
    setTitle("matching")
    addAnswer("Fruit", 1, false)
    driver.findElement(By.id("SCORMAnswerMatchingText")).clear()
    driver.findElement(By.id("SCORMAnswerMatchingText")).sendKeys("apple")

    addAnswer("Vegetable", 2, false)
    driver.findElement(By.xpath("(//input[@id='SCORMAnswerMatchingText'])[2]")).clear()
    driver.findElement(By.xpath("(//input[@id='SCORMAnswerMatchingText'])[2]")).sendKeys("tomato")
    clickUpdate()
    assertTrue(isElementPresent(By.partialLinkText("matching")))
  }

  //6.12
  it should "be able to create essay question" in {
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Essay question")
    setTitle("essay")
    setContent("Please describe what do you think about Learn")
    assertFalse(driver.findElement(By.id("SCORMButtonAddAnswer")).isDisplayed)
    assertFalse(isElementPresent(By.id("SCORMAnswerIsCorrect")))
    assertFalse(isElementPresent(By.id("SCORMAnswerMatchingText")))
    clickUpdate()
    assertTrue(isElementPresent(By.partialLinkText("essay")))
  }

  //6.13
  it should "be able to create categorization question" in {
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddQuestions")).click()
    new Select(driver.findElement(By.id("SCORMQuestionType"))).selectByVisibleText("Categorization question")
    setTitle("categorization")
    setContent("<p>This is categorization question.</p></p>You should move answers to appropriate categories.</p>")

    addAnswer("<p>Those all are < 10</p><p>!</p>", 1, false)
    addOption("<p>7</p><p>1</p>", 1, 1)
    addOption("3", 1, 2)
    addOption("5", 1, 3)

    addAnswer("<p>Those all are > 20</p><p>!</p>", 2, false)
    addOption("<p>24</p><p>35</p>", 2, 4)
    addOption("40", 2, 5)
    clickUpdate()
    assertTrue(isElementPresent(By.partialLinkText("categorization")))
  }

  //6.14
  it should "be able to move questions to category" in{
    driver.get(baseUrl + questionUrl)
    driver.findElement(By.partialLinkText("Question base")).click()
    driver.findElement(By.id("questionbankAddCategory")).click()
    driver.findElement(By.id("SCORMCategoryNameEdit")).clear()
    driver.findElement(By.id("SCORMCategoryNameEdit")).sendKeys("category1")
    driver.findElement(By.id("questionbankUpdateBottom")).click()

    dragAndDrop("choise")
    wait(1)
    dragAndDrop("choise radio")
    wait(1)

    val insideCategory = driver.findElement(By.xpath("//*[@id=\"SCORMQuestionBankTree\"]/ul/li/ul/li/ul")).findElements(By.className("jstree-leaf"))
    assertEquals(2, insideCategory.toArray.length)
  }

  private def dragAndDrop(source: String){
    val sourceLocation = driver.findElement(By.partialLinkText(source))
    val targetLocation = driver.findElement(By.partialLinkText("category1"))
    new Actions(driver).dragAndDrop(sourceLocation, targetLocation).build().perform()
  }

  private def clickUpdate(){
    driver.findElement(By.id("questionbankUpdateBottom")).click()
  }

  private def setTitle(title: String){
    driver.findElement(By.id("SCORMQuestionTitleEdit")).clear()
    driver.findElement(By.id("SCORMQuestionTitleEdit")).sendKeys(title)
  }

  private def setContent(content: String){
    driver.findElement(By.id("SCORMEditText")).click()
    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('" + content + "');")
    driver.findElement(By.xpath("//button[@type='button']")).click()
  }

  private def addAnswer(answer: String, index: Int, isCorrect: Boolean){
    driver.findElement(By.id("SCORMButtonAddAnswer")).click()
    driver.findElement(By.xpath("(//button[@id='buttonSCORMEditText'])["+ index +"]")).click()
    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+ answer +"');")
    driver.findElement(By.xpath("//button[@type='button']")).click()
    if (isCorrect)
      driver.findElement(By.xpath("(//input[@id='SCORMAnswerIsCorrect'])["+ index +"]")).click()
  }
  private def addShortAnwser(answer: String, index: Int){
    driver.findElement(By.id("SCORMButtonAddAnswer")).click()
    driver.findElement(By.xpath("(//input[@id='SCORMAnswerText'])["+index+"]")).clear()
    driver.findElement(By.xpath("(//input[@id='SCORMAnswerText'])["+index+"]")).sendKeys(answer)
  }
  private def addOption(answer: String, answerIndex: Int, optionIndex: Int){
    driver.findElement(By.xpath("(//button[@id='SCORMButtonAddOption'])["+answerIndex+"]")).click()
    driver.findElement(By.xpath("(//button[@id='buttonSCORMEditOptionText'])["+optionIndex+"]")).click()
    wait(1)
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+ answer +"');")
    driver.findElement(By.xpath("//button[@type='button']")).click()
  }

}
