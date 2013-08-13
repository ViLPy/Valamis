package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackage;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l f social package service. This utility wraps {@link LFSocialPackagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackagePersistence
 * @see LFSocialPackagePersistenceImpl
 * @generated
 */
public class LFSocialPackageUtil {
    private static LFSocialPackagePersistence _persistence;

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
    public static void clearCache(LFSocialPackage lfSocialPackage) {
        getPersistence().clearCache(lfSocialPackage);
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
    public static List<LFSocialPackage> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<LFSocialPackage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<LFSocialPackage> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static LFSocialPackage update(LFSocialPackage lfSocialPackage,
        boolean merge) throws SystemException {
        return getPersistence().update(lfSocialPackage, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static LFSocialPackage update(LFSocialPackage lfSocialPackage,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(lfSocialPackage, merge, serviceContext);
    }

    /**
    * Caches the l f social package in the entity cache if it is enabled.
    *
    * @param lfSocialPackage the l f social package
    */
    public static void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage) {
        getPersistence().cacheResult(lfSocialPackage);
    }

    /**
    * Caches the l f social packages in the entity cache if it is enabled.
    *
    * @param lfSocialPackages the l f social packages
    */
    public static void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> lfSocialPackages) {
        getPersistence().cacheResult(lfSocialPackages);
    }

    /**
    * Creates a new l f social package with the primary key. Does not add the l f social package to the database.
    *
    * @param id the primary key for the new l f social package
    * @return the new l f social package
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage create(
        long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the l f social package with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(lfSocialPackage, merge);
    }

    /**
    * Returns the l f social package with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException} if it could not be found.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the l f social package with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package, or <code>null</code> if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the l f social packages where authorID = &#63;.
    *
    * @param authorID the author i d
    * @return the matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAuthorID(authorID);
    }

    /**
    * Returns a range of all the l f social packages where authorID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param authorID the author i d
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @return the range of matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAuthorID(authorID, start, end);
    }

    /**
    * Returns an ordered range of all the l f social packages where authorID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param authorID the author i d
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAuthorID(authorID, start, end, orderByComparator);
    }

    /**
    * Returns the first l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage findByAuthorID_First(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAuthorID_First(authorID, orderByComparator);
    }

    /**
    * Returns the first l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package, or <code>null</code> if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchByAuthorID_First(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAuthorID_First(authorID, orderByComparator);
    }

    /**
    * Returns the last l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage findByAuthorID_Last(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAuthorID_Last(authorID, orderByComparator);
    }

    /**
    * Returns the last l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package, or <code>null</code> if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchByAuthorID_Last(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByAuthorID_Last(authorID, orderByComparator);
    }

    /**
    * Returns the l f social packages before and after the current l f social package in the ordered set where authorID = &#63;.
    *
    * @param id the primary key of the current l f social package
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f social package
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.arcusys.learn.persistence.liferay.model.LFSocialPackage[] findByAuthorID_PrevAndNext(
        long id, java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAuthorID_PrevAndNext(id, authorID, orderByComparator);
    }

    /**
    * Returns all the l f social packages.
    *
    * @return the l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the l f social packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @return the range of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the l f social packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the l f social packages where authorID = &#63; from the database.
    *
    * @param authorID the author i d
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAuthorID(java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAuthorID(authorID);
    }

    /**
    * Removes all the l f social packages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of l f social packages where authorID = &#63;.
    *
    * @param authorID the author i d
    * @return the number of matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static int countByAuthorID(java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAuthorID(authorID);
    }

    /**
    * Returns the number of l f social packages.
    *
    * @return the number of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LFSocialPackagePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LFSocialPackagePersistence) PortletBeanLocatorUtil.locate(com.arcusys.learn.persistence.liferay.service.ClpSerializer.getServletContextName(),
                    LFSocialPackagePersistence.class.getName());

            ReferenceRegistry.registerReference(LFSocialPackageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LFSocialPackagePersistence persistence) {
    }
}
