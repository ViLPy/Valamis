package com.arcusys.learn.questionbank.model

/**
 * A key-value pair for a Matching question
 * @param id            Unique internal ID of option
 * @param text          Value text
 * @param keyText  Key text for the key this option should match, or None if this value should not match any key and is rendered for distraction only
 */
class MatchingAnswer(id: Int, val text: String, val keyText: Option[String]) extends Answer(id)