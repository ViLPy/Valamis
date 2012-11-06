UPDATE Quiz SET
    title = :e.title,
    description = :e.description,
    welcomePageContent = :e.welcomePageContent,
    finalPageContent = :e.finalPageContent
WHERE id = :e.id