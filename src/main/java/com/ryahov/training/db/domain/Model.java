package com.ryahov.training.db.domain;

import java.io.Serializable;

/**
 * @author Aleksandr Rjakhov
 */
public interface Model<ID extends Number & Serializable & Comparable<ID>> {

    ID getId();

    void setId(ID id);
}
