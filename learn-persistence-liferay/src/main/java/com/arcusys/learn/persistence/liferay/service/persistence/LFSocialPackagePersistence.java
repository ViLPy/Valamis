package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f social package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackagePersistenceImpl
 * @see LFSocialPackageUtil
 * @generated
 */
public interface LFSocialPackagePersistence extends BasePersistence<LFSocialPackage> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSocialPackageUtil} to access the l f social package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f social packages where authorID = &#63;.
    *
    * @param authorID the author i d
    * @return the matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f social packages where authorID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param authorID the author i d
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @return the range of matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f social packages where authorID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param authorID the author i d
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findByAuthorID(
        java.lang.Integer authorID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage findByAuthorID_First(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package, or <code>null</code> if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchByAuthorID_First(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage findByAuthorID_Last(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f social package in the ordered set where authorID = &#63;.
    *
    * @param authorID the author i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package, or <code>null</code> if a matching l f social package could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchByAuthorID_Last(
        java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage[] findByAuthorID_PrevAndNext(
        long id, java.lang.Integer authorID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f social packages where authorID = &#63; from the database.
    *
    * @param authorID the author i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByAuthorID(java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f social packages where authorID = &#63;.
    *
    * @param authorID the author i d
    * @return the number of matching l f social packages
    * @throws SystemException if a system exception occurred
    */
    public int countByAuthorID(java.lang.Integer authorID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f social package in the entity cache if it is enabled.
    *
    * @param lfSocialPackage the l f social package
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage);

    /**
    * Caches the l f social packages in the entity cache if it is enabled.
    *
    * @param lfSocialPackages the l f social packages
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> lfSocialPackages);

    /**
    * Creates a new l f social package with the primary key. Does not add the l f social package to the database.
    *
    * @param id the primary key for the new l f social package
    * @return the new l f social package
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage create(
        long id);

    /**
    * Removes the l f social package with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackage lfSocialPackage)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f social package with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException} if it could not be found.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f social package with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f social package
    * @return the l f social package, or <code>null</code> if a l f social package with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackage fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f social packages.
    *
    * @return the l f social packages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f social packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @return the range of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f social packages.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f social packages
    * @param end the upper bound of the range of l f social packages (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackage> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f social packages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f social packages.
    *
    * @return the number of l f social packages
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
