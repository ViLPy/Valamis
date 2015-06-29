package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSlideSet;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f slide set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlideSetPersistenceImpl
 * @see LFSlideSetUtil
 * @generated
 */
public interface LFSlideSetPersistence extends BasePersistence<LFSlideSet> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSlideSetUtil} to access the l f slide set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f slide sets where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the matching l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideSet> findByCourseId(
        java.lang.Long courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f slide sets where courseId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseId the course ID
    * @param start the lower bound of the range of l f slide sets
    * @param end the upper bound of the range of l f slide sets (not inclusive)
    * @return the range of matching l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideSet> findByCourseId(
        java.lang.Long courseId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f slide sets where courseId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param courseId the course ID
    * @param start the lower bound of the range of l f slide sets
    * @param end the upper bound of the range of l f slide sets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideSet> findByCourseId(
        java.lang.Long courseId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f slide set in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f slide set
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException if a matching l f slide set could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet findByCourseId_First(
        java.lang.Long courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f slide set in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f slide set, or <code>null</code> if a matching l f slide set could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet fetchByCourseId_First(
        java.lang.Long courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f slide set in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f slide set
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException if a matching l f slide set could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet findByCourseId_Last(
        java.lang.Long courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f slide set in the ordered set where courseId = &#63;.
    *
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f slide set, or <code>null</code> if a matching l f slide set could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet fetchByCourseId_Last(
        java.lang.Long courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f slide sets before and after the current l f slide set in the ordered set where courseId = &#63;.
    *
    * @param id the primary key of the current l f slide set
    * @param courseId the course ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f slide set
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException if a l f slide set with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet[] findByCourseId_PrevAndNext(
        long id, java.lang.Long courseId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f slide sets where courseId = &#63; from the database.
    *
    * @param courseId the course ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCourseId(java.lang.Long courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f slide sets where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the number of matching l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseId(java.lang.Long courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f slide set in the entity cache if it is enabled.
    *
    * @param lfSlideSet the l f slide set
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSlideSet lfSlideSet);

    /**
    * Caches the l f slide sets in the entity cache if it is enabled.
    *
    * @param lfSlideSets the l f slide sets
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideSet> lfSlideSets);

    /**
    * Creates a new l f slide set with the primary key. Does not add the l f slide set to the database.
    *
    * @param id the primary key for the new l f slide set
    * @return the new l f slide set
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet create(
        long id);

    /**
    * Removes the l f slide set with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f slide set
    * @return the l f slide set that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException if a l f slide set with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSlideSet updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSlideSet lfSlideSet)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f slide set with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException} if it could not be found.
    *
    * @param id the primary key of the l f slide set
    * @return the l f slide set
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException if a l f slide set with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideSetException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f slide set with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f slide set
    * @return the l f slide set, or <code>null</code> if a l f slide set with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlideSet fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f slide sets.
    *
    * @return the l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideSet> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f slide sets.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f slide sets
    * @param end the upper bound of the range of l f slide sets (not inclusive)
    * @return the range of l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideSet> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f slide sets.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f slide sets
    * @param end the upper bound of the range of l f slide sets (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlideSet> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f slide sets from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f slide sets.
    *
    * @return the number of l f slide sets
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
