package io.github.tomhusky.demo.websocketmvc.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 测试请求
 * <p/>
 *
 * @author lwj
 * @version 1.0
 * @since 2021/11/12 13:37
 */
@Data
public class TestVo {

    @NotBlank(message = "name不能为空")
    private String name;

    @NotNull(message = "name不能为空")
    private Integer age;

    private String msg;
}
