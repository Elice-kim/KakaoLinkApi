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

    public static void addKakaoLink(Context context, String title, String imageUrl,
                                    String webUrl, String text, String buttonTextWeb,
                                    String buttonTextApp, int likeCount, int commentCount,
                                    int sharedCount){


        FeedTemplate params = FeedTemplate
                .newBuilder(ContentObject.newBuilder(title, imageUrl,
                        LinkObject.newBuilder().setWebUrl(webUrl).setMobileWebUrl(webUrl).build())
                        .setDescrption(text)
                        .build())
                .setSocial(SocialObject.newBuilder().setLikeCount(likeCount)
                        .setCommentCount(commentCount)
                        .setSharedCount(sharedCount).setViewCount(40).build())
                .addButton(new ButtonObject(buttonTextWeb,
                        LinkObject.newBuilder()
                                .setWebUrl(webUrl)
                                .setMobileWebUrl(webUrl)
                                .build()))
                .addButton(new ButtonObject(buttonTextApp,
                        LinkObject.newBuilder()
                        .setWebUrl(webUrl)
                        .setMobileWebUrl(webUrl)
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
}
