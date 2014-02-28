package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap;
import com.arcusys.learn.persistence.liferay.model.LFRuleCondition;
import com.arcusys.learn.persistence.liferay.service.base.LFRuleConditionLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f rule condition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFRuleConditionLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil
 */
public class LFRuleConditionLocalServiceImpl
    extends LFRuleConditionLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFRuleConditionLocalServiceUtil} to access the l f rule condition local service.
     */
    public LFRuleCondition createLFRuleCondition() throws SystemException {
        return createLFRuleCondition(counterLocalService.increment(LFRuleCondition.class.getName()));
    }
    public java.util.List<LFRuleCondition> findByRollup(Integer ruleID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfRuleConditionPersistence.findByRollup(ruleID);
    }
    public java.util.List<LFRuleCondition> findByCondition(Integer ruleID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfRuleConditionPersistence.findByCondition(ruleID);
    }
    public void removeByRollup(Integer ruleID)
            throws  com.liferay.portal.kernel.exception.SystemException {
        lfRuleConditionPersistence.removeByRollup(ruleID);
    }
    public void removeByCondition(Integer ruleID)
            throws  com.liferay.portal.kernel.exception.SystemException {
        lfRuleConditionPersistence.removeByCondition(ruleID);
    }

    public void removeAll() throws SystemException {
        lfRuleConditionPersistence.removeAll();
    }

@Override
public LFRuleCondition getLFRuleCondition(final long id) throws PortalException, SystemException {
try { return super.getLFRuleCondition(id); } catch (NoSuchModelException e) { return null; } }
}
