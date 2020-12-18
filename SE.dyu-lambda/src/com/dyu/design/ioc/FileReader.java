package com.dyu.design.ioc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class FileReader {

    public List<String> findHeadings(Reader input) {
        return withLineOf(input,
                            lines -> lines.filter(line -> line.endsWith(":"))
                                    .map(line -> line.substring(0, line.length() - 1))
                                    .collect(Collectors.toList()),
                            RuntimeException::new);
    }

    private <T> T withLineOf(Reader input,
                             Function<Stream<String>, T> handler,
                             Function<IOException, RuntimeException> error) {
        try (BufferedReader reader = new BufferedReader(input)) {
            return handler.apply(reader.lines());
        } catch (IOException ie) {
            throw error.apply(ie);
        }
    }
}
