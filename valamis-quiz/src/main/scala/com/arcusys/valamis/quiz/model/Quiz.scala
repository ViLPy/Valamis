package com.arcusys.valamis.quiz.model

/**
 * A quiz, or test, to be passed by Learning Management System users.
 * To run a quiz against users, a SCORM package is created out of it and then played
 * @param id                  Unique internal ID of quiz
 * @param title               Short title of quiz
 * @param description         More detailed description of quiz
 * @param welcomePageContent  static content for first welcome page
 * @param finalPageContent    static content for last quiz page
 */
case class Quiz(
  id: Int,
  title: String,
  description: String,
  welcomePageContent: String,
  finalPageContent: String,
  courseID: Option[Int],
  logo: String,
  maxDuration: Option[Int])