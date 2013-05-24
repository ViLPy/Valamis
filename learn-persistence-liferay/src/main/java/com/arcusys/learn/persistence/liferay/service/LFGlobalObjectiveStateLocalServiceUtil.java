package com.arcusys.learn.persistence.liferay.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the l f global objective state local service. This utility wraps {@link com.arcusys.learn.persistence.liferay.service.impl.LFGlobalObjectiveStateLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFGlobalObjectiveStateLocalService
 * @see com.arcusys.learn.persistence.liferay.service.base.LFGlobalObjectiveStateLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.impl.LFGlobalObjectiveStateLocalServiceImpl
 * @generated
 */
public class LFGlobalObjectiveStateLocalServiceUtil {
    private static LFGlobalObjectiveStateLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.arcusys.learn.persistence.liferay.service.impl.LFGlobalObjectiveStateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the l f global objective state to the database. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @return the l f global objective state that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState addLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLFGlobalObjectiveState(lfGlobalObjectiveState);
    }

    /**
    * Creates a new l f global objective state with the primary key. Does not add the l f global objective state to the database.
    *
    * @param id the primary key for the new l f global objective state
    * @return the new l f global objective state
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState createLFGlobalObjectiveState(
        long id) {
        return getService().createLFGlobalObjectiveState(id);
    }

    /**
    * Deletes the l f global objective state with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state that was removed
    * @throws PortalException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState deleteLFGlobalObjectiveState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFGlobalObjectiveState(id);
    }

    /**
    * Deletes the l f global objective state from the database. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @return the l f global objective state that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState deleteLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLFGlobalObjectiveState(lfGlobalObjectiveState);
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

    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState fetchLFGlobalObjectiveState(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLFGlobalObjectiveState(id);
    }

    /**
    * Returns the l f global objective state with the primary key.
    *
    * @param id the primary key of the l f global objective state
    * @return the l f global objective state
    * @throws PortalException if a l f global objective state with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState getLFGlobalObjectiveState(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFGlobalObjectiveState(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the l f global objective states.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f global objective states
    * @param end the upper bound of the range of l f global objective states (not inclusive)
    * @return the range of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> getLFGlobalObjectiveStates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFGlobalObjectiveStates(start, end);
    }

    /**
    * Returns the number of l f global objective states.
    *
    * @return the number of l f global objective states
    * @throws SystemException if a system exception occurred
    */
    public static int getLFGlobalObjectiveStatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLFGlobalObjectiveStatesCount();
    }

    /**
    * Updates the l f global objective state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @return the l f global objective state that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState updateLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLFGlobalObjectiveState(lfGlobalObjectiveState);
    }

    /**
    * Updates the l f global objective state in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param lfGlobalObjectiveState the l f global objective state
    * @param merge whether to merge the l f global objective state with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the l f global objective state that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState updateLFGlobalObjectiveState(
        com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState lfGlobalObjectiveState,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateLFGlobalObjectiveState(lfGlobalObjectiveState, merge);
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

    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState createLFGlobalObjectiveState()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createLFGlobalObjectiveState();
    }

    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState> findByTreeID(
        java.lang.Integer treeID, int start, int end)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByTreeID(treeID, start, end);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFGlobalObjectiveState findByTreeIDAndMapKey(
        java.lang.Integer treeID, java.lang.String mapKey)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFGlobalObjectiveStateException,
            com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findByTreeIDAndMapKey(treeID, mapKey);
    }

    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAll();
    }

    public static void clearService() {
        _service = null;
    }

    public static LFGlobalObjectiveStateLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LFGlobalObjectiveStateLocalService.class.getName());

            if (invokableLocalService instanceof LFGlobalObjectiveStateLocalService) {
                _service = (LFGlobalObjectiveStateLocalService) invokableLocalService;
            } else {
                _service = new LFGlobalObjectiveStateLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LFGlobalObjectiveStateLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LFGlobalObjectiveStateLocalService service) {
    }
}
