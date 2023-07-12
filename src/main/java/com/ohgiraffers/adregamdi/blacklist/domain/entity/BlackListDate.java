package com.ohgiraffers.adregamdi.blacklist.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class BlackListDate {

    @Column
    private LocalDateTime startDateTime;

    @Column
    private LocalDateTime endDateTime;

    @Column
    private int period;

    public BlackListDate(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.period = getPeriod();
    }

    private int getPeriod() {

        return 0;
    }
}
