package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFConfig;
import com.arcusys.learn.persistence.liferay.service.base.LFConfigLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;

/**
 * The implementation of the l f config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFConfigLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil
 */
public class LFConfigLocalServiceImpl extends LFConfigLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFConfigLocalServiceUtil} to access the l f config local service.
     */
    public LFConfig createLFConfig() throws SystemException {
        return createLFConfig(counterLocalService.increment(LFConfig.class.getName()));
    }

    public LFConfig findByKey(String key)
            throws com.liferay.portal.kernel.exception.SystemException{
        java.util.List<LFConfig> list = lfConfigPersistence.findByDataKey(key, -1, -1);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public void removeAll() throws SystemException {
        lfConfigPersistence.removeAll();
    }
}
