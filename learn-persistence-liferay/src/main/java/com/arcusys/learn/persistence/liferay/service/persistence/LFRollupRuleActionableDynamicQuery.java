package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFRollupRule;
import com.arcusys.learn.persistence.liferay.service.LFRollupRuleLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class LFRollupRuleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public LFRollupRuleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(LFRollupRuleLocalServiceUtil.getService());
        setClass(LFRollupRule.class);

        setClassLoader(com.arcusys.learn.persistence.liferay.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}
