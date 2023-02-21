package util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class Client {
    private static final HttpClient httpClient = HttpClient.newBuilder().build();

    public static @Nullable String request(@NotNull String url) {
        String body;
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(Objects.requireNonNull(url)))
                    .header("User-Agent", "Java HttpClient")
                    .build();
            body = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (URISyntaxException | IOException | InterruptedException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
        return body;
    }
}
