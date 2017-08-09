package elice.me.mykakako.com.vingle.framework.wrapper;

import android.content.Context;

import com.kakao.kakaolink.v2.KakaoLinkResponse;
import com.kakao.kakaolink.v2.KakaoLinkService;
import com.kakao.message.template.ButtonObject;
import com.kakao.message.template.ContentObject;
import com.kakao.message.template.FeedTemplate;
import com.kakao.message.template.LinkObject;
import com.kakao.message.template.SocialObject;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.util.helper.log.Logger;

/**
 * Created by ladmusician.kim on 08/08/2017.
 */

public class KakaoLink {

    private FeedTemplate mParams;

    private KakaoLink(FeedTemplate params) {
        mParams = params;
    }
    public static void addKakaoLink(Context context, Data data) {

        KakaoLink link = new Builder(context)
                .addText(data.text)
                .addImage(data.imageUrl, 0, 0)
                .addAppButton(data.buttonTextApp, "key1=value1")
                .addWebLink(data.buttonTextWeb, data.webUrl)
                .build();
        link.send(context);
    }

    public void send(Context context) {
        KakaoLinkService.getInstance()
                .sendDefault(context, mParams, new ResponseCallback<KakaoLinkResponse>() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        Logger.e(errorResult.toString());
                    }

                    @Override
                    public void onSuccess(KakaoLinkResponse result) {

                    }
                });
    }


    public static class Builder {


        private String mImageUrl;
        private int mImageWidth;
        private int mImageHeight;
        private String mDescription;
        private String mLinkUrl;
        private String mWebButtonText;
        private String mAppButtonText;

        public Builder(Context context) {
        }

        public Builder addImage(String url, int width, int height) {
            mImageUrl = url;
            mImageWidth = width;
            mImageHeight = height;
            return this;
        }

        public Builder addText(String text) {
            mDescription = text;
            return this;
        }

        public Builder addWebLink(String text, String url) {
            mWebButtonText = text;
            mLinkUrl = url;
            return this;
        }

        public Builder addAppButton(String text, String param) {
            mAppButtonText = text;
            //todo param에 들어갈 내용 채우기
            return this;
        }

        public KakaoLink build() {
            LinkObject linkObject =
                    LinkObject.newBuilder()
                            .setWebUrl(mLinkUrl)
                            .setMobileWebUrl(mLinkUrl)
                            .build();
            ContentObject contentObject =
                    ContentObject.newBuilder("Vingle", mImageUrl, linkObject)
                            .setImageWidth(mImageWidth)
                            .setImageHeight(mImageHeight)
                            .setDescrption(mDescription)
                            .build();
            SocialObject socialObject = SocialObject.newBuilder()
                    .setLikeCount(10)
                    .setCommentCount(20)
                    .setSharedCount(30)
                    .setViewCount(40)
                    .build();
            LinkObject buttonLinkObject = LinkObject.newBuilder()
                    .setWebUrl(mLinkUrl)
                    .setMobileWebUrl(mLinkUrl)
                    .build();

            ButtonObject button1 = new ButtonObject(mWebButtonText, buttonLinkObject);
            ButtonObject button2 = new ButtonObject(mAppButtonText, buttonLinkObject);
            FeedTemplate params =
                    FeedTemplate.newBuilder(contentObject)
                            .setSocial(socialObject)
                            .addButton(button1)
                            .addButton(button2)
                            .build();
            return new KakaoLink(params);

        }
    }
}
