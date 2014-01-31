<#list finderColsList as finderCol>
	<#if finderCol.hasArrayableOperator()>
		if (${finderCol.names} != null) {
            for(${finderCol.type} ${finderCol.name}: ${finderCol.names}) {
                if(${finderCol.name} != null) {
			        qPos.add(${finderCol.name});
                }
            }
		}
	<#else>
    if (${finderCol.name} != null) {
		qPos.add(

		<#if finderCol.type == "Date">
			CalendarUtil.getTimestamp(
		</#if>

		${finderCol.name}${serviceBuilder.getPrimitiveObjValue("${finderCol.type}")}

		<#if finderCol.type == "Date">
			)
		</#if>

		);
    }
	</#if>
</#list>