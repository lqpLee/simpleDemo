package org.lee.gson;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author liqp
 * @since 2020-06-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObject {

    private Integer code;

    private String description;

    private ResultData data;

    private String logId;

}
