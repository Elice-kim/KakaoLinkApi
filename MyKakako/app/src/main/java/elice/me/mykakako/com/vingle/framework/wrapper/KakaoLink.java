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
//
//    private FeedTemplate mParams;
//
//    private KakaoLink(FeedTemplate mParams) {
//        this.mParams = mParams;
//    }

    //todo web url 연결만 다시 해보기
    public static void addKakaoLink(Context context, Data data) {
        FeedTemplate params =
                FeedTemplate.newBuilder(
                        ContentObject.newBuilder(data.title, data.imageUrl, LinkObject.newBuilder()
                                .setWebUrl(data.webUrl)
                                .setMobileWebUrl(data.webUrl)
                                .build())
                                .setDescrption(data.text)
                                .build())
                        .setSocial(SocialObject.newBuilder()
                                .setLikeCount(data.likeCount)
                                .setCommentCount(data.commentCount)
                                .setSharedCount(data.sharedCount)
                                .setViewCount(data.viewCount)
                                .build())
                        .addButton(new ButtonObject(data.buttonTextWeb,
                                LinkObject.newBuilder()
                                        .setWebUrl(data.webUrl)
                                        .build()))
                        .addButton(new ButtonObject(data.buttonTextApp,
                                LinkObject.newBuilder()
                                        .setWebUrl(data.webUrl)
                                        .build()))
                        .build();

        KakaoLinkService.getInstance()
                .sendDefault(context, params, new ResponseCallback<KakaoLinkResponse>() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {
                        Logger.e(errorResult.toString());
                    }

                    @Override
                    public void onSuccess(KakaoLinkResponse result) {

                    }
                });

    }

//    public void send(Context context) {
//        KakaoLinkService.getInstance()
//                .sendDefault(context, mParams, new ResponseCallback<KakaoLinkResponse>() {
//                    @Override
//                    public void onFailure(ErrorResult errorResult) {
//                        Logger.e(errorResult.toString());
//                    }
//
//                    @Override
//                    public void onSuccess(KakaoLinkResponse result) {
//
//                    }
//                });
//    }


//    public static class Builder {
//
//
//        public Builder(Context context) throws KakaoParameterException {
//        }
//
//        public Builder addImage(String url, int width, int height) {
//            return this;
//        }
//
//        public Builder addText(String text) {
//            return this;
//        }
//
//        public Builder addWebLink(String text, String url) {
//            return this;
//        }
//
//        public Builder addAppButton(String text, String param) {
//            return this;
//        }
//
//        public KakaoLink build() {
//            FeedTemplate params = null;
//            return new KakaoLink(params);
//        }
//    }
}
