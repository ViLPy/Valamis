package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f objective local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFObjectiveLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFObjectiveLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFObjectiveLocalServiceImpl
 * @generated
 */
public class LFObjectiveLocalServiceUtil {
    private static LFObjectiveLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFObjectiveLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f objective to the database. Also notifies the appropriate model listeners.
    *
    * @param lfObjective the l f objective
    * @return the l f objective that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective addLFObjective(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFObjective(lfObjective);
    }

    /**
    * Creates a new l f objective with the primary key. Does not add the l f objective to the database.
    *
    * @param lfId the primary key for the new l f objective
    * @return the new l f objective
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective createLFObjective(
        long lfId) {
        return getService().createLFObjective(lfId);
    }

    /**
    * Deletes the l f objective with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective that was removed
    * @throws PortalException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective deleteLFObjective(
        long lfId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFObjective(lfId);
    }

    /**
    * Deletes the l f objective from the database. Also notifies the appropriate model listeners.
    *
    * @param lfObjective the l f objective
    * @return the l f objective that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective deleteLFObjective(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFObjective(lfObjective);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFObjective fetchLFObjective(
        long lfId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFObjective(lfId);
    }

    /**
    * Returns the l f objective with the primary key.
    *
    * @param lfId the primary key of the l f objective
    * @return the l f objective
    * @throws PortalException if a l f objective with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective getLFObjective(
        long lfId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFObjective(lfId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f objectives.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f objectives
    * @param end the upper bound of the range of l f objectives (not inclusive)
    * @return the range of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> getLFObjectives(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFObjectives(start, end);
    }

    /**
    * Returns the number of l f objectives.
    *
    * @return the number of l f objectives
    * @throws SystemException if a system exception occurred
    */
    public static int getLFObjectivesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFObjectivesCount();
    }

    /**
    * Updates the l f objective in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfObjective the l f objective
    * @return the l f objective that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective updateLFObjective(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFObjective(lfObjective);
    }

    /**
    * Updates the l f objective in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfObjective the l f objective
    * @param merge whether to merge the l f objective with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f objective that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFObjective updateLFObjective(
        com.arcusys.learn.persistence.liferay.model.LFObjective lfObjective,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFObjective(lfObjective, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFObjective createLFObjective()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFObjective();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimary(
        java.lang.Integer sequencingID, boolean isPrimary)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findBySequencingIDAndIsPrimary(sequencingID, isPrimary);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjective> findBySequencingIDAndIsPrimaryAndIdentifier(
        java.lang.Integer sequencingID, boolean isPrimary,
        java.lang.String identifier)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findBySequencingIDAndIsPrimaryAndIdentifier(sequencingID,
            isPrimary, identifier);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFObjectiveLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFObjectiveLocalService.class.getName());

            if (invokableLocalService instanceof LFObjectiveLocalService) {
                _service = (LFObjectiveLocalService) invokableLocalService;
            } else {
                _service = new LFObjectiveLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFObjectiveLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFObjectiveLocalService service) {
    }
}
