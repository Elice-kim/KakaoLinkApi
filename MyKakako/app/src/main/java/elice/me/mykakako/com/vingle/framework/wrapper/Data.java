package elice.me.mykakako.com.vingle.framework.wrapper;

/**
 * Created by elice.kim on 2017. 8. 8..
 */

public class Data {
    public String title;
    public String imageUrl;
    public String webUrl;
    public String text;
    public String buttonTextWeb;
    public String buttonTextApp;
    public int likeCount;
    public int commentCount;
    public int sharedCount;
    public int viewCount;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setButtonTextWeb(String buttonTextWeb) {
        this.buttonTextWeb = buttonTextWeb;
    }

    public void setButtonTextApp(String buttonTextApp) {
        this.buttonTextApp = buttonTextApp;
    }

}
