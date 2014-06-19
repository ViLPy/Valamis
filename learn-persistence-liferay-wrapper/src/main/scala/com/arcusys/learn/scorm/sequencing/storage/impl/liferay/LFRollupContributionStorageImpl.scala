package com.arcusys.learn.scorm.sequencing.storage.impl.liferay

import com.arcusys.learn.scorm.manifest.model.{ RollupConsiderationType, CompletionRollupContribution, SatisfactionRollupContribution, RollupContribution }
import com.arcusys.learn.storage.impl.EntityStorage
import com.arcusys.learn.storage.impl.liferay.LiferayCommon
import com.arcusys.learn.persistence.liferay.service.LFRollupContributionLocalServiceUtil

/**
 * User: Yulia.Glushonkova
 * Date: 02.04.13
 */
trait LFRollupContributionStorageImpl extends EntityStorage[RollupContribution] {
  protected def doRenew() { LFRollupContributionLocalServiceUtil.removeAll() }

  def getOne(parameters: (String, Any)*) = {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val lfEntity = LFRollupContributionLocalServiceUtil.findBySequencingID(sequencingID.get)
    if (lfEntity == null) None
    else {
      val contributeToSatisfied = lfEntity.getContributeToSatisfied
      val contributeToNotSatisfied = lfEntity.getContributeToNotSatisfied
      val contributeToCompleted = lfEntity.getContributeToCompleted
      val contributeToIncomplete = lfEntity.getContributeToIncomplete

      val satisfaction = if (contributeToSatisfied != null && contributeToNotSatisfied != null) {
        Some(new SatisfactionRollupContribution(RollupConsiderationType.withName(contributeToSatisfied), RollupConsiderationType.withName(contributeToNotSatisfied)))
      } else None

      val completion = if (contributeToCompleted != null && contributeToIncomplete != null) {
        Some(new CompletionRollupContribution(RollupConsiderationType.withName(contributeToCompleted), RollupConsiderationType.withName(contributeToIncomplete)))
      } else None

      Option(new RollupContribution(satisfaction, completion, BigDecimal(lfEntity.getObjectiveMeasureWeight), lfEntity.getMeasureSatisfactionIfActive))
    }
  }
  def getAll(parameters: (String, Any)*) = throw new UnsupportedOperationException("Not implemented")
  def create(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def create(entity: RollupContribution, parameters: (String, Any)*) {
    import com.arcusys.learn.storage.impl.liferay.LiferayCommon._

    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    val lfEntity = LFRollupContributionLocalServiceUtil.createLFRollupContribution()
    lfEntity.setSequencingID(sequencingID.get)

    val satisfactionParam = parameters find { _._1 == "satisfaction" } map (_._2)
    val satisfaction = satisfactionParam.get.asInstanceOf[Option[SatisfactionRollupContribution]]
    if (satisfaction.isDefined) {
      lfEntity.setContributeToSatisfied(satisfaction.get.contributeToSatisfied.toString)
      lfEntity.setContributeToNotSatisfied(satisfaction.get.contributeToNotSatisfied.toString)
    }
    val completionParam = parameters find { _._1 == "completion" } map (_._2)
    val completion = completionParam.get.asInstanceOf[Option[CompletionRollupContribution]]
    if (completion.isDefined) {
      lfEntity.setContributeToCompleted(completion.get.contributeToCompleted.toString)
      lfEntity.setContributeToIncomplete(completion.get.contributeToIncomplete.toString)
    }
    lfEntity.setObjectiveMeasureWeight(entity.objectiveMeasureWeight)
    lfEntity.setMeasureSatisfactionIfActive(entity.measureSatisfactionIfActive)
    LFRollupContributionLocalServiceUtil.addLFRollupContribution(lfEntity)
  }
  def delete(parameters: (String, Any)*) {
    val sequencingID = LiferayCommon.getParameter("sequencingID", parameters: _*)
    LFRollupContributionLocalServiceUtil.removeBySequencingID(sequencingID.get)
  }
  def modify(parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }
  def modify(entity: RollupContribution, parameters: (String, Any)*) { throw new UnsupportedOperationException("Not implemented") }

  def execute(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }

  def getAll(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def getOne(sqlKey: String, parameters: (String, Any)*) = throw new UnsupportedOperationException

  def modify(sqlKey: String, parameters: (String, Any)*) {
    throw new UnsupportedOperationException
  }
}
