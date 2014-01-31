package com.arcusys.learn.questionbank

import org.openqa.selenium._
import org.openqa.selenium.interactions.{HasInputDevices, Actions}
import internal.Locatable
import org.junit.Assert._
import com.arcusys.learn.base.{WebDriverArcusys, UITestBase}
import org.openqa.selenium.support.ui.Select
import org.scalatest.{FlatSpec, Suite}
import org.scalatest.matchers.ShouldMatchers

class QuestionTest (_driver:WebDriverArcusys) extends Suite with FlatSpec with ShouldMatchers with UITestBase {
  val driver = _driver

  "Question Editor" should "be able to create questions" in {
    // test 6.1, 6.2
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()

    setTitle("Test question")
    driver.getVisibleElementAfterWaitBy(By.id("questionbankUpdate")).click()

    driver.waitForElementVisibleBy(By.partialLinkText("Test question"))

    // 6.3
    driver.getVisibleElementAfterWaitBy(By.id("questionbankEdit")).click()
    setContent("Test question text")

    driver.getVisibleElementAfterWaitBy(By.id("SCORMEditExplanation")).click()
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('explanation');")
//    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'SCORMRichTextEdit')]/..//button[1]")).click()

    addAnswer("answer1", 1, true)
    addAnswer("answer2", 2, false)
    clickUpdate()

    val answers = driver.findElements(By.className("SCORMAnswer"))
    assertEquals(2, answers.size)

    val explanation = driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionExplanation")).findElement(By.className("SCORMResult"))
    assertEquals("explanation",  explanation.getText)

    val isBounded = driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionBounded"))
    assertEquals("true", isBounded.getAttribute("disabled"))

  }

  // test 6.4
  it should "be able to change question type" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Test question")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankEdit")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Short answer question")

    clickUpdate()

    val answers = driver.findElements(By.className("SCORMAnswer"))
    assertEquals(0, answers.size)

    val explanation = driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionExplanation")).findElement(By.className("SCORMResult"))
    assertEquals("explanation",  explanation.getText)

    driver.getVisibleElementAfterWaitBy(By.id("questionbankRemoveElement")).click()
    assertEquals("This will delete all included elements!", driver.getAlertTextAndCloseAfterWait)

    driver.waitForElementInvisibleBy(By.partialLinkText("Test question"))
    driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionBankTree")).findElements(By.tagName("li")).size should be(1)
  }

  // test 6.5
  it should "be able to create choise question" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    setTitle("choise")
    setContent("<p>Test choise question.</p><p>You should see comboboxes.</p><p>Correct answer - <b>A</b></p>")
    addAnswer("B", 1, false)
    addAnswer("A", 2, true)
    clickUpdate()

    assertTrue(driver.getVisibleElementAfterWaitBy(By.partialLinkText("choise")).isDisplayed)
  }

  // test 6.6
  it should "be able to create choise radio buttons question" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    setTitle("choise radio")
    setContent("<p>Test choise question.</p><p>You should see radio buttons and select only 1 correct answer.</p><p>Correct answer - <b>1</b></p>")

    driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionBounded")).click()

    addAnswer("3", 1, false)
    addAnswer("2", 2, false)
    addAnswer("1", 3, true)
    clickUpdate()

    assertTrue(driver.getVisibleElementAfterWaitBy(By.partialLinkText("choise radio")).isDisplayed)
  }

  // test 6.7
  it should "be able to create short answer question case sensitive" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Short answer question")
    setTitle("short case sensitive")
    driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionCaseSensitive")).click()
    addShortAnwser("CASE", 1)

    driver.getVisibleElementAfterWaitBy(By.id("SCORMEditText")).click()

    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('" +
      "<p>test content for short answer question. IMAGE should be there.</p><p>answer - CASE</p>" + "');")

    //=== need to be ignored for IE
    driver.getVisibleElementAfterWaitBy(By.cssSelector("span.mceIcon.mce_image")).click()

    val mainWindow = driver.getWindowHandle

    // switch to latest opened window
    driver.getWindowHandles().toArray.foreach(winHandle =>
      driver.switchTo().window(winHandle.toString)
    )

    driver.getVisibleElementAfterWaitBy(By.id("src")).clear()
    val url = "http://www.arcusys.fi/arcusys-6.1-theme/images/arcusys/ArcusysCorporateLogo.png"
    driver.getVisibleElementAfterWaitBy(By.id("src")).sendKeys(url)
    driver.getVisibleElementAfterWaitBy(By.id("insert")).click()

    driver.switchTo.window(mainWindow)
    //=== need to be ignored for IE

    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()
    clickUpdate()
    assertTrue(driver.isElementPresentBy(By.partialLinkText("short case sensitive")))
    val image = driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionContentDiv")).findElement(By.className("SCORMResult"))
      .findElement(By.xpath("//img"))
    assertNotNull(image)
  }

  // test 6.8
  it should "be able to create short answer question" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Short answer question")
    setTitle("short")

    addShortAnwser("a", 1)
    addShortAnwser("b", 2)

    setContent("short question. Answers = a or b")
    clickUpdate()
    assertTrue(driver.isElementPresentBy(By.partialLinkText("short")))
  }

  // test 6.9
  it should "be able to create numeric answer question" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Numeric question")
    setTitle("numeric")
    driver.getVisibleElementAfterWaitBy(By.id("SCORMButtonAddAnswer")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMAnswerRangeFrom")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMAnswerRangeFrom")).sendKeys("10")
    driver.getVisibleElementAfterWaitBy(By.id("SCORMAnswerRangeTo")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMAnswerRangeTo")).sendKeys("20")
    setContent("<p>This is numeric question.</p><p>Correct answer is between 10 and 20</p>")
    clickUpdate()
    assertTrue(driver.isElementPresentBy(By.partialLinkText("numeric")))
  }

  //6.10
  it should "be able to create positioning question" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Positioning question")
    setTitle("positioning question")
    setContent("<p>This is positioning question</p><p>You should order answers - 1 2 3</p>")

    addAnswer("1", 1, false)
    addAnswer("2", 2, false)
    addAnswer("3", 3, false)

    checkOrder("1", "2", "3")

    val editor = driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionAnswersEditors"))
    val answer1 = editor.findElement(By.xpath("(//div[@class='SCORMAnswer'])[1]"))
    new Actions(driver).clickAndHold(editor.findElement(By.xpath("(//div[@class='SCORMAnswer'])[2]"))).moveToElement(answer1).build().perform()
    new Actions(driver).moveByOffset(0, 0).build().perform()
    new Actions(driver).release().build().perform()

    checkOrder("2", "1", "3")

    val answer2 = editor.findElement(By.xpath("(//div[@class='SCORMAnswer'])[1]"))
    new Actions(driver).clickAndHold(editor.findElement(By.xpath("(//div[@class='SCORMAnswer'])[2]"))).moveToElement(answer2).build().perform()
    new Actions(driver).moveByOffset(0, 0).build().perform()
    new Actions(driver).release().build().perform()

    checkOrder("1", "2", "3")

    clickUpdate()
    assertTrue(driver.isElementPresentBy(By.partialLinkText("positioning question")))

  }

  //6.11
  it should "be able to create matching question" in {
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Matching question")
    setTitle("matching")
    addAnswer("Fruit", 1, false)
    driver.getVisibleElementAfterWaitBy(By.id("SCORMAnswerMatchingText")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMAnswerMatchingText")).sendKeys("apple")

    addAnswer("Vegetable", 2, false)
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@id='SCORMAnswerMatchingText'])[2]")).clear()
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@id='SCORMAnswerMatchingText'])[2]")).sendKeys("tomato")

    addAnswer("Machine", 3, false)
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@id='SCORMAnswerMatchingText'])[3]")).clear()
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@id='SCORMAnswerMatchingText'])[3]")).sendKeys("car")
    clickUpdate()
    assertTrue(driver.isElementPresentBy(By.partialLinkText("matching")))
  }

  //6.12
  it should "be able to create essay question" in {
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Essay question")
    setTitle("essay")
    setContent("Please describe what do you think about Learn")
    driver.waitForElementInvisibleBy(By.id("SCORMButtonAddAnswer"))
    driver.waitForElementInvisibleBy(By.id("SCORMAnswerIsCorrect"))
    driver.waitForElementInvisibleBy(By.id("SCORMAnswerMatchingText"))
    clickUpdate()
    assertTrue(driver.isElementPresentBy(By.partialLinkText("essay")))
  }

  //6.13
  it should "be able to create categorization question" in {
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddQuestions")).click()
    new Select(driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionType"))).selectByVisibleText("Categorization question")
    setTitle("categorization")
    setContent("<p>This is categorization question.</p></p>You should move answers to appropriate categories.</p>")

    addAnswer("<p>Those all are < 10</p><p>!</p>", 1, false)
    addOption("<p>7</p><p>1</p>", 1, 1)
    addOption("3", 1, 2)
    addOption("5", 1, 3)

    addAnswer("<p>Those all are > 20</p><p>!</p>", 2, false)
    addOption("<p>24</p><p>35</p>", 2, 4)
    addOption("40", 2, 5)
    addAnswer("<p>Empty</p>", 3, false)
    clickUpdate()
    assertTrue(driver.isElementPresentBy(By.partialLinkText("categorization")))
  }

  //6.14
  it should "be able to move questions to category" in{
    driver.get(baseUrl + questionUrl)
    driver.getVisibleElementAfterWaitBy(By.partialLinkText("Question base")).click()
    driver.getVisibleElementAfterWaitBy(By.id("questionbankAddCategory")).click()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMCategoryNameEdit")).sendKeys("category1")
    driver.getVisibleElementAfterWaitBy(By.id("questionbankUpdateBottom")).click()

    dragAndDrop("choise")
    dragAndDrop("choise radio")

    //val insideCategory = driver.findElement(By.xpath("//*[@id=\"SCORMQuestionBankTree\"]/ul/li/ul/li/ul")).findElements(By.className("jstree-leaf"))
    //assertEquals(2, insideCategory.toArray.length)
  }

  private def dragAndDrop(source: String){
    val sourceLocation = driver.getVisibleElementAfterWaitBy(By.partialLinkText(source))
    val targetLocation = driver.getVisibleElementAfterWaitBy(By.partialLinkText("category1"))
    new Actions(driver).dragAndDrop(sourceLocation, targetLocation).build().perform()
  }

  private def clickUpdate(){
    driver.getVisibleElementAfterWaitBy(By.id("questionbankUpdateBottom")).click()
  }

  private def setTitle(title: String){
    driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionTitleEdit")).clear()
    driver.getVisibleElementAfterWaitBy(By.id("SCORMQuestionTitleEdit")).sendKeys(title)
  }

  private def setContent(content: String){
    driver.getVisibleElementAfterWaitBy(By.id("SCORMEditText")).click()
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('" + content + "');")
    driver.waitForElementInvisibleBy(By.xpath("//*[contains(text(), 'Complete')]"))
//    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'SCORMRichTextEdit')]/..//button[1]")).click()
    clickSave()
  }

  private def addAnswer(answer: String, index: Int, isCorrect: Boolean){
    driver.getVisibleElementAfterWaitBy(By.id("SCORMButtonAddAnswer")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("(//button[@id='buttonSCORMEditText'])["+ index +"]")).click()
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+ answer +"');")
//    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()
    clickSave()
    if (isCorrect)
      driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@id='SCORMAnswerIsCorrect'])["+ index +"]")).click()
  }
  private def addShortAnwser(answer: String, index: Int){
    driver.getVisibleElementAfterWaitBy(By.id("SCORMButtonAddAnswer")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@id='SCORMAnswerText'])["+index+"]")).clear()
    driver.getVisibleElementAfterWaitBy(By.xpath("(//input[@id='SCORMAnswerText'])["+index+"]")).sendKeys(answer)
  }
  private def addOption(answer: String, answerIndex: Int, optionIndex: Int){
    driver.getVisibleElementAfterWaitBy(By.xpath("(//button[@id='SCORMButtonAddOption'])["+answerIndex+"]")).click()
    driver.getVisibleElementAfterWaitBy(By.xpath("(//button[@id='buttonSCORMEditOptionText'])["+optionIndex+"]")).click()
    (driver.asInstanceOf[JavascriptExecutor]).executeScript("tinyMCE.activeEditor.setContent('"+ answer +"');")
//    driver.getVisibleElementAfterWaitBy(By.xpath("//button[@type='button']")).click()
    clickSave()
  }
  private def clickSave() {
    driver.getVisibleElementAfterWaitBy(By.xpath("//*[contains(@id, 'SCORMRichTextEdit')]/..//button[1]")).click()
  }

  private def checkOrder(answ1: String, answ2: String, answ3: String){
    assertEquals(driver.getVisibleElementAfterWaitBy(By.xpath("id('SCORMQuestionAnswersEditors')/div[1]/div/div[2]/div/p")).getText, answ1)
    assertEquals(driver.getVisibleElementAfterWaitBy(By.xpath("id('SCORMQuestionAnswersEditors')/div[2]/div/div[2]/div/p")).getText, answ2)
    assertEquals(driver.getVisibleElementAfterWaitBy(By.xpath("id('SCORMQuestionAnswersEditors')/div[3]/div/div[2]/div/p")).getText, answ3)
  }
}
