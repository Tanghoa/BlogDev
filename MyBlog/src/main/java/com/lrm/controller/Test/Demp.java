package com.lrm.controller.Test;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Demp {

    private Integer id;

    @NotBlank(message = "字段不能为空")
    private String  name;

}
