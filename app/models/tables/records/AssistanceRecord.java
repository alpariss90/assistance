/*
 * This file is generated by jOOQ.
*/
package models.tables.records;


import java.time.LocalDateTime;

import javax.annotation.Generated;

import models.tables.Assistance;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
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
public class AssistanceRecord extends UpdatableRecordImpl<AssistanceRecord> implements Record11<Long, String, String, String, Boolean, String, LocalDateTime, LocalDateTime, Boolean, LocalDateTime, Boolean> {

    private static final long serialVersionUID = 927505241;

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

    /**
     * Setter for <code>public.assistance.is_ok</code>.
     */
    public void setIsOk(Boolean value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.assistance.is_ok</code>.
     */
    public Boolean getIsOk() {
        return (Boolean) get(8);
    }

    /**
     * Setter for <code>public.assistance.when_ok</code>.
     */
    public void setWhenOk(LocalDateTime value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.assistance.when_ok</code>.
     */
    public LocalDateTime getWhenOk() {
        return (LocalDateTime) get(9);
    }

    /**
     * Setter for <code>public.assistance.new_create</code>.
     */
    public void setNewCreate(Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.assistance.new_create</code>.
     */
    public Boolean getNewCreate() {
        return (Boolean) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, Boolean, String, LocalDateTime, LocalDateTime, Boolean, LocalDateTime, Boolean> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Long, String, String, String, Boolean, String, LocalDateTime, LocalDateTime, Boolean, LocalDateTime, Boolean> valuesRow() {
        return (Row11) super.valuesRow();
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
    public Field<Boolean> field9() {
        return Assistance.ASSISTANCE.IS_OK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field10() {
        return Assistance.ASSISTANCE.WHEN_OK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field11() {
        return Assistance.ASSISTANCE.NEW_CREATE;
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
    public Boolean component9() {
        return getIsOk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component10() {
        return getWhenOk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component11() {
        return getNewCreate();
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
    public Boolean value9() {
        return getIsOk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value10() {
        return getWhenOk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value11() {
        return getNewCreate();
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
    public AssistanceRecord value9(Boolean value) {
        setIsOk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value10(LocalDateTime value) {
        setWhenOk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord value11(Boolean value) {
        setNewCreate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AssistanceRecord values(Long value1, String value2, String value3, String value4, Boolean value5, String value6, LocalDateTime value7, LocalDateTime value8, Boolean value9, LocalDateTime value10, Boolean value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
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
    public AssistanceRecord(Long id, String motif, String declarant, String observations, Boolean isClose, String maintenacier, LocalDateTime whenDone, LocalDateTime whenClose, Boolean isOk, LocalDateTime whenOk, Boolean newCreate) {
        super(Assistance.ASSISTANCE);

        set(0, id);
        set(1, motif);
        set(2, declarant);
        set(3, observations);
        set(4, isClose);
        set(5, maintenacier);
        set(6, whenDone);
        set(7, whenClose);
        set(8, isOk);
        set(9, whenOk);
        set(10, newCreate);
    }
}
