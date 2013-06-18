package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFPackageScopeRule;
import com.arcusys.learn.persistence.liferay.service.base.LFPackageScopeRuleLocalServiceBaseImpl;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f package scope rule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFPackageScopeRuleLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil
 */
public class LFPackageScopeRuleLocalServiceImpl
    extends LFPackageScopeRuleLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFPackageScopeRuleLocalServiceUtil} to access the l f package scope rule local service.
     */
    public LFPackageScopeRule createLFPackageScopeRule() throws SystemException {
        return createLFPackageScopeRule(counterLocalService.increment(LFPackageScopeRule.class.getName()));
    }

    public LFPackageScopeRule findByPackageID(Integer packageID) throws
            com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException{
        return lfPackageScopeRulePersistence.findByPackageID(packageID);
    }

    public LFPackageScopeRule findByScopeAndIsDefault(String scope, String scopeID, Boolean isDefault) throws
            com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException, SystemException{
        return lfPackageScopeRulePersistence.findByScopeAndIsDefault(scope, scopeID, isDefault);
    }

    public java.util.List<LFPackageScopeRule> findByScope(String scope, String scopeID) throws
            com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException, SystemException{
        return lfPackageScopeRulePersistence.findByScope(scope, scopeID);
    }

    public LFPackageScopeRule findByPackageIDAndScope(Integer packageID, String scope, String scopeID) throws
            com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException, SystemException{
        return lfPackageScopeRulePersistence.findByPackageIDAndScope(packageID,  scope, scopeID);
    }
    public LFPackageScopeRule fetchByPackageIDAndScope(Integer packageID, String scope, String scopeID) throws
            com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException, SystemException{
        return lfPackageScopeRulePersistence.fetchByPackageIDAndScope(packageID,  scope, scopeID);
    }

    public java.util.List<LFPackageScopeRule> findByAllByPackageIDAndScope(Integer packageID, String scope, String scopeID) throws  SystemException{
        return lfPackageScopeRulePersistence.findByAllByPackageIDAndScope(packageID, scope, scopeID);
    }

    public java.util.List<LFPackageScopeRule> findByVisibility(String scope, String scopeID, Boolean visibility) throws  SystemException{
        return lfPackageScopeRulePersistence.findByVisibility(scope, scopeID, visibility);
    }

    public LFPackageScopeRule removeByPackageID(Integer packageID) throws
            com.arcusys.learn.persistence.liferay.NoSuchLFPackageScopeRuleException,
            com.liferay.portal.kernel.exception.SystemException{
        return lfPackageScopeRulePersistence.removeByPackageID(packageID);
    }


    public void removeAll() throws SystemException {
        lfPackageScopeRulePersistence.removeAll();
    }

    @Override
    public LFPackageScopeRule getLFPackageScopeRule(final long id) throws PortalException, SystemException {
        try {
            return super.getLFPackageScopeRule(id);
        } catch (NoSuchModelException e) {
            return null;
        }
    }
}
