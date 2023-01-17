package gmail.sjtxm0320.moviereviewproject.dto;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Serializable(직렬화): 데이터를 전송할 때 객체 단위로 전송할 수 있도록 도와주는 인터페이스
public class MovieImageDTO implements Serializable {
    private String imgName;
    private String uuid;
    private String path;

    // 실제 이미지 경로를 리턴해주는 메서드
    public String getImageURL() {
        try {
            return URLEncoder.encode(path + "/" + uuid + imgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return "";
    }

    // Thumbnail 이미지 경로를 리턴하는 메서드
    public String getThumbnailURL() {
        try {
            return URLEncoder.encode(path + "/s_" + uuid + imgName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return "";
    }
}
