package com.arcusys.scorm.model.parsers
import com.arcusys.scorm.model._
import scala.collection.immutable.IndexedSeq
import scala.xml.Elem
import XMLImplicits._

class SequencingRuleParser(sequencingRuleElement: Elem) {
  def parseSequencingRule = {
    val ruleConditionsElement = sequencingRuleElement \! ("imsss","ruleConditions")
    val conditionCombination = (ruleConditionsElement %? "conditionCombination").getOrElse("all")
    val ruleConditionElements = ruleConditionsElement \!! ("imsss","ruleCondition")
    val ruleActionElement = sequencingRuleElement \! ("imsss","ruleAction")
    (IndexedSeq[SequencingRuleCondition]()++(for (element <- ruleConditionElements) yield new SequencingRuleConditionParser(element.asInstanceOf[Elem]).parse),
      TokenParser.parseConditionCombination(conditionCombination),
      ruleActionElement %! "action")
  }

  def parsePreConditionRule = {
    val (conditions, conditionCombination, action) = parseSequencingRule
    new PreConditionRule(conditionCombination, conditions, TokenParser.parsePreConditionAction(action))    
  }

  def parsePostConditionRule = {
    val (conditions, conditionCombination, action) = parseSequencingRule
    new PostConditionRule(conditionCombination, conditions, TokenParser.parsePostConditionAction(action))  
  }

  def parseExitConditionRule = {
    val (conditions, conditionCombination, action) = parseSequencingRule
    TokenParser.parseExitConditionAction(action)
    new ExitConditionRule(conditionCombination, conditions)    
  }
}