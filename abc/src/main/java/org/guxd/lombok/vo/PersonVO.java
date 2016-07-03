package org.guxd.lombok.vo;

import lombok.Data;

/**
 * Created by hyunji on 2016. 6. 15..
 */

@Data
public class PersonVO {
    private String name;

    private String job;

    private int age;

    private boolean deleteYn;
}
