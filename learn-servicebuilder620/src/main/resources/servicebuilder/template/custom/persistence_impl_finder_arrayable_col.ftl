<#if !finderCol.isPrimitiveType()>
	if (${finderCol.name} == null) {
		query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_4${finderFieldSuffix});
	}
	else {
</#if>

<#if finderCol.type == "String">
	if (${finderCol.name}.equals(StringPool.BLANK)) {
		query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_6${finderFieldSuffix});
	}
	else {
        query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_5${finderFieldSuffix});
	}
<#else>
    if (${finderCol.name} == null) {
    query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_NULL${finderFieldSuffix});
    } else {
    query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_5${finderFieldSuffix});
    }
</#if>

<#if !finderCol.isPrimitiveType()>
	}
</#if>