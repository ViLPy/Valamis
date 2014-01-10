//package com.arcusys.learn.tincan.api.utils
//
//import org.junit.Test
//import org.junit.Assert._
//
//class PostOverrideSupportTest {
//
//  @Test
//  def parseTest() {
//    val raw = """Content%2DType=application%2Fjson&Authorization=Basic%20UU1GUE5TNzhTTDpEdXdQaW93aWh5S1hQM3h5cUl1cEM0bGFMRXl5SzNkSnVrcjZHSGJO&stateId=resume&registration=&actor=%7B%22name%22%3A%5B%22%22%5D%2C%22mbox%22%3A%5B%22mailto%3A%22%5D%7D&activityId=6X9uS05rLUb%5Fcourse%5Fid"""
//    val result = PostOverrideSupport.parseBody(raw, "utf8")
//
//    assertEquals("application/json", result("Content-Type"))
//    assertEquals("{\"name\":[\"\"],\"mbox\":[\"mailto:\"]}", result("actor"))
//    assertEquals("resume", result("stateId"))
//    assertEquals("6X9uS05rLUb_course_id", result("activityId"))
//    assertEquals("Basic UU1GUE5TNzhTTDpEdXdQaW93aWh5S1hQM3h5cUl1cEM0bGFMRXl5SzNkSnVrcjZHSGJO", result("Authorization"))
//  }
//
//  @Test
//  def parseWithContentTest() {
//    val raw = """Content%2DType=application%2Fjson&Authorization=Basic%20UU1GUE5TNzhTTDpEdXdQaW93aWh5S1hQM3h5cUl1cEM0bGFMRXl5SzNkSnVrcjZHSGJO&content=%7B%22verb%22%3A%22experienced%22%2C%22context%22%3A%7B%22contextActivities%22%3A%7B%22grouping%22%3A%7B%22id%22%3A%226X9uS05rLUb%5Fcourse%5Fid%22%7D%2C%22parent%22%3A%7B%22id%22%3A%226X9uS05rLUb%5Fcourse%5Fid%22%7D%7D%2C%22registration%22%3A%22%22%7D%2C%22object%22%3A%7B%22id%22%3A%225jIOVMY3lI7%22%7D%2C%22actor%22%3A%7B%22mbox%22%3A%5B%22mailto%3A%22%5D%2C%22name%22%3A%5B%22%22%5D%7D%7D&statementId=ce9c93d2%2D9a92%2D4181%2Da513%2Dd55f288072f5&registration="""
//    val result = PostOverrideSupport.parseBody(raw, "utf8")
//    println(result.get("content").get)
//  }
//}
