package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f activity state local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFActivityStateLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFActivityStateLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFActivityStateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFActivityStateLocalServiceImpl
 * @generated
 */
public class LFActivityStateLocalServiceUtil {
    private static LFActivityStateLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFActivityStateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f activity state to the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityState the l f activity state
    * @return the l f activity state that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState addLFActivityState(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFActivityState(lfActivityState);
    }

    /**
    * Creates a new l f activity state with the primary key. Does not add the l f activity state to the database.
    *
    * @param id the primary key for the new l f activity state
    * @return the new l f activity state
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState createLFActivityState(
        long id) {
        return getService().createLFActivityState(id);
    }

    /**
    * Deletes the l f activity state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state that was removed
    * @throws PortalException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState deleteLFActivityState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFActivityState(id);
    }

    /**
    * Deletes the l f activity state from the database. Also notifies the appropriate model listeners.
    *
    * @param lfActivityState the l f activity state
    * @return the l f activity state that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState deleteLFActivityState(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFActivityState(lfActivityState);
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

    public static com.arcusys.learn.persistence.liferay.model.LFActivityState fetchLFActivityState(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFActivityState(id);
    }

    /**
    * Returns the l f activity state with the primary key.
    *
    * @param id the primary key of the l f activity state
    * @return the l f activity state
    * @throws PortalException if a l f activity state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState getLFActivityState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivityState(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f activity states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f activity states
    * @param end the upper bound of the range of l f activity states (not inclusive)
    * @return the range of l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> getLFActivityStates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivityStates(start, end);
    }

    /**
    * Returns the number of l f activity states.
    *
    * @return the number of l f activity states
    * @throws SystemException if a system exception occurred
    */
    public static int getLFActivityStatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFActivityStatesCount();
    }

    /**
    * Updates the l f activity state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityState the l f activity state
    * @return the l f activity state that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState updateLFActivityState(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFActivityState(lfActivityState);
    }

    /**
    * Updates the l f activity state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfActivityState the l f activity state
    * @param merge whether to merge the l f activity state with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f activity state that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFActivityState updateLFActivityState(
        com.arcusys.learn.persistence.liferay.model.LFActivityState lfActivityState,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFActivityState(lfActivityState, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFActivityState createLFActivityState()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFActivityState();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeIDAndActivityID(
        java.lang.Integer[] activityStateNodeID, java.lang.String activityID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByActivityStateNodeIDAndActivityID(activityStateNodeID,
            activityID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(
        java.lang.String activityID, java.lang.Integer[] activityStateNodeID,
        java.lang.Integer activityStateTreeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .findByActivityIDAndActivityStateNodeIDAndActivityStateTreeID(activityID,
            activityStateNodeID, activityStateTreeID);
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFActivityState> findByActivityStateNodeID(
        java.lang.Integer[] activityStateNodeID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByActivityStateNodeID(activityStateNodeID);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFActivityStateLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFActivityStateLocalService.class.getName());

            if (invokableLocalService instanceof LFActivityStateLocalService) {
                _service = (LFActivityStateLocalService) invokableLocalService;
            } else {
                _service = new LFActivityStateLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFActivityStateLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFActivityStateLocalService service) {
    }
}
