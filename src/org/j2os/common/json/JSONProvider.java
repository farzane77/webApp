package org.j2os.common.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSONProvider {
    public static String toJSon(Object o) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }
}
