package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFConditionRule;
import com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFConditionRuleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFConditionRuleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFConditionRuleLocalServiceUtil.getService());
        setClass(LFConditionRule.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
