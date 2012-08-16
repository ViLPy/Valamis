package com.arcusys.learn.quiz.model

/**
 * A quiz, or test, to be passed by Learning Management System users.
 * To run a quiz against users, a SCORM package is created out of it and then played
 * @param id                  Unique internal ID of quiz
 * @param title               Short title of quiz
 * @param description         More detailed description of quiz
 * @param welcomePageContent  static content for first welcome page
 * @param finalPageContent    static content for last quiz page
 */
class Quiz(val id: Int, val title: String, val description: String, val welcomePageContent: String, val finalPageContent: String)