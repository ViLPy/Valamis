package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRuleCondition;
import com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFRuleConditionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFRuleConditionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFRuleConditionLocalServiceUtil.getService());
        setClass(LFRuleCondition.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
