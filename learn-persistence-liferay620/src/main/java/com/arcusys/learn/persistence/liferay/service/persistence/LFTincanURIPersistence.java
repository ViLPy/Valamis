package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFTincanURI;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f tincan u r i service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFTincanURIPersistenceImpl
 * @see LFTincanURIUtil
 * @generated
 */
public interface LFTincanURIPersistence extends BasePersistence<LFTincanURI> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFTincanURIUtil} to access the l f tincan u r i persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException} if it could not be found.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the matching l f tincan u r i
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a matching l f tincan u r i could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI findByURI(
        java.lang.String objID, java.lang.String objType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the matching l f tincan u r i, or <code>null</code> if a matching l f tincan u r i could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchByURI(
        java.lang.String objID, java.lang.String objType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan u r i where objID = &#63; and objType = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching l f tincan u r i, or <code>null</code> if a matching l f tincan u r i could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchByURI(
        java.lang.String objID, java.lang.String objType,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the l f tincan u r i where objID = &#63; and objType = &#63; from the database.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the l f tincan u r i that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI removeByURI(
        java.lang.String objID, java.lang.String objType)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan u r is where objID = &#63; and objType = &#63;.
    *
    * @param objID the obj i d
    * @param objType the obj type
    * @return the number of matching l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public int countByURI(java.lang.String objID, java.lang.String objType)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f tincan u r i in the entity cache if it is enabled.
    *
    * @param lfTincanURI the l f tincan u r i
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI);

    /**
    * Caches the l f tincan u r is in the entity cache if it is enabled.
    *
    * @param lfTincanURIs the l f tincan u r is
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> lfTincanURIs);

    /**
    * Creates a new l f tincan u r i with the primary key. Does not add the l f tincan u r i to the database.
    *
    * @param uri the primary key for the new l f tincan u r i
    * @return the new l f tincan u r i
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI create(
        java.lang.String uri);

    /**
    * Removes the l f tincan u r i with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI remove(
        java.lang.String uri)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFTincanURI updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFTincanURI lfTincanURI)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan u r i with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException} if it could not be found.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI findByPrimaryKey(
        java.lang.String uri)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFTincanURIException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f tincan u r i with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param uri the primary key of the l f tincan u r i
    * @return the l f tincan u r i, or <code>null</code> if a l f tincan u r i with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFTincanURI fetchByPrimaryKey(
        java.lang.String uri)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f tincan u r is.
    *
    * @return the l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f tincan u r is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan u r is
    * @param end the upper bound of the range of l f tincan u r is (not inclusive)
    * @return the range of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f tincan u r is.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFTincanURIModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f tincan u r is
    * @param end the upper bound of the range of l f tincan u r is (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFTincanURI> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f tincan u r is from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f tincan u r is.
    *
    * @return the number of l f tincan u r is
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
