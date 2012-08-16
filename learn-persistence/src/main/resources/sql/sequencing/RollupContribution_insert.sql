INSERT INTO RollupContribution(sequencingID, contributeToSatisfied, contributeToNotSatisfied,
  contributeToCompleted, contributeToIncomplete,
  objectiveMeasureWeight, measureSatisfactionIfActive)
VALUES (:sequencingID, :satisfaction.contributeToSatisfied.toString, :satisfaction.contributeToNotSatisfied.toString,
  :completion.contributeToCompleted.toString, :completion.contributeToIncomplete.toString,
  :e.objectiveMeasureWeight.bigDecimal, :e.measureSatisfactionIfActive)