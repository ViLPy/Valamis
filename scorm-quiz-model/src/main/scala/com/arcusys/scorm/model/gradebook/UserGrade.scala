package com.arcusys.scorm.model.gradebook

case class UserGrade(userID: String, 
                     courseID: String, 
                     categoryID: Int,
                     grade: Int)