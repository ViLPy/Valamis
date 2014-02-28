package com.arcusys.learn.scorm.tracking.states.impl.liferay

import com.arcusys.learn.scorm.tracking.states.storage.impl.ActivityStateTreeStorageJUnit
import com.arcusys.learn.storage.impl.liferay.LFStorages

import org.junit.Ignore

class ActivityStateTreeStorageWithLFTest extends ActivityStateTreeStorageJUnit {
  def packagesStorage = LFStorages.packageStorage
  def activityStorage = LFStorages.activityStorage
  def userStorage = LFStorages.userStorage
  def attemptStorage = LFStorages.attemptStorage
  def treeStateStorage = LFStorages.activityStateTreeStorage
  def stateStorage = LFStorages.activityStateStorage
}
