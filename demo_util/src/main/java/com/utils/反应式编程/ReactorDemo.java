package com.utils.反应式编程;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/5
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReactorDemo {
    private Integer id;
    private String username;
}
