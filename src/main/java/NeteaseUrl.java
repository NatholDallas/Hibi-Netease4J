import channel.record.Period;
import channel.search.SearchType;
import channel.song.Br;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.UrlBuilder;

@SuppressWarnings("unused")
public class NeteaseUrl {
    private static final String url = "https://api.obfs.dev/api";

    public static String album(int id){
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("album")
                .addQuery("id", id)
                .build();
    }
    /**
     * 次方法用于生成请求 Artist 的请求地址
     *
     * @param id 歌手 ID
     * @return the json element
     */
    public static String artist(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("artist")
                .addQuery("id", id)
                .build();
    }
    /**
     * 此方法用于生成 Comments 的请求地址
     *
     * @param id     歌曲 ID
     * @param limit  限制参数, default : 1
     * @param offset 偏移数量, default : 0
     * @return the json element
     */
    public static String comments(int id, @Nullable Integer limit, @Nullable Integer offset) {
        limit = limit == null ? 1 : limit;
        offset = offset == null ? 0 : offset;
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("comments")
                .addQuery("id", id)
                .addQuery("limit", limit)
                .addQuery("offset", offset)
                .build();
    }
    /**
     * 此方法用于生成 Detail 的请求地址
     *
     * @param id 音乐 ID
     * @return json element
     */
    public static String requestDetail(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("detail")
                .addQuery("id", id)
                .build();
    }
    /**
     * 此方法用于生成 Detail_DJ 的请求地址
     *
     * @param id 未知 ID
     * @return the json element
     * @deprecated 由于 ID 未知, 待定
     */
    public static String detailDJ(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("detail_dj")
                .addQuery("id", id)
                .build();
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
    public static String requestDJ(int id, @Nullable Integer limit, @Nullable Integer offset, @Nullable Boolean asc) {
        limit = limit == null ? 20 : limit;
        offset = offset == null ? 0 : offset;
        asc = asc != null && asc;
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("dj")
                .addQuery("id", id)
                .addQuery("limit", limit)
                .addQuery("offset", offset)
                .addQuery("asc", asc)
                .build();
    }
    /**
     * 此方法用于生成 Djradio 的请求地址
     *
     * @param id 电台 ID
     * @return the json element
     */
    public static String djradio(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("djradio")
                .addQuery("id", id)
                .build();
    }
    /**
     * 此方法用于生成 Lyric 的请求地址
     *
     * @param id 音乐 ID
     * @return the json element
     */
    public static String lyric(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("lyric")
                .addQuery("id", id)
                .build();
    }
    /**
     * 此方法用于生成 MV 的请求地址
     *
     * @param id MV ID
     * @return the json element
     */
    public static String mv(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("mv")
                .addQuery("id", id)
                .build();
    }
    /**
     * 此方法用于生成 PlayList 的请求地址
     *
     * @param id 歌单 ID
     * @return the json element
     */
    public static String requestPlaylist(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("playlist")
                .addQuery("id", id)
                .build();
    }
    /**
     * 此方法用于生成 Record 的请求地址
     *
     * @param id     the id
     * @param period 听歌记录时段类型, 详情参见 {@link Period}
     * @return the json element
     */
    public static String record(int id, @NotNull Period period) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("record")
                .addQuery("id", id)
                .addQuery("period", period.getPeriod())
                .build();
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
    public static String requestSearch(@NotNull String name, @Nullable Integer limit, @Nullable Integer offset, @Nullable SearchType searchType) {
        limit = limit == null ? 20 : limit;
        offset = offset == null ? 0 : offset;
        searchType = searchType == null ? SearchType.SONG : searchType;
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("search")
                .addQuery("s", name)
                .addQuery("limit", limit)
                .addQuery("offset", offset)
                .addQuery("search_type", searchType.getParameters())
                .build();
    }

    /**
     * 此方法用于生成 Song 的请求地址
     *
     * @param id 歌曲 ID
     * @param br 歌曲码率, 详情参见 {@link Br}
     * @return the json element
     */
    public static String requestSong(int id, @Nullable Br br) {
        br = br == null ? Br.STANDARD : br;
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("song")
                .addQuery("id", id)
                .addQuery("br", br.getBr())
                .build();
    }
    /**
     * 此方法用于生成 User 的请求地址
     *
     * @param id 用户 ID
     * @return the json element
     */
    public static String requestUser(int id) {
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("user")
                .addQuery("id", id)
                .build();
    }
    /**
     * 此方法用于生成 User_PlayList 的请求地址
     *
     * @param id     用户 ID
     * @param limit  限制参数, default : 50
     * @param offset 偏移参数, default : 0
     * @return the json element
     */
    public static String requestUserPlaylist(int id, @Nullable Integer limit, @Nullable Integer offset) {
        limit = limit == null ? 50 : limit;
        offset = offset == null ? 0 : offset;
        return UrlBuilder
                .of(url)
                .addPath("netease")
                .addPath("user_playlist")
                .addQuery("id", id)
                .addQuery("limit", limit)
                .addQuery("offset", offset)
                .build();
    }
}
