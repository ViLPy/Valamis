package com.arcusys.learn.facades.tincan

import java.io.PrintWriter

/**
 * Created by ematyukhin on 09/10/14.
 */
trait TincanTestFacadeContract {
  def runTests(writer: PrintWriter): Unit
}
