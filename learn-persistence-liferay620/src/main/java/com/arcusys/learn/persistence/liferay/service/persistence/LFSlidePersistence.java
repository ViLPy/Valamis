package com.arcusys.learn.persistence.liferay.service.persistence;

import com.arcusys.learn.persistence.liferay.model.LFSlide;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l f slide service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LFSlidePersistenceImpl
 * @see LFSlideUtil
 * @generated
 */
public interface LFSlidePersistence extends BasePersistence<LFSlide> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link LFSlideUtil} to access the l f slide persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the l f slide in the entity cache if it is enabled.
    *
    * @param lfSlide the l f slide
    */
    public void cacheResult(
        com.arcusys.learn.persistence.liferay.model.LFSlide lfSlide);

    /**
    * Caches the l f slides in the entity cache if it is enabled.
    *
    * @param lfSlides the l f slides
    */
    public void cacheResult(
        java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlide> lfSlides);

    /**
    * Creates a new l f slide with the primary key. Does not add the l f slide to the database.
    *
    * @param id the primary key for the new l f slide
    * @return the new l f slide
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlide create(long id);

    /**
    * Removes the l f slide with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the l f slide
    * @return the l f slide that was removed
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException if a l f slide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlide remove(long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.arcusys.learn.persistence.liferay.model.LFSlide updateImpl(
        com.arcusys.learn.persistence.liferay.model.LFSlide lfSlide)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f slide with the primary key or throws a {@link com.arcusys.learn.persistence.liferay.NoSuchLFSlideException} if it could not be found.
    *
    * @param id the primary key of the l f slide
    * @return the l f slide
    * @throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException if a l f slide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlide findByPrimaryKey(
        long id)
        throws com.arcusys.learn.persistence.liferay.NoSuchLFSlideException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the l f slide with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the l f slide
    * @return the l f slide, or <code>null</code> if a l f slide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.arcusys.learn.persistence.liferay.model.LFSlide fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the l f slides.
    *
    * @return the l f slides
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlide> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the l f slides.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f slides
    * @param end the upper bound of the range of l f slides (not inclusive)
    * @return the range of l f slides
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlide> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the l f slides.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arcusys.learn.persistence.liferay.model.impl.LFSlideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of l f slides
    * @param end the upper bound of the range of l f slides (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of l f slides
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.arcusys.learn.persistence.liferay.model.LFSlide> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the l f slides from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of l f slides.
    *
    * @return the number of l f slides
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
