package util;

@SuppressWarnings("unused")
public class UrlBuilder {
    private final StringBuilder url;
    private int pathSize = 0;
    private int querySize = 0;

    public UrlBuilder(String url){
        this.url = new StringBuilder(url);
    }

    public static UrlBuilder of(String url){
        return new UrlBuilder(url);
    }
    public UrlBuilder addPath(String path){
        url.append("/").append(path);
        pathSize++;
        return this;
    }
    public UrlBuilder addQuery(String key, Object value){
        if(querySize == 0) url.append("?");
        if(querySize >= 1) url.append("&");
        url.append(key).append("=").append(value.toString());
        querySize++;
        return this;
    }
    public String build(){
        return url.toString();
    }

    public int getPathSize() {
        return pathSize;
    }
    public int getQuerySize() {
        return querySize;
    }
}
