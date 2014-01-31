<#if !finderCol.isPrimitiveType()>
	boolean bind${finderCol.methodName} = false;

	if (${finderCol.name} == null) {
		query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_1${finderFieldSuffix});
	}
	<#if finderCol.type == "String">
		else if (${finderCol.name}.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_3${finderFieldSuffix});
		}
	</#if>
	else {
		bind${finderCol.methodName} = true;
</#if>

<#if finderCol.type == "String">
	if (${finderCol.name}.equals(StringPool.BLANK)) {
		query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_3${finderFieldSuffix});
	}
	else {
		query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_2${finderFieldSuffix});
	}
<#else>
    if(${finderCol.name} == null) {
        query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_NULL_2${finderFieldSuffix});
    } else {
	    query.append(_FINDER_COLUMN_${finder.name?upper_case}_${finderCol.name?upper_case}_2${finderFieldSuffix});
    }
</#if>

<#if !finderCol.isPrimitiveType()>
	}
</#if>