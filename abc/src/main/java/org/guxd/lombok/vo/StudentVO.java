package org.guxd.lombok.vo;

import lombok.Data;

/**
 * Created by hyunji on 2016. 6. 15..
 */
@Data
public class StudentVO extends PersonVO {

    private String grade;

    private String major;

    private int classNumber;
}
