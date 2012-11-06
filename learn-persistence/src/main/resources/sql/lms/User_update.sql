UPDATE LMSUser SET
    username = :e.name,
    preferredAudioLevel = :e.preferredAudioLevel,
    preferredLanguage = :e.preferredLanguage,
    preferredDeliverySpeed = :e.preferredDeliverySpeed,
    preferredAudioCaptioning = :e.preferredAudioCaptioning
WHERE id = :e.id