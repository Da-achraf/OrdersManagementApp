package ma.fstt.utilities;

import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilities {

    public static Map<String, String> getParams(HttpServletRequest request) throws IOException {
        Map<String, String> paramMap = new HashMap<>();
        String encodedParams = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        String decodedParams = URLDecoder.decode(encodedParams, StandardCharsets.UTF_8);

        String[] paramPairs = decodedParams.split("&");
        for (String paramPair : paramPairs) {
            String[] keyValue = paramPair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1].replace("+", " ");
                paramMap.put(key, value);
            }
        }

        return paramMap;
    }
}
