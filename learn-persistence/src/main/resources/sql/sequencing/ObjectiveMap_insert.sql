INSERT INTO ObjectiveMapInfo(objectiveID, readSatisfiedStatusFrom, readNormalizedMeasureFrom, writeSatisfiedStatusTo,
  writeNormalizedMeasureTo, readRawScoreFrom, readMinScoreFrom, readMaxScoreFrom, readCompletionStatusFrom,
  readProgressMeasureFrom, writeRawScoreTo, writeMinScoreTo, writeMaxScoreTo, writeCompletionStatusTo, writeProgressMeasureTo)
VALUES (:objectiveID, :e.readSatisfiedStatusFrom, :e.readNormalizedMeasureFrom, :e.writeSatisfiedStatusTo,
  :e.writeNormalizedMeasureTo, :e.readRawScoreFrom, :e.readMinScoreFrom, :e.readMaxScoreFrom, :e.readCompletionStatusFrom,
  :e.readProgressMeasureFrom, :e.writeRawScoreTo, :e.writeMinScoreTo, :e.writeMaxScoreTo, :e.writeCompletionStatusTo, :e.writeProgressMeasureTo)