package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFSlideSet;
import com.arcusys.learn.persistence.liferay.service.base.LFSlideSetLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f slide set local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSlideSetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSlideSetLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSlideSetLocalServiceUtil
 */
public class LFSlideSetLocalServiceImpl extends LFSlideSetLocalServiceBaseImpl {
    public LFSlideSet createLFSlideSet() throws SystemException {
        return super.createLFSlideSet(counterLocalService.increment(LFSlideSet.class.getName()));
    }

    public java.util.List<LFSlideSet> findByCourseId(Long id) throws SystemException {
        return super.lfSlideSetPersistence.findByCourseId(id);
    }
}
