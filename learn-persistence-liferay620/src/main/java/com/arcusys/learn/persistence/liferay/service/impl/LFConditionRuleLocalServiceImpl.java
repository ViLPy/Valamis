package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFConditionRule;
import com.arcusys.learn.persistence.liferay.service.base.LFConditionRuleLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
/**
 * The implementation of the l f condition rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFConditionRuleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil
 */
public class LFConditionRuleLocalServiceImpl
    extends LFConditionRuleLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFConditionRuleLocalServiceUtil} to access the l f condition rule local service.
     */
    public LFConditionRule createLFConditionRule() throws SystemException {
        return createLFConditionRule(counterLocalService.increment(LFConditionRule.class.getName()));
    }

    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFConditionRule> findBySequencingIDAndRuleType(Integer sequencingID, String ruleType)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfConditionRulePersistence.findBySequencingIDAndRuleType(sequencingID, ruleType);
    }

    public void removeBySequencingID(Integer sequencingID)
            throws   com.liferay.portal.kernel.exception.SystemException {
        lfConditionRulePersistence.removeBySequencingID(sequencingID);
    }


    public void removeAll() throws SystemException {
        lfConditionRulePersistence.removeAll();
    }

    @Override
    public LFConditionRule getLFConditionRule(final long id) throws PortalException, SystemException {
        try {
            return super.getLFConditionRule(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
