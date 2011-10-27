UPDATE Question SET
    categoryID = :e.categoryID,
    title = :e.title,
    description = :e.text,
<#if isBounded??>
    isBounded = :isBounded,
</#if>
<#if isCaseSensitive??>
    isCaseSensitive = :isCaseSensitive,
</#if>
    questionType = :questionType
WHERE id = :e.id