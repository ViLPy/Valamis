package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFObjectiveMap;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f objective map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFObjectiveMapPersistenceImpl
 * @see LFObjectiveMapUtil
 * @generated
 */
public interface LFObjectiveMapPersistence extends BasePersistence<LFObjectiveMap> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFObjectiveMapUtil} to access the l f objective map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the l f objective maps where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @return the matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findByObjectiveID(
        java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f objective maps where objectiveID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objectiveID the objective i d
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @return the range of matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findByObjectiveID(
        java.lang.Integer objectiveID, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f objective maps where objectiveID = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param objectiveID the objective i d
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findByObjectiveID(
        java.lang.Integer objectiveID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap findByObjectiveID_First(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching l f objective map, or <code>null</code> if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap fetchByObjectiveID_First(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap findByObjectiveID_Last(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching l f objective map, or <code>null</code> if a matching l f objective map could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap fetchByObjectiveID_Last(
        java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective maps before and after the current l f objective map in the ordered set where objectiveID = &#63;.
    *
    * @param id the primary key of the current l f objective map
    * @param objectiveID the objective i d
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap[] findByObjectiveID_PrevAndNext(
        long id, java.lang.Integer objectiveID,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f objective maps where objectiveID = &#63; from the database.
    *
    * @param objectiveID the objective i d
    * @throws SystemException if a system exception occurred
    */
    public void removeByObjectiveID(java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objective maps where objectiveID = &#63;.
    *
    * @param objectiveID the objective i d
    * @return the number of matching l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public int countByObjectiveID(java.lang.Integer objectiveID)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the l f objective map in the entity cache if it is enabled.
    *
    * @param lfObjectiveMap the l f objective map
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap);

    /**
    * Caches the l f objective maps in the entity cache if it is enabled.
    *
    * @param lfObjectiveMaps the l f objective maps
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> lfObjectiveMaps);

    /**
    * Creates a new l f objective map with the primary key. Does not add the l f objective map to the database.
    *
    * @param id the primary key for the new l f objective map
    * @return the new l f objective map
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap create(
        long id);

    /**
    * Removes the l f objective map with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap remove(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFObjectiveMap lfObjectiveMap)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective map with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException} if it could not be found.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFObjectiveMapException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f objective map with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f objective map
    * @return the l f objective map, or <code>null</code> if a l f objective map with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFObjectiveMap fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f objective maps.
    *
    * @return the l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f objective maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @return the range of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f objective maps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFObjectiveMapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f objective maps
    * @param end the upper bound of the range of l f objective maps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFObjectiveMap> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f objective maps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f objective maps.
    *
    * @return the number of l f objective maps
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
