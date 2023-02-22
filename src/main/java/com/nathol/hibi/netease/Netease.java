package com.nathol.hibi.netease;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.nathol.hibi.netease.vo.Period;
import com.nathol.hibi.netease.vo.SearchType;
import com.nathol.hibi.netease.vo.Br;
import com.nathol.hibi.netease.util.UrlBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SuppressWarnings("unused")
public class Netease {
    private static final String api = "https://api.obfs.dev/api";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final HttpClient httpClient = HttpClient.newBuilder().build();
    private final String url;
    
    private Netease(String url){
        this.url = url;
    }

    @Contract("_ -> new")
    public static @NotNull Netease album(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("album")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 次方法用于生成请求 Artist 的请求地址
     *
     * @param id 歌手 ID
     * @return the json element
     */
    @Contract("_ -> new")
    public static @NotNull Netease artist(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("artist")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 Comments 的请求地址
     *
     * @param id     歌曲 ID
     * @param limit  限制参数, default : 1
     * @param offset 偏移数量, default : 0
     * @return the json element
     */
    @Contract("_, _, _ -> new")
    public static @NotNull Netease comments(int id, @Nullable Integer limit, @Nullable Integer offset) {
        limit = limit == null ? 1 : limit;
        offset = offset == null ? 0 : offset;
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("comments")
                        .addQuery("id", id)
                        .addQuery("limit", limit)
                        .addQuery("offset", offset)
                        .build()
        );
}

    /**
     * 此方法用于生成 Detail 的请求地址
     *
     * @param id 音乐 ID
     * @return json element
     */
    @Contract("_ -> new")
    public static @NotNull Netease detail(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("detail")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 Detail_DJ 的请求地址
     *
     * @param id 未知 ID
     * @return the json element
     * @deprecated 由于 ID 未知, 待定
     */
    @Contract("_ -> new")
    public static @NotNull Netease detailDJ(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("detail_dj")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 DJ 的请求地址
     *
     * @param id     未知 ID
     * @param limit  限制参数, default : 20
     * @param offset 偏移参数, defalut : 0
     * @param asc    升序参数, defalut : false
     * @return the json element
     * @deprecated 由于 ID 未知, 待定
     */
    @Contract("_, _, _, _ -> new")
    public static @NotNull Netease dj(int id, @Nullable Integer limit, @Nullable Integer offset, @Nullable Boolean asc) {
        limit = limit == null ? 20 : limit;
        offset = offset == null ? 0 : offset;
        asc = asc != null && asc;
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("dj")
                        .addQuery("id", id)
                        .addQuery("limit", limit)
                        .addQuery("offset", offset)
                        .addQuery("asc", asc)
                        .build()
        );
    }

    /**
     * 此方法用于生成 Djradio 的请求地址
     *
     * @param id 电台 ID
     * @return the json element
     */
    @Contract("_ -> new")
    public static @NotNull Netease djradio(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("djradio")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 Lyric 的请求地址
     *
     * @param id 音乐 ID
     * @return the json element
     */
    @Contract("_ -> new")
    public static @NotNull Netease lyric(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("lyric")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 MV 的请求地址
     *
     * @param id MV ID
     * @return the json element
     */
    @Contract("_ -> new")
    public static @NotNull Netease mv(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("mv")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 PlayList 的请求地址
     *
     * @param id 歌单 ID
     * @return the json element
     */
    @Contract("_ -> new")
    public static @NotNull Netease playlist(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("playlist")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 Record 的请求地址
     *
     * @param id     the id
     * @param period 听歌记录时段类型, 详情参见 {@link Period}
     * @return the json element
     */
    @Contract("_, _ -> new")
    public static @NotNull Netease record(int id, @NotNull Period period) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("record")
                        .addQuery("id", id)
                        .addQuery("period", period.getPeriod())
                        .build()
        );
    }

    /**
     * 此方法用于生成 Search 的请求地址
     *
     * @param name       搜索名称
     * @param limit      限制参数, default : 20
     * @param offset     偏移参数, default : 0
     * @param searchType 搜索类型, 详情请参见 {@link SearchType}
     * @return the json element
     */
    @Contract("_, _, _, _ -> new")
    public static @NotNull Netease search(@NotNull String name, @Nullable Integer limit, @Nullable Integer offset, @Nullable SearchType searchType) {
        limit = limit == null ? 20 : limit;
        offset = offset == null ? 0 : offset;
        searchType = searchType == null ? SearchType.SONG : searchType;
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("search")
                        .addQuery("s", name)
                        .addQuery("limit", limit)
                        .addQuery("offset", offset)
                        .addQuery("search_type", searchType.getParameters())
                        .build()
        );
    }

    /**
     * 此方法用于生成 Song 的请求地址
     *
     * @param id 歌曲 ID
     * @param br 歌曲码率, 详情参见 {@link Br}
     * @return the json element
     */
    @Contract("_, _ -> new")
    public static @NotNull Netease song(int id, @Nullable Br br) {
        br = br == null ? Br.STANDARD : br;
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("song")
                        .addQuery("id", id)
                        .addQuery("br", br.getBr())
                        .build()
        );
    }

    /**
     * 此方法用于生成 User 的请求地址
     *
     * @param id 用户 ID
     * @return the json element
     */
    @Contract("_ -> new")
    public static @NotNull Netease user(int id) {
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("user")
                        .addQuery("id", id)
                        .build()
        );
    }

    /**
     * 此方法用于生成 User_PlayList 的请求地址
     *
     * @param id     用户 ID
     * @param limit  限制参数, default : 50
     * @param offset 偏移参数, default : 0
     * @return the json element
     */
    @Contract("_, _, _ -> new")
    public static @NotNull Netease userPlaylist(int id, @Nullable Integer limit, @Nullable Integer offset) {
        limit = limit == null ? 50 : limit;
        offset = offset == null ? 0 : offset;
        return new Netease(
                UrlBuilder
                        .of(api)
                        .addPath("netease")
                        .addPath("user_playlist")
                        .addQuery("id", id)
                        .addQuery("limit", limit)
                        .addQuery("offset", offset)
                        .build()
        );
    }
    
    public String request(){
        String json;
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
                    .header("User-Agent", "Java HttpClient")
                    .build();
            json = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (URISyntaxException | IOException | InterruptedException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
        return json;
    }
    public JsonElement toJsonElement(){
        return JsonParser.parseString(request());
    }
}
