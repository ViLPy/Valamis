package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f tincan lrs statement ref service. This utility wraps {@link LFTincanLrsStatementRefPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanLrsStatementRefPersistence
 * @see LFTincanLrsStatementRefPersistenceImpl
 * @generated
 */
public class LFTincanLrsStatementRefUtil {
    private static LFTincanLrsStatementRefPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(
        LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        getPersistence().clearCache(lfTincanLrsStatementRef);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<LFTincanLrsStatementRef> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFTincanLrsStatementRef> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFTincanLrsStatementRef> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFTincanLrsStatementRef update(
        LFTincanLrsStatementRef lfTincanLrsStatementRef, boolean merge)
        throws SystemException {
        return getPersistence().update(lfTincanLrsStatementRef, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFTincanLrsStatementRef update(
        LFTincanLrsStatementRef lfTincanLrsStatementRef, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(lfTincanLrsStatementRef, merge, serviceContext);
    }

    /**
    * Caches the l f tincan lrs statement ref in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStatementRef the l f tincan lrs statement ref
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef lfTincanLrsStatementRef) {
        getPersistence().cacheResult(lfTincanLrsStatementRef);
    }

    /**
    * Caches the l f tincan lrs statement refs in the entity cache if it is enabled.
    *
    * @param lfTincanLrsStatementRefs the l f tincan lrs statement refs
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef> lfTincanLrsStatementRefs) {
        getPersistence().cacheResult(lfTincanLrsStatementRefs);
    }

    /**
    * Creates a new l f tincan lrs statement ref with the primary key. Does not add the l f tincan lrs statement ref to the database.
    *
    * @param id the primary key for the new l f tincan lrs statement ref
    * @return the new l f tincan lrs statement ref
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f tincan lrs statement ref with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f tincan lrs statement ref
    * @return the l f tincan lrs statement ref that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException if a l f tincan lrs statement ref with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef lfTincanLrsStatementRef,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfTincanLrsStatementRef, merge);
    }

    /**
    * Returns the l f tincan lrs statement ref with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException} if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs statement ref
    * @return the l f tincan lrs statement ref
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException if a l f tincan lrs statement ref with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementRefException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f tincan lrs statement ref with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f tincan lrs statement ref
    * @return the l f tincan lrs statement ref, or <code>null</code> if a l f tincan lrs statement ref with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f tincan lrs statement refs.
    *
    * @return the l f tincan lrs statement refs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f tincan lrs statement refs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs statement refs
    * @param end the upper bound of the range of l f tincan lrs statement refs (not inclusive)
    * @return the range of l f tincan lrs statement refs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f tincan lrs statement refs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan lrs statement refs
    * @param end the upper bound of the range of l f tincan lrs statement refs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan lrs statement refs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f tincan lrs statement refs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f tincan lrs statement refs.
    *
    * @return the number of l f tincan lrs statement refs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFTincanLrsStatementRefPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFTincanLrsStatementRefPersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFTincanLrsStatementRefPersistence.class.getName());

            ReferenceRegistry.registerReference(LFTincanLrsStatementRefUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFTincanLrsStatementRefPersistence persistence) {
    }
}
