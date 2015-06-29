package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.model.LFSlideEntity;
import com.arcusys.learn.persistence.liferay.service.base.LFSlideEntityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the l f slide entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFSlideEntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFSlideEntityLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFSlideEntityLocalServiceUtil
 */
public class LFSlideEntityLocalServiceImpl
    extends LFSlideEntityLocalServiceBaseImpl {
    public LFSlideEntity createLFSlideEntity() throws SystemException {
        return super.createLFSlideEntity(counterLocalService.increment(LFSlideEntity.class.getName()));
    }
}
