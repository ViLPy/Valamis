package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFSiteDependentConfigException;
import com.arcusys.learn.persistence.liferay.model.LFSiteDependentConfig;
import com.arcusys.learn.persistence.liferay.service.base.LFSiteDependentConfigLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f site dependent config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSiteDependentConfigLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalServiceUtil
 */
public class LFSiteDependentConfigLocalServiceImpl
    extends LFSiteDependentConfigLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFSiteDependentConfigLocalServiceUtil} to access the l f site dependent config local service.
     */

    public LFSiteDependentConfig createLFSiteDependentConfig() throws SystemException {
        return createLFSiteDependentConfig(counterLocalService.increment(LFSiteDependentConfig.class.getName()));
    }

    public java.util.List<LFSiteDependentConfig> findBySiteID(Integer siteID)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfSiteDependentConfigPersistence.findBySiteID(siteID);
    }

    public java.util.List<LFSiteDependentConfig> findByDataKey(String dataKey)
            throws com.liferay.portal.kernel.exception.SystemException {
        return lfSiteDependentConfigPersistence.findByDataKey(dataKey);
    }

    public LFSiteDependentConfig findBySiteIDAndDataKey(Integer siteID, String key)
            throws com.liferay.portal.kernel.exception.SystemException, NoSuchLFSiteDependentConfigException {
        return lfSiteDependentConfigPersistence.findBySiteIDAndDataKey(siteID, key);
    }

    public void removeAll() throws SystemException {
        lfSiteDependentConfigPersistence.removeAll();
    }
}
