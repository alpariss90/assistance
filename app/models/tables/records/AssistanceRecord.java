/*
 * This file is generated by jOOQ.
*/
package models.tables.records;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import models.tables.Assistance;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AssistanceRecord extends UpdatableRecordImpl<AssistanceRecord> implements Record8<Long, String, String, String, Boolean, String, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = -1661115368;

    /**
     * Setter for <code>public.assistance.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.assistance.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.assistance.motif</code>.
     */
    public void setMotif(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.assistance.motif</code>.
     */
    public String getMotif() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.assistance.declarant</code>.
     */
    public void setDeclarant(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.assistance.declarant</code>.
     */
    public String getDeclarant() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.assistance.observations</code>.
     */
    public void setObservations(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.assistance.observations</code>.
     */
    public String getObservations() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.assistance.is_close</code>.
     */
    public void setIsClose(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.assistance.is_close</code>.
     */
    public Boolean getIsClose() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>public.assistance.maintenacier</code>.
     */
    public void setMaintenacier(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.assistance.maintenacier</code>.
     */
    public String getMaintenacier() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.assistance.when_done</code>.
     */
    public void setWhenDone(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.assistance.when_done</code>.
     */
    public LocalDateTime getWhenDone() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.assistance.when_close</code>.
     */
    public void setWhenClose(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.assistance.when_close</code>.
     */
    public LocalDateTime getWhenClose() {
        return (LocalDateTime) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, String, String, Boolean, String, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, String, String, String, Boolean, String, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Assistance.ASSISTANCE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Assistance.ASSISTANCE.MOTIF;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Assistance.ASSISTANCE.DECLARANT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Assistance.ASSISTANCE.OBSERVATIONS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return Assistance.ASSISTANCE.IS_CLOSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Assistance.ASSISTANCE.MAINTENACIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field7() {
        return Assistance.ASSISTANCE.WHEN_DONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field8() {
        return Assistance.ASSISTANCE.WHEN_CLOSE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getMotif();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDeclarant();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getObservations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component5() {
        return getIsClose();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getMaintenacier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component7() {
        return getWhenDone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component8() {
        return getWhenClose();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getMotif();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDeclarant();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getObservations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getIsClose();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getMaintenacier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value7() {
        return getWhenDone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value8() {
        return getWhenClose();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value2(String value) {
        setMotif(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value3(String value) {
        setDeclarant(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value4(String value) {
        setObservations(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value5(Boolean value) {
        setIsClose(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value6(String value) {
        setMaintenacier(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value7(LocalDateTime value) {
        setWhenDone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value8(LocalDateTime value) {
        setWhenClose(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord values(Long value1, String value2, String value3, String value4, Boolean value5, String value6, LocalDateTime value7, LocalDateTime value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AssistanceRecord
     */
    public AssistanceRecord() {
        super(Assistance.ASSISTANCE);
    }

    /**
     * Create a detached, initialised AssistanceRecord
     */
    public AssistanceRecord(Long id, String motif, String declarant, String observations, Boolean isClose, String maintenacier, LocalDateTime whenDone, LocalDateTime whenClose) {
        super(Assistance.ASSISTANCE);

        set(0, id);
        set(1, motif);
        set(2, declarant);
        set(3, observations);
        set(4, isClose);
        set(5, maintenacier);
        set(6, whenDone);
        set(7, whenClose);
    }
}
