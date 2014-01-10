package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsContextActivitiesLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsContextActivitiesClp extends BaseModelImpl<LFTincanLrsContextActivities>
    implements LFTincanLrsContextActivities {
    private long _id;
    private String _parent;
    private String _grouping;
    private String _category;
    private String _other;
    private BaseModel<?> _lfTincanLrsContextActivitiesRemoteModel;

    public LFTincanLrsContextActivitiesClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsContextActivities.class;
    }

    public String getModelClassName() {
        return LFTincanLrsContextActivities.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("parent", getParent());
        attributes.put("grouping", getGrouping());
        attributes.put("category", getCategory());
        attributes.put("other", getOther());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String parent = (String) attributes.get("parent");

        if (parent != null) {
            setParent(parent);
        }

        String grouping = (String) attributes.get("grouping");

        if (grouping != null) {
            setGrouping(grouping);
        }

        String category = (String) attributes.get("category");

        if (category != null) {
            setCategory(category);
        }

        String other = (String) attributes.get("other");

        if (other != null) {
            setOther(other);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getParent() {
        return _parent;
    }

    public void setParent(String parent) {
        _parent = parent;
    }

    public String getGrouping() {
        return _grouping;
    }

    public void setGrouping(String grouping) {
        _grouping = grouping;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public String getOther() {
        return _other;
    }

    public void setOther(String other) {
        _other = other;
    }

    public BaseModel<?> getLFTincanLrsContextActivitiesRemoteModel() {
        return _lfTincanLrsContextActivitiesRemoteModel;
    }

    public void setLFTincanLrsContextActivitiesRemoteModel(
        BaseModel<?> lfTincanLrsContextActivitiesRemoteModel) {
        _lfTincanLrsContextActivitiesRemoteModel = lfTincanLrsContextActivitiesRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsContextActivitiesLocalServiceUtil.addLFTincanLrsContextActivities(this);
        } else {
            LFTincanLrsContextActivitiesLocalServiceUtil.updateLFTincanLrsContextActivities(this);
        }
    }

    @Override
    public LFTincanLrsContextActivities toEscapedModel() {
        return (LFTincanLrsContextActivities) Proxy.newProxyInstance(LFTincanLrsContextActivities.class.getClassLoader(),
            new Class[] { LFTincanLrsContextActivities.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsContextActivitiesClp clone = new LFTincanLrsContextActivitiesClp();

        clone.setId(getId());
        clone.setParent(getParent());
        clone.setGrouping(getGrouping());
        clone.setCategory(getCategory());
        clone.setOther(getOther());

        return clone;
    }

    public int compareTo(
        LFTincanLrsContextActivities lfTincanLrsContextActivities) {
        long primaryKey = lfTincanLrsContextActivities.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFTincanLrsContextActivitiesClp lfTincanLrsContextActivities = null;

        try {
            lfTincanLrsContextActivities = (LFTincanLrsContextActivitiesClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanLrsContextActivities.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", parent=");
        sb.append(getParent());
        sb.append(", grouping=");
        sb.append(getGrouping());
        sb.append(", category=");
        sb.append(getCategory());
        sb.append(", other=");
        sb.append(getOther());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsContextActivities");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parent</column-name><column-value><![CDATA[");
        sb.append(getParent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>grouping</column-name><column-value><![CDATA[");
        sb.append(getGrouping());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>category</column-name><column-value><![CDATA[");
        sb.append(getCategory());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>other</column-name><column-value><![CDATA[");
        sb.append(getOther());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
