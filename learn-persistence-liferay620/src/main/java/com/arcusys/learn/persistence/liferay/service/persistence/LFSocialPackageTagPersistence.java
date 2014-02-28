package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f social package tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSocialPackageTagPersistenceImpl
 * @see LFSocialPackageTagUtil
 * @generated
 */
public interface LFSocialPackageTagPersistence extends BasePersistence<LFSocialPackageTag> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSocialPackageTagUtil} to access the l f social package tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f social package tags where name = &#63;.
    *
    * @param name the name
    * @return the matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f social package tags where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of l f social package tags
    * @param end the upper bound of the range of l f social package tags (not inclusive)
    * @return the range of matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f social package tags where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of l f social package tags
    * @param end the upper bound of the range of l f social package tags (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f social package tag in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package tag
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f social package tag in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag fetchByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f social package tag in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package tag
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f social package tag in the ordered set where name = &#63;.
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag fetchByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f social package tags before and after the current l f social package tag in the ordered set where name = &#63;.
    *
    * @param id the primary key of the current l f social package tag
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f social package tag
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag[] findByName_PrevAndNext(
        long id, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f social package tags where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f social package tags where name = &#63;.
    *
    * @param name the name
    * @return the number of matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f social package tags where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findBySocialPackageID(
        java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f social package tags where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f social package tags
    * @param end the upper bound of the range of l f social package tags (not inclusive)
    * @return the range of matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f social package tags where socialPackageID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param socialPackageID the social package i d
    * @param start the lower bound of the range of l f social package tags
    * @param end the upper bound of the range of l f social package tags (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findBySocialPackageID(
        java.lang.Integer socialPackageID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f social package tag in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package tag
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag findBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f social package tag in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag fetchBySocialPackageID_First(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f social package tag in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package tag
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag findBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f social package tag in the ordered set where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f social package tag, or <code>null</code> if a matching l f social package tag could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag fetchBySocialPackageID_Last(
        java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f social package tags before and after the current l f social package tag in the ordered set where socialPackageID = &#63;.
    *
    * @param id the primary key of the current l f social package tag
    * @param socialPackageID the social package i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f social package tag
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag[] findBySocialPackageID_PrevAndNext(
        long id, java.lang.Integer socialPackageID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f social package tags where socialPackageID = &#63; from the database.
    *
    * @param socialPackageID the social package i d
    * @throws SystemException if a system exception occurred
    */
    public void removeBySocialPackageID(java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f social package tags where socialPackageID = &#63;.
    *
    * @param socialPackageID the social package i d
    * @return the number of matching l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public int countBySocialPackageID(java.lang.Integer socialPackageID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f social package tag in the entity cache if it is enabled.
    *
    * @param lfSocialPackageTag the l f social package tag
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag);

    /**
    * Caches the l f social package tags in the entity cache if it is enabled.
    *
    * @param lfSocialPackageTags the l f social package tags
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> lfSocialPackageTags);

    /**
    * Creates a new l f social package tag with the primary key. Does not add the l f social package tag to the database.
    *
    * @param id the primary key for the new l f social package tag
    * @return the new l f social package tag
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag create(
        long id);

    /**
    * Removes the l f social package tag with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f social package tag
    * @return the l f social package tag that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag lfSocialPackageTag)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f social package tag with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException} if it could not be found.
    *
    * @param id the primary key of the l f social package tag
    * @return the l f social package tag
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException if a l f social package tag with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSocialPackageTagException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f social package tag with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f social package tag
    * @return the l f social package tag, or <code>null</code> if a l f social package tag with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f social package tags.
    *
    * @return the l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f social package tags.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f social package tags
    * @param end the upper bound of the range of l f social package tags (not inclusive)
    * @return the range of l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f social package tags.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSocialPackageTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f social package tags
    * @param end the upper bound of the range of l f social package tags (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSocialPackageTag> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f social package tags from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f social package tags.
    *
    * @return the number of l f social package tags
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
