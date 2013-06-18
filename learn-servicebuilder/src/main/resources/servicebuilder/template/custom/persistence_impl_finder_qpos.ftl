<#list finderColsList as finderCol>

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

</#list>